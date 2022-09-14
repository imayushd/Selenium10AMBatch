package com.timeKeeping.actiTime.selenium.com.timeKeeping.actiTime.selenium;

import org.testng.annotations.Test;



public class ToPerformGroupExecution {
	@Test(groups="smokeTesting")
	public void login(){
		
		System.out.println("Login is succesful");	
	}
	@Test(groups="regressionTesting")
	public void select(){
		
		System.out.println("Product is selected");	
	}
	@Test(groups="regressionTesting")
	public void addToCart(){
		
		System.out.println("Product is added to the cart");	
	}
	@Test(groups="regressionTesting")
	public void payment(){
		
		System.out.println("Payment is succesful");	
	}
	
	@Test(groups="smokeTesting")
	public void logOut(){
		
		System.out.println("Logged out succesfully");	
	}
	
}
