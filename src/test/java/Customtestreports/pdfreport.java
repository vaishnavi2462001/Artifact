package Customtestreports;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class pdfreport implements IReporter {
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		try (PDDocument document = new PDDocument()) {
			PDPage page = new PDPage();
			document.addPage(page);
			try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
				contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
				contentStream.beginText();
				contentStream.newLineAtOffset(100, 700);
				contentStream.showText("Test Execution Report");
				contentStream.endText();
				contentStream.setFont(PDType1Font.HELVETICA,12);
				contentStream.beginText();
				contentStream.newLineAtOffset(100, 650);
				int yPosition = 650;
				for (ISuite suite : suites) {
					contentStream.showText("Suite: " + suite.getName());
					contentStream.newLineAtOffset(0, -20);
					yPosition -= 20;
					for (ISuiteResult sr : suite.getResults().values()) {
						ITestContext tc = sr.getTestContext();
						String text = String.format("Test '%s': Passed=%d, Failed=%d, Skipped=%d", 
								tc.getName(),
								tc.getPassedTests().size(), 
								tc.getFailedTests().size(), 
								tc.getSkippedTests().size());
						if (yPosition < 100) {
							contentStream.endText();
							contentStream.close();
							// Add new page
							page = new PDPage();
							document.addPage(page);
							//contentStream = new PDPageContentStream(document, page);
							
							contentStream.setFont(PDType1Font.HELVETICA, 12);
							contentStream.beginText();
							contentStream.newLineAtOffset(100, 700);
							yPosition = 700;
							
						}
						
						contentStream.showText(text);
						contentStream.newLineAtOffset(0, -20);
						yPosition -= 20;
					}
				}
				
				contentStream.endText();
			}
			
			document.save(outputDirectory + "/test-report.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
