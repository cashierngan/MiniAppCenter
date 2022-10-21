const express = require("express");
const path = require("path");
const fs = require("fs");
const HTMLParser = require("node-html-parser");
const { promisify } = require("util");
const app = express();
const port = 4000;

app.use(function(req, res, next) {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');
  next();
});

app.get("/", function (req, res) {
  res.send("Report API!");
});

app.get("/list-reports", function (req, res) {
  const dirPath = path.join(__dirname, "../ExtentReports/ExtentReport.html");
  const reportDirPath = path.join(__dirname, "/results");
  const reportFiles = fs.readdirSync(reportDirPath);

  function getData() {
    const fileList = [];
    const readFileAsync = promisify(fs.readFile);
    Promise.all(
      reportFiles.map((fileReport) =>
        readFileAsync(reportDirPath + `/${fileReport}`)
      )
    ).then((listReportFiles) => {
      listReportFiles.forEach((file, index) => {
        const root = HTMLParser.parse(file.toString());
        const getStatus = root.querySelector(".badge.fail-bg.log.float-right");
        const getName = root.querySelector(".test-detail .name");
        const getTimeCheck = root.querySelector(".badge.badge-success");
        fileList.push({
          id: reportFiles[index].replace(".html", ""),
          time: getTimeCheck.rawText,
          description: getName.rawText,
          status: getStatus.rawText,
          key: reportFiles[index].replace(".html", ""),
        });
      });
      res.json(fileList);
    });
  }

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
  }
});

app.get("/report/:fileName", function (req, res) {
  const resultDirpath = path.join(__dirname, "/results/" + req.params.fileName + '.html');
  res.sendFile(resultDirpath);
});

app.listen(port, function () {
  console.log(`Example app listening on port ${port}!`);
});
