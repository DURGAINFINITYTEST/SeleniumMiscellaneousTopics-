package first;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PdfReader {

	@Test
	public void getValidate() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		String url = "file:///D:/1.Automation(Selenium%20with%20java)/5.Framwork-01/Communication%20%20with%20team/10.Communication.pdf";

		driver.get(url);
		URL obj = new URL(url);
		InputStream inputs = obj.openStream();
		BufferedInputStream bf = new BufferedInputStream(inputs);
		PDDocument pdfdoc = PDDocument.load(bf);
		// count
		int count = pdfdoc.getNumberOfPages();
		Assert.assertEquals(count, 11);
		System.out.println("passed");
		// total document

		/*
		 * PDFTextStripper ps = new PDFTextStripper(); String totalDoc
		 * ==ps.getText(pdfdoc);
		 * System.out.println(totalDoc.contains("Dear Mr/Ms/Mrs Dupuis Dear Mary"););
		 * 
		 * System.out.println("2nd test passed");
		 * 
		 */
		// page starts from
		PDFTextStripper ps = new PDFTextStripper();
		ps.setStartPage(11);
		String totalDoc = ps.getText(pdfdoc);
		System.out.println(totalDoc);

	}

}
