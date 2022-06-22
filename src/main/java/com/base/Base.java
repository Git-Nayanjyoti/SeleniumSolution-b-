package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Base() {
		try {
			FileInputStream file = new FileInputStream("./src/main/java/com/config/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!");
		} catch(IOException e) {
			System.out.println("Unable to read the file!!!");
		}
	}
	
	// method for initialising the browser with the url 
	public static void setBrowser(String browser, String url) {
		if(browser.toLowerCase().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.toLowerCase().equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browser.toLowerCase().equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			
		}else if(browser.toLowerCase().equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else {
			System.out.println("Browser not found.\n !!Please configure the Browser name.");
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	

}
