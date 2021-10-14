package com.E_bankingPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
    public WebElement txtUsername;

	@FindBy(name = "password")
public	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	public WebElement btnLogin;
	
	@FindBy(xpath="(//ul[@class='menusubnav']/child::li)[15]")
	WebElement logoutbtn;

	public void setUserName(String usrname) {
		txtUsername.sendKeys(usrname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() {
		btnLogin.click();
	}
	public void clickOnLogoutbtn() {
		logoutbtn.click();
	}

}
