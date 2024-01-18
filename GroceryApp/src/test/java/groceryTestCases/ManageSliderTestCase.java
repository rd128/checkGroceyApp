package groceryTestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;

public class ManageSliderTestCase extends BaseClass {

	@Test
	public void verifyTheColorOfSaveButtonOnCLickingNewButtonInManageSliderPage() {
 
		
		  ManageSliderPage msp=new  ManageSliderPage(driver);
		  msp.clickOnNewButtonInManageSliderPage();

		String actual = msp.checkColorSaveButton();
		String expected = "rgba(255, 255, 255, 1)";
		Assert.assertEquals(actual, expected, Constant.error);

	}

	@Test
	public void verifyNavigationBackOnClickingCancelButtonInPopUpAfterCLickingNewButtonInManageSliderPage() {

		
		 
		ManageSliderPage msp = new ManageSliderPage(driver);
		msp.clickOnNewButtonInManageSliderPage();

		msp.clickCancelButton();
		String expected = "List Sliders";
		String actual = msp.getManageSliderLabel();
		Assert.assertEquals(actual, expected, Constant.error);
	}
}
