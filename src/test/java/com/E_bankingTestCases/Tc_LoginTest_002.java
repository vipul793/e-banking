package com.E_bankingTestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.E_banking.Utilities.XLUtils;
import com.E_bankingPageObject.BaseClass;
import com.E_bankingPageObject.LoginPage;

public class Tc_LoginTest_002 extends BaseClass {
	XLUtils utils;
	LoginPage lp;
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String UserName, String Password) throws InterruptedException{
		lp = new LoginPage(driver);
		lp.setUserName(UserName);
		
		logger.info("User Name is Provided");
		lp.setPassword(Password);
		logger.info("Password is Provided");
		lp.clickSubmit();
	
		
		if(isAlertPresent()==true) {
			Thread.sleep(2000);
			driver.switchTo().alert().accept();//close alert
			
						//.assertTrue(false);
			logger.info("Login Failed");
		}
		else {
		//	Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickOnLogoutbtn();
			
		}
	
	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
		public String[][] getData() throws IOException{
	String path="D:\\e-banking\\src\\test\\java\\com\\E_banking\\TestData\\InputData.xlsx";
	utils= new XLUtils(path);
	int rownum=utils.getRowCount("UserName");
	  int colcount= utils.getCellCount("UserName", 1);
		String LoginData[][]=new String [rownum][colcount];
		for(int i=1; i<=rownum; i++) {
			for(int j=0; j<colcount;j++) {
				LoginData[i-1][j]=utils.getCellData("UserName", i, j);
				
			}
		}
		return LoginData;
	}
	

}
