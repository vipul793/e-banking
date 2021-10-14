package com.E_bankingTestCases;

import org.testng.annotations.Test;
import com.E_bankingPageObject.AddNewCustomer;
import com.E_bankingPageObject.BaseClass;

public class Tc_LoginTest_003 extends BaseClass {

	AddNewCustomer ac;

	@Test
	public void addNewCustomer() throws InterruptedException {
		ac = new AddNewCustomer(driver);
		ac.verifyLogo();
		ac.setUsername();
		ac.setPassword();
		ac.clickLogin();
		ac.selectNewCustomer();
		ac.CustomerName("Vipul");
		Thread.sleep(5000);
		ac.selectGender("f");
		Thread.sleep(5000);
		ac.selectdate("15-10-2021");
		ac.inputAddress("Pune");
		
		ac.verifyLinkActive("http://demo.guru99.com/v4/manager/Managerhomepage.php");
		ac.verifyLinks();
	}
}
