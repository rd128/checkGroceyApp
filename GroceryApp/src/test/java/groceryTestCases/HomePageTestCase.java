package groceryTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SearchPage;

public class HomePageTestCase extends BaseClass {
	@Test(groups = { "critical" })
	public void verifyHomePageText() {
		LoginPage lp = new LoginPage(driver);
		String usernameValue = "admin";
		String passwordValue = "admin";
		lp.enterusername(usernameValue);
		lp.enterPassword(passwordValue);
		lp.clickLoginbutton();
		HomePage hp = new HomePage(driver);
		String actual = hp.getHomePageText();
		String expected = "7rmart supermarket***";
		Assert.assertEquals(actual, expected, Constant.error);

	}

	@Test
	public void verifyColoroftheLinkBlock() throws IOException {
		LoginPage lp = new LoginPage(driver);
		readFromProperties();
		String usernameValue = properties.getProperty("username");
		String passwordValue = properties.getProperty("password");
		lp.enterusername(usernameValue);
		lp.enterPassword(passwordValue);
		lp.clickLoginbutton();
		HomePage hp = new HomePage(driver);
		String actual = hp.getColorOfManagerUser();
		String expected = "rgba(255, 255, 255, 1)";
		Assert.assertEquals(actual, expected, Constant.error);
	}
}
