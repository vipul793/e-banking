package com.E_bankingPageObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	WebDriver driver;

	public AddNewCustomer(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(css = ".logo")
	WebElement logo;

	public boolean verifyLogo() {
		boolean Logo = logo.isDisplayed();
		return Logo;
	}

	@FindBy(name = "uid")
	WebElement setusername;

	public void setUsername() {
		setusername.sendKeys("mngr357958");
	}

	@FindBy(name = "password")
	WebElement setpassword;

	public void setPassword() {
		setpassword.sendKeys("rypabEz");
	}

	@FindBy(name = "btnLogin")
	public WebElement Loginbtn;

	public void clickLogin() {
		Loginbtn.click();
	}

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement newCustomer;

	public void selectNewCustomer() {
		newCustomer.click();
	}

	@FindBy(css = "[name='name']")
	WebElement inputCustomerName;

	public void CustomerName(String Customername) {
		inputCustomerName.sendKeys(Customername);
	}

	@FindBy(name = "rad1")
	List<WebElement> genderList;

	public void selectGender(String gender) {
		for (int i = 0; i < genderList.size(); i++) {
			if (genderList.get(i).getAttribute("value").equals(gender)) {

				genderList.get(i).click();
				break;
			} else {
				if (genderList.get(i).getAttribute("value").equals(gender)) {
					genderList.get(i).click();

				}
			}
		}
	}

	@FindBy(css = "[name='addr']")
	WebElement address;

	public void inputAddress(String inputAddress) {
		address.sendKeys(inputAddress);
	}

	@FindBy(id = "dob")
	WebElement date;

	public void selectdate(String selectDate) {
		date.sendKeys(selectDate);
	}

	@FindBy(name = "city")
	WebElement City;

	public void selectCity(String SelectCity) {
		City.sendKeys(SelectCity);
	}

	@FindBy(tagName = "a")
	List<WebElement> links;

	public void verifyLinks() {
		for (int i = 0; i < links.size(); i++) {

			WebElement el = links.get(i);
			String url = el.getAttribute("href");
			verifyLinkActive(url);
		}
		System.out.println(links.size());
	}

	public void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl); // URL is a class from java.net
			/*
			 * using url object make connection.. and openconnection is method and it will
			 * return object of HttpURLConnection class
			 */
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			// set timeout in miliseconds to verify links it is optional but it will allow
			// to wait till url to load
			urlconnection.setConnectTimeout(3000);
			urlconnection.connect();

			// now use get Response method to find out links are loaded or have error
			if (urlconnection.getResponseCode() == 200) {
				System.out.println(linkUrl + "--" + urlconnection.getResponseMessage());
			}
			if (urlconnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(
						linkUrl + "--" + urlconnection.getResponseMessage() + "--" + HttpURLConnection.HTTP_NOT_FOUND);
			}

		} catch (Exception e) {

		}

	}

}
