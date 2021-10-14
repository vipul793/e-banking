package com.E_bankingTestCases;
import org.testng.annotations.Test;
import com.E_bankingPageObject.BaseClass;
import com.E_bankingPageObject.LoginPage;

public class Tc_LoginTest_001 extends BaseClass {

	@Test
	public void loggerinTest() {
		
		logger.info("Url is opened");
		
     	LoginPage lp = new LoginPage(driver);
		lp.setUserName("username");
		logger.info("User entered username");
		
		lp.setPassword("password");
		logger.info("User entered password");
		
		lp.clickSubmit();
		logger.info("User entered on login button");

		
	}

}
