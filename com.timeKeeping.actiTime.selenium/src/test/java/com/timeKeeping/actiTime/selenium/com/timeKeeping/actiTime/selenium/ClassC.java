package com.timeKeeping.actiTime.selenium.com.timeKeeping.actiTime.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassC {
	@Test
	public void demo1(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("This is demo 4");	
	}
	
}
