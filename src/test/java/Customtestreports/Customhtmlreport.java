package Customtestreports;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Customhtmlreport implements IReporter {
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		String reportFile = outputDirectory + "/custom-report.html";
		try (FileWriter writer = new FileWriter(reportFile)) {
			writer.write("<html><head><title>TestNG Custom Report</title></head><body>");
			writer.write("<h1>TestNG Custom Report</h1>");
			for (ISuite suite : suites) {
				writer.write("<h2>Suite: " + suite.getName() + "</h2>");
				writer.write("<table border='1'><tr><th>Test</th><th>Passed</th><th>Failed</th><th>Skipped</th></tr>");
				Map<String, ISuiteResult> suiteResults = suite.getResults();
				for (ISuiteResult sr : suiteResults.values()) {
					ITestContext tc = sr.getTestContext();
					writer.write("<tr>");
					writer.write("<td>" + tc.getName() + "</td>");
					writer.write("<td>" + tc.getPassedTests().size() + "</td>");
					writer.write("<td>" + tc.getFailedTests().size() + "</td>");
					writer.write("<td>" + tc.getSkippedTests().size() + "</td>");
					writer.write("</tr>");
				}
				writer.write("</table>");
			}
			writer.write("</body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
