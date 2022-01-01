package com.E_bankingTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.E_bankingPageObject.AddNewCustomer;
import com.E_bankingPageObject.BaseClass;

public class Tc_LoginTest_003 extends BaseClass {

	AddNewCustomer ac;

	@Test
	public void addNewCustomer() throws InterruptedException {
		ac = new AddNewCustomer(driver);
		ac.verifyLogo();
		Assert.assertTrue(ac.verifyLogo(), "logo is present");
		ac.setUsername();
	    logger.info("Username passed");

		ac.setPassword();
		logger.info("password passed");
		ac.clickLogin();
		ac.selectNewCustomer();
		ac.CustomerName("Vipul");
		Thread.sleep(5000);
		ac.selectGender("m");
		Thread.sleep(5000);
		ac.selectdate("15-10-2021");
		ac.inputAddress("Pune");
		ac.selectState("Maharashtra");
		ac.selectPin("412307");
		
//	ac.verifyLinkActive("http://demo.guru99.com/v4/manager/Managerhomepage.php");
	// ac.verifyLinks();
	}
}
