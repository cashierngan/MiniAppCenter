const express = require("express");
const path = require("path");
const fs = require("fs");
const HTMLParser = require("node-html-parser");
const { promisify } = require("util");
const exec = require("child_process").exec;
const jsdom = require("jsdom");
const { JSDOM } = jsdom;
const axios = require("axios");
const hostname = "localhost";
const port = 4000;
const app = express();
const fetch = (...args) => import('node-fetch').then(({ default: fetch }) => fetch(...args));

let isRunning = false;

app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header(
    "Access-Control-Allow-Headers",
    "Origin, X-Requested-With, Content-Type, Accept"
  );
  next();
});

app.get("/", function (req, res) {
  res.send("Report API!");
});

app.get("/getVersion", async function (req, res) {
  const playStoreUrl = "https://play.google.com/store/apps/details?id=com.mservice.momotransfer";
  const appStoreUrl = "https://apps.apple.com/vn/app/momo-chuy%E1%BB%83n-ti%E1%BB%81n-thanh-to%C3%A1n/id918751511";

  async function getPlayStoreVersion() {
    const response = await axios(playStoreUrl);
    const dom = new JSDOM(response.data);
    const scripts = Array.from(dom.window.document.querySelectorAll("script"));
    const script = scripts.find((s) => s.textContent && s.textContent.includes("/store/apps/developer"));
    const versionStringRegex = /"[0-9]+\.[0-9]+\.[0-9.]+"/g;
    const matches = script.textContent.match(versionStringRegex);
    const match = matches[0] ?? null;
    const version = match?.replace(/"/g, "") ?? "N/A";
    return version;
  }

  async function getAppStoreVersion() {
    const res = await axios(appStoreUrl);
    const root = HTMLParser.parse(res.data.toString());
    const getStatus = root.querySelector(".whats-new__latest__version");
    const rawText = getStatus?.rawText || "";
    const version = rawText?.replace("Version", "").trim() ?? "N/A";
    return version;
  }

  try {
    const [appStoreVersion, playStoreVersion] = await Promise.all([
      getAppStoreVersion(),
      getPlayStoreVersion(),
    ]);

    res.json({
      playStoreVersion: playStoreVersion,
      appStoreVersion: appStoreVersion,
    });
  } catch (error) {
    console.log(error);
    res.json({
      error: error,
    });
  }
});

app.get("/run", (req, res) => {
  if (isRunning) {
    return res.json({
      error: "There is already a running job!"
    })
  }
  isRunning = true;
  exec(
    "cd /Users/ngan.dang/Testing/mini-app-center && mvn test --file /Users/ngan.dang/Testing/mini-app-center/pom.xml",
    async function (error, stdout, stderr) {
      isRunning = false;
      if (!error) {
        const response = await axios('http://localhost:4000/list-reports');
        const reports = response.data;
        if(reports?.data?.length > 0) {
          const notificationUrl = 'https://chat.googleapis.com/v1/spaces/AAAAU5PDKN4/messages?key=AIzaSyDdI0hCZtE6vySjMm-WEfRq3CPzqKqqsHI&token=7BcR6z4qA--YMx8GIgPu7OlfWMzIMq6zJsC-sCrcnew%3D&threadKey=23232326';
          const lastestTest = reports.data[0]
          const testView = `https://mac-testing.web.app/${lastestTest.id}`
          const message = JSON.stringify({
            text:
              `${'```'}Request Test Completed${'```'}` + 
              `View result: ${testView}`
          });
          try {
            fetch(notificationUrl, {
              method: 'post',
              headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
              },
              body: message,
            });
            res.json({
              status: 'Success',
              message: 'Send report success'
            });
          } catch (error) {
            console.log(error)
            return res.status(500).json(error.response)
          }
        }
      } else {
        res.json({
          status: "Failed",
          error: stdout,
        });
      }
    }
  );
  res.json({
    status: "Success",
    message: "Request run automation test success"
  });
});

