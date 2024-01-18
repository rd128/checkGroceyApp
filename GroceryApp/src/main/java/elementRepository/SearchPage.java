package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class SearchPage {
	GeneralUtilities gu = new GeneralUtilities();

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(xpath = "//input[@id='od']")
	WebElement orderID;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;

	@FindBy(xpath = "//td[text()='Bank']")
	WebElement payement;

	@FindBy(xpath = "//a[text()='Change Status']")
	WebElement changeStatusBtn;

	@FindBy(id = "status")
	WebElement status;

	@FindBy(id = "Update_st")
	WebElement updateButton;
	
	
	public void enterOrderId(int i) {
		gu.enterValueNumeric(orderID, i);
	}

	public void clickSearch() {
		gu.clickButton(searchButton);
	}

	public String getPayementMode() {
		return gu.getElementText(payement);
	}

	public void clickOnChangeStatusButtonAfterSearchingforOrderInManageOrdersPage() {
		gu.clickButton(changeStatusBtn);
	}

	public void updateStatusofTheOrder(String newStatus) {

		gu.dropDownSelect(payement, newStatus);
	}

	public void clickOnUpdateButton() {
		gu.clickButton(updateButton);
	}



		
	}

