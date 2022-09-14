package com.timeKeeping.actiTime.seleniumAutomationTaskTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.timeKeeping.actiTime.selenium.genericUtility.BaseClass;
import com.timeKeeping.actiTime.selenium.pomRepository.CreateNewCustomerPage;
import com.timeKeeping.actiTime.selenium.pomRepository.HomePage;
import com.timeKeeping.actiTime.selenium.pomRepository.LoginPage;
import com.timeKeeping.actiTime.selenium.pomRepository.TaskPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCustomerInTaskTest extends BaseClass {
	//pacakage name -should be that of module in app
	//test class name -should be task name followed by test
	//test case name -should be manual test case name followed by test	
	@Test
	
	public  void createCustomerTest() throws EncryptedDocumentException, IOException  {
		//object creation statement
		HomePage home=new HomePage(driver);
		TaskPage task=new TaskPage(driver);
		CreateNewCustomerPage createCustomer=new CreateNewCustomerPage(driver);
		
		//getting random number
		int randomNo=jUtils.generateRandomNo(1000);
		//fetching data from excel sheet
		String expectedCustomerName=excel.fetchDataFromExelFile("Sheet2",1,0)+randomNo;
		String description=excel.fetchDataFromExelFile("Sheet2",1,1);
		
		//clicking on the task button
		home.clickOnTaskButton();
		//clicking on the new customer button
		task.clickOnNewCustomerButton();
		//creating customer
		createCustomer.createCustomerAction(expectedCustomerName, description);
		
		//verification
		String actualCustomerName=task.verifyCustomerName(expectedCustomerName);
		Assert.assertEquals(actualCustomerName, expectedCustomerName);
		Reporter.log("Pass: New Customer added succesfully",true);
		System.out.println("The Customer Name has been verified");
		
	}
		
}	
	/*	FileInputStream fis=new FileInputStream("./src/test/resources/PropertyDataFor10AM.properties");
		
		Properties property=new Properties();
		String url=property.getProperty("url");
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
		LoginPage login=new LoginPage(driver);
		login.loginAction(username, password);
		*/
		
		
		
		
		
		
		
		
			
		
	