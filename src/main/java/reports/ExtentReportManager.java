package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/ExtentReport.html");
        reporter.config().setReportName("MiniApp Center Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java Framework | NganQC");
        extentReports.setSystemInfo("Author", "NganQC");
        return extentReports;
    }
}
