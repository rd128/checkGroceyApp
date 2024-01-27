package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExplicit {

	
	public void waitForExplicit(WebDriver driver, String xpathValue) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
	}
}
