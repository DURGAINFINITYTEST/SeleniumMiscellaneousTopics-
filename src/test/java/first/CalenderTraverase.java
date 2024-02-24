package first;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderTraverase {

	public static void main(String[] args) throws Exception {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.abhibus.com/");

		driver.findElement(By.id("datepicker1")).click();

		WebElement monthyr = driver.findElement(By.className("ui-datepicker-month"));
		Thread.sleep(2000);

		if (!monthyr.getText().equalsIgnoreCase("May")) {
			driver.findElement(By.linkText("Next")).click();

		}

		List<WebElement> total = driver.findElements(By.className("ui-state-default"));
		for (WebElement one : total) {
			if (one.getText().equalsIgnoreCase("24")) {
				one.click();

			}
		}

	}

}
