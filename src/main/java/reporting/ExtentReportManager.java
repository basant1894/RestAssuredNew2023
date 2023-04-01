package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {
    public static ExtentReports extentReports;
    public static ExtentReports createInstance(String filename, String reportName, String documentTitle) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filename);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }
    public static String getReportNameWithTimeStamp(){
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);
        String reportName = "TestReport" + formattedTime + ".html";

        return reportName;
    }
    public static void logPassDetails(String log) {
        SetUp.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }
    public static void logFailureDetails(String log) {
        SetUp.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }
    public static void logSkippedDetails(String log) {
        SetUp.extentTest.get().skip(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }
    public static void logInfoDetails(String log) {
        SetUp.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.TEAL));
    }
    public static void logWarningDetails(String log) {
        SetUp.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }
}
