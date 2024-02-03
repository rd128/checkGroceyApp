package elementRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

import utilities.WaitUtilities;

public class HomePage {
	
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtilities wu=new WaitUtilities();

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	WebDriver driver;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	WebElement user;
	
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	WebElement homePageText;
	
	public String xpathHomePageText="//span[text()='7rmart supermarket']";
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order'])[1]")
	WebElement manageOrders;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider'])[1]")
	WebElement manageSlider;
	
	@FindBy(xpath="(//p[text()='Manage Users'])[1]")
	WebElement manageUsers;	
	public String getColorOfManagerUser() {
	return gu.getColorCssValue(manageUsers);
	}
	public String getUserText() {
		wu.presenceOfElement(driver, "//a[@data-toggle='dropdown']");
		return gu.getElementText(user);
	}
	public String getHomePageText() {
		wu.presenceOfText(driver, homePageText,"7rmart supermarket" );
		return gu.getElementText(homePageText);
	}
	public void clickManageOrders() {
		
		gu.clickButton(manageOrders);
	}
	
	public void clickmanageSlider() {
		gu.clickButton(manageSlider);
	}
	
}
