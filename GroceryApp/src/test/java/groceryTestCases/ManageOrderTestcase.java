package groceryTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageOrdersPage;
import elementRepository.SearchPage;
import utilities.ReadDataFromExcel;

public class ManageOrderTestcase extends BaseClass{
	
  @Test(priority = 1, groups = { "critical" })
  public void verifyOrderDetailsBySearchingWithOrderId() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  String usernameValue="admin";
	  String passwordValue="admin";
	  lp.enterusername(usernameValue);
	  lp.enterPassword(passwordValue);
	  lp.clickLoginbutton();
	  HomePage hp=new HomePage(driver);
	  hp.clickManageOrders();
	  ManageOrdersPage mop=new ManageOrdersPage(driver);
	  mop.clickOnSearchButtonInManageOrdersPage();
	  SearchPage sp=new SearchPage(driver);
	  sp.enterOrderId(ReadDataFromExcel.GetStringdata(0, 1));
	  sp.clickSearch();
	  String actual=sp.getPayementMode();
	  String expected="Bank";
	  Assert.assertEquals(actual, expected,"not verified");
	  
	
	  
  }
  
  @Test(priority = 1, groups = { "smoke" })
  public void verifyPayementmodeChangedtoDeliveredforOrder() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  String usernameValue="admin";
	  String passwordValue="admin";
	  lp.enterusername(usernameValue);
	  lp.enterPassword(passwordValue);
	  lp.clickLoginbutton();
	  HomePage hp=new HomePage(driver);
	  hp.clickManageOrders();
	  ManageOrdersPage mop=new ManageOrdersPage(driver);
	  mop.clickOnSearchButtonInManageOrdersPage();
	  SearchPage sp=new SearchPage(driver);
	  sp.enterOrderId(ReadDataFromExcel.GetStringdata(0, 1));
	  //sp.enterOrderId(ReadDataFromExcel.GetStringdata(1, 2));
	  sp.clickSearch();
	  sp.clickOnChangeStatusButtonAfterSearchingforOrderInManageOrdersPage();
	  sp.updateStatusofTheOrder("Delivered");
	  sp.clickOnUpdateButton();
  }
}
