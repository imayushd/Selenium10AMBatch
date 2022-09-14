package com.timeKeeping.actiTime.selenium.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	//constructor will load all the findBy during object creation

	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;}
	
		//We are identifying all the elements
		@FindBy(id="username")
		private WebElement userNameTextField;
		
		@FindBy(name="pwd")
		private WebElement passwordTextField;
		
		@FindBy(xpath="//div[text()='Login ']")
		private WebElement loginButton;
		
		//getters methods


		public WebElement getUserNameTextField() {
			return userNameTextField;
		}

		public WebElement getPasswordTextField() {
			return passwordTextField;
		}

		public WebElement getLoginButton() {
			return loginButton;
		}
		
		//Business Logic/generic method for Login
		
		public void loginAction(String username,String password) {
			
			userNameTextField.sendKeys(username);
			passwordTextField.sendKeys(password);
			loginButton.click();
		}
		
		
		
		
		
		
		
		

}
