package Customtestreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Extenthtmlreport implements ITestListener {
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public static void setupExtentReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
		spark.config().setDocumentTitle("Test Automation Report");
		spark.config().setReportName("Regression Test Suite");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	@Override
	public void onStart(ITestContext context) {
		if (extent == null) {
			setupExtentReport();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
		test.get().fail(result.getThrowable());
		// Add screenshot if available
		// test.get().addScreenCaptureFromPath("screenshot.png");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, MarkupHelper.createLabel("Test Skipped", ExtentColor.YELLOW));
		test.get().skip(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
