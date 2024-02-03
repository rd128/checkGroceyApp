package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	
	
	public void presenceOfElement(WebDriver driver, String xpathValue) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
	}
	public void presenceOfAlert(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10000));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void presenceOfText(WebDriver driver,WebElement element,String text) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10000));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public void elementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10000));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	

}
