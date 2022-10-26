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

  async function getAppStoreVersion() {
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

  async function getPlayStoreVersion() {
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
  exec(
    "cd /Users/ngan.dang/Testing/MiniAppCenter && mvn test --file /Users/ngan.dang/Testing/MiniAppCenter/pom.xml",
    function (error, stdout, stderr) {
      if (!error) {
        res.redirect("http://localhost:3000");
      } else {
        res.json({
          status: "failed",
          error: stdout,
        });
      }
    }
  );
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
          const getStatus = root.querySelector(".badge.log.float-right");
          const getName = root.querySelector(".test-detail .name");
          const getTimeCheck = root.querySelector(".badge.badge-success");
          fileList.push({
            id: reportToGet[index].replace(".html", ""),
            time: getTimeCheck.rawText,
            description: getName.rawText,
            status: getStatus.rawText,
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
    const month =
      date.getMonth() + 1 < 10
        ? `0${date.getMonth() + 1}`
        : date.getMonth() + 1;
    const day = date.getDate() < 10 ? `0${date.getDate()}` : date.getDate();
    const hour = date.getHours() < 10 ? `0${date.getHours()}` : date.getHours();
    const min =
      date.getMinutes() < 10 ? `0${date.getMinutes()}` : date.getMinutes();

    return (
      `${year.toString().slice(-2)}` +
      `${month}` +
      `${day}` +
      `${hour}` +
      `${min}`
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
          const resultDirPath = path.join(
            __dirname,
            "/results/" + createUid(stats.mtime) + ".html"
          );
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
    const resultDirpath = path.join(
      __dirname,
      "/results/" + req.params.fileName + ".html"
    );
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
