package com.actiTime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genricUtility.WebUtility;

public class LoginPage 
{
	@FindBy(id="username")
	private WebElement usernameTextField;
	
	@FindBy(name="pwd")
	private WebElement passwordTextField;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement keepLoggedInCheckBox;

	@FindBy(xpath = "//a[@id='loginButton']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getKeepLoggedInCheckBox() {
		return keepLoggedInCheckBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	

	public void loginToAppWithValidCredentials(String uSERNAME, String pASSWORD) {
		// TODO Auto-generated method stub
		usernameTextField.sendKeys(uSERNAME);
		passwordTextField.sendKeys(pASSWORD);
		loginButton.click();
	}


}
