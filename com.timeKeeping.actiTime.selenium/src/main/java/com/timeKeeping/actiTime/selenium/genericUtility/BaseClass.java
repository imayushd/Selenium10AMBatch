package com.timeKeeping.actiTime.selenium.genericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.timeKeeping.actiTime.selenium.pomRepository.HomePage;
import com.timeKeeping.actiTime.selenium.pomRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass  {
	public WebDriver driver;
	public JavaUtility jUtils=new JavaUtility();
	public ExelUtility excel=new ExelUtility();
	
	@BeforeSuite
	public void bsConfig() {
		
		System.out.println("=====Database connectivity Establised =====");
		
	}
	
	@BeforeClass
	public void bcConfig() throws IOException  {
		String url=jUtils.fetchDataFromPropertyFile("url");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		System.out.println("=====Browser has been Launched =====");
		System.out.println("=====Navigate to the url =====");
		
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException {
		LoginPage login=new LoginPage(driver);
		String username=jUtils.fetchDataFromPropertyFile("username");
		String password=jUtils.fetchDataFromPropertyFile("password");
		login.loginAction(username, password);
		System.out.println("=====Logged in to the application=====");
		
	}
	
	@AfterMethod
	public void amConfig() {
		HomePage home=new HomePage(driver);
		home.logoutAction();
		System.out.println("=====Log out from the application=====");
		
	}
	@AfterClass
	public void acConfig() {
		driver.quit();
		System.out.println("=====Browser is closed=====");
		
	}
	@AfterSuite
	public void asConfig() {
		System.out.println("=====Database connectivity is closed=====");
		
	}
	

}
