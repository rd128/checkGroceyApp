package groceryTestCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

import utilities.Fakerutility;
import utilities.WaitExplicit;

public class LoginTestcase extends BaseClass {
	// to access driver, url access etc, extending the base class to avail them

	@Test(groups = { "critical" })
	public void verifyLogin() throws IOException {
		LoginPage lp = new LoginPage(driver);
		readFromProperties();
		String usernameValue = properties.getProperty("username");
		String passwordValue = properties.getProperty("password");
		lp.enterusername(usernameValue);
		lp.enterPassword(passwordValue);
		lp.clickLoginbutton();
		HomePage hp = new HomePage(driver);

		WaitExplicit we=new WaitExplicit();
		we.waitForExplicit(driver, hp.xpathHomePageText);
		String actual = hp.getUserText();
		String expected = "Admin";
		Assert.assertEquals(actual, expected, Constant.loginError);

	}

	@Test
	public void verifyIfRememberMeCheckBoxIsSelected() {
		LoginPage lp = new LoginPage(driver);
		lp.clickRememberCheckBox();
		Boolean actual = lp.clickRememberMeCheckBoxStatus();
		System.out.println(actual);
		Boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.error);

	}

	Fakerutility fu = new Fakerutility();

	@DataProvider(name = "data-provider")
	public Object[][] invalidLoginCreds() {
		return new Object[][] { { fu.getFakeFirstName(), "sddfdf" }, { fu.getFakeFirstName(), "lop" } };
	}

	@Test(dataProvider = "data-provider", groups = { "critical" })
	public void verifyInvalidCrentialInLoginpage(String name, String password) {
		LoginPage lp = new LoginPage(driver);

		lp.enterusername(name);
		lp.enterPassword(password);
		lp.clickLoginbutton();
		HomePage hp = new HomePage(driver);
		System.out.println(lp.getInvalidUserErrorMessage());
		String actual=lp.getInvalidUserErrorMessage();
		String expected="×\n"
				+ "Alert!\n"
				+ "Invalid Username/Password";
		Assert.assertEquals(actual, expected);
	}
}
