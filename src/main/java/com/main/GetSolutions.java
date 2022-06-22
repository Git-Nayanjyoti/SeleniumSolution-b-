package com.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.base.Base;

public class GetSolutions extends Base{

	public static void main(String[] args) throws Exception {
		
		setBrowser(prop.getProperty("browser"), prop.getProperty("url"));
		driver.findElement(By.id("search")).sendKeys(prop.getProperty("problem") + Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")).click();
		List<WebElement> answersCollection = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[4]/div"))
				.findElements(By.tagName("div"));
		for (WebElement answer : answersCollection) {
			String str = "";
			///html/body/div[4]/div[2]/div[1]/div[4]/div/div[1]/div[2]/h3
			///html/body/div[4]/div[2]/div[1]/div[4]/div/div[2]/div[2]/h3
		}
		
	}
}
