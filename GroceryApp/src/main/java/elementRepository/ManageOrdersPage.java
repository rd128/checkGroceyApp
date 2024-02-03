package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageOrdersPage {
	GeneralUtilities gu =new GeneralUtilities();
	WaitUtilities wu=new WaitUtilities();
	
	public ManageOrdersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	WebDriver driver;

	@FindBy(xpath="//a[@href='javascript:void(0)']")
	WebElement searchButton;
	
	@FindBy(xpath="//input[@name='od']")
	WebElement orderIdField;
	

	
	public void clickOnSearchButtonInManageOrdersPage() {
		wu.elementToBeClickable(driver, searchButton);
		gu.clickButton(searchButton);
	}
	public void enterOrderIdInManageOrderPageSearch() {
		gu.enterValue(orderIdField, "708");
	}
	
	/*
	 * public String findStatusOfanOrder(String orderStatus) { // identifying a
	 * unique column & storing in a List // List<WebElement> List1 =
	 * driver.findElements(By.
	 * xpath("//table[@class=\"table table-bordered table-hover table-sm\"]//tbody//tr//td[1]"
	 * ));
	 * 
	 * // dynamic xpath being stored as a String, declared as null String locator =
	 * null;
	 * 
	 * // iterate the List using for loop for (int i = 0; i < List1.size(); i++) {
	 * // check the value with required name u need if
	 * (List1.get(i).getText().equalsIgnoreCase(orderStatus)) {
	 * 
	 * // store that i value ulla xpath in locator locator =
	 * "//table[@id='dtBasicExample']//tbody//tr[" + (i + 1) + "]//td[4]"; break; }
	 * } // print the value WebElement reqValue =
	 * driver.findElement(By.xpath(locator)); System.out.println("value= " +
	 * reqValue.getText()); return
	 * 
	 * }
	 */
	

}
