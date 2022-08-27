package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.amazon.base.AmazonBasePage;

public class LoginPage extends AmazonBasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By signIn = By.id("nav-link-accountList-nav-line-1");

	public void clickSignin() {
		getClick(signIn);
	}

	By createNewAccount = By.id("createAccountSubmit");

	public void clickCreateAmazonAccount() {
		getClick(createNewAccount);
	}

	By firstName = By.xpath("//input[@id='ap_customer_name']");
	By lastName = By.xpath("//input[@id='ap_customer_name']");

	public void getFirstAndLastName(String input, String input1) {
		getSendKey(createNewAccount, input);
		getSendKey(createNewAccount, input1);
	}

	By mobileNoOrEmail = By.xpath("//input[@id='ap_email']");

	public void getMobilenooremail(String input) {
		getSendKey(mobileNoOrEmail, input);
	}

	By newPassword = By.xpath("//input[@name='password'and @type='password']");

	public void getNewpassword(String input) {
		getSendKey(newPassword, input);
	}

	By reEnterNewPassword = By.xpath("//input[@name='passwordCheck']");

	public void reEnterNewpassword(String input) {
		getSendKey(reEnterNewPassword, input);
	}
}
