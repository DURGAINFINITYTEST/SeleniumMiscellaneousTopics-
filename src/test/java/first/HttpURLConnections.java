package first;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HttpURLConnections {

	public static void main(String[] args) throws Exception {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new HtmlUnitDriver();

		driver.get("https://www.earnly.in/");
		ArrayList<String> list = new ArrayList<String>();
		List<WebElement> totalList = driver.findElements(By.tagName("a"));
		int count = driver.findElements(By.tagName("a")).size();

		for (WebElement one : totalList) {

			String url = one.getAttribute("href");
			list.add(url);
			list.parallelStream().forEach(e->{
				try {
					forBrokenLink(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			// forBrokenLink(url);

		}

	}

	public static void forBrokenLink(String eachUrl) throws IOException {

		URL url = new URL(eachUrl);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.connect();
		if (http.getResponseCode() >= 400) {

			System.out.println(eachUrl + " is broken " + http.getResponseMessage() + http.getResponseCode());
		} else {
			System.out.println(http.getResponseMessage() + "responce code is" + http.getResponseCode());
		}

	}
}