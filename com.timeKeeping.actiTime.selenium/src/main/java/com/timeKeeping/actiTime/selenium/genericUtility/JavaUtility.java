package com.timeKeeping.actiTime.selenium.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

/**
 * This class contains java generic functions
 * @author Admin
 *
 */

public class JavaUtility {
	
	/**
	 * This method generate Random Number
	 * @param limit
	 * @return
	 */
	public int generateRandomNo(int limit) {
		Random random =new Random();
		return random.nextInt(limit);
	}
	
	/**
	 * This method fetch data from Property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String fetchDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/PropertyDataFor10AM.properties");
		Properties property=new Properties();
		property.load(fis);
		return property.getProperty(key);
	}

}