app.get("/list-reports", function (req, res) {
  const pageSize = Number(req?.query?.pageSize) || 10;
  const pageIndex = Number(req?.query?.pageIndex) || 1;

  const dirPath = path.join(__dirname, "../../ExtentReports/ExtentReport.html");
  const reportDirPath = path.join(__dirname, "/results");
  const getReportFiles = fs.readdirSync(reportDirPath);

  const reportFiles = getReportFiles.reverse();

  const reportToGet = reportFiles.slice(
    (pageIndex - 1) * pageSize,
    pageSize * pageIndex
  );

  const getData = () => {
    const fileList = [];
    const readFileAsync = promisify(fs.readFile);
    try {
      Promise.all(
        reportToGet.map((fileReport) => {
          return readFileAsync(reportDirPath + `/${fileReport}`);
        })
      ).then((listReportFiles) => {
        listReportFiles.forEach((file, index) => {
          const root = HTMLParser.parse(file.toString());
          const getCountStatusSuccess = root.querySelectorAll(".badge.pass-bg.log.float-right")?.length || 0;
          const getCountStatusFail = root.querySelectorAll(".badge.fail-bg.log.float-right")?.length || 0;
          const getName = root.querySelector(".test-detail .name");
          const getTimeCheck = root.querySelector(".badge.badge-success");
          fileList.push({
            id: reportToGet[index].replace(".html", ""),
            time: getTimeCheck.rawText,
            description: getName.rawText,
            status: {
              totalIssue: Number(getCountStatusSuccess + getCountStatusFail),
              detail: [
                {
                  statusName: "Passed",
                  count: getCountStatusSuccess,
                },
                {
                  statusName: "Failed",
                  count: getCountStatusFail,
                },
              ]
            },
            key: reportToGet[index].replace(".html", ""),
          });
        });
        res.json({
          total: getReportFiles.length,
          pageSize: pageSize,
          pageIndex: pageIndex,
          data: fileList,
        });
      });
    } catch (error) {
      console.log(error);
      res.json({
        total: 0,
        pageSize: 1,
        pageIndex: 1,
        data: [],
      });
    }
  };

  function createUid(data) {
    const date = new Date(data);
    const year = date.getFullYear();
    const month = date.getMonth() + 1 < 10 ? `0${date.getMonth() + 1}` : date.getMonth() + 1;
    const day = date.getDate() < 10 ? `0${date.getDate()}` : date.getDate();
    const hour = date.getHours() < 10 ? `0${date.getHours()}` : date.getHours();
    const min = date.getMinutes() < 10 ? `0${date.getMinutes()}` : date.getMinutes();

    return (
      `${year.toString().slice(-2)}` + `${month}` + `${day}` + `${hour}` + `${min}`
    );
  }

  try {
    const readFile = fs.readFileSync("./logs.txt", "utf8");
    const lastChange = readFile.toString();
    fs.stat(dirPath, function (err, stats) {
      if (err) {
        console.log(err);
      } else {
        const changeTime = new Date(stats.mtime).toLocaleString();
        if (changeTime === lastChange) {
          getData();
        } else {
          fs.writeFileSync("./logs.txt", changeTime);
          const resultDirPath = path.join(__dirname, "/results/" + createUid(stats.mtime) + ".html");
          fs.copyFile(dirPath, resultDirPath, (err) => {
            if (err) throw err;
            getData();
          });
        }
      }
    });
  } catch (error) {
    console.log(error);
    res.json({
      error: error,
    });
  }
});

app.get("/report/:fileName", function (req, res) {
  try {
    const resultDirpath = path.join(__dirname, "/results/" + req.params.fileName + ".html");
    res.sendFile(resultDirpath);
  } catch (error) {
    console.log(error);
    res.json({
      error: error,
    });
  }
});

app.listen(port, function (err) {
  if (err) throw err;
  console.log(`> Ready on http://${hostname}:${port}`);
});
