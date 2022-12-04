
package Extras;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportGenerator {

	private static ExtentReports extent;
	static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();

	public static ExtentReports ExtentReportGenerator() {
		String path = System.getProperty("user.dir") + "/Report/" + "index.html";

		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("Zapproved Report");
		spark.config().setDocumentTitle("Test Results");

		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "P");
		return extent;
	}

	public static void setExtentReport(ExtentTest test) {

		extenttest.set(test);

	}

	public static ExtentTest getExtentReport() {

		return extenttest.get();

	}

}
