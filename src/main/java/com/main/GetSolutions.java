package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.base.Base;

public class GetSolutions extends Base{

	public static void main(String[] args) throws Exception {
		
		setBrowser(prop.getProperty("browser"), prop.getProperty("url")); //getting null pointer exception 
		driver.findElement(By.id("search")).sendKeys(prop.getProperty("problem") + Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")).click();
		Answers.add(Header);
		
		for(int i = 0; i < 10 ; i++) {
			Heading = driver.findElement(By
					.xpath("/html/body/div[4]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[2]/h3/a"));
			Answer = driver.findElement(By
					.xpath("/html/body/div[4]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[2]/div[1]"));
			Views = driver.findElement(By
					.xpath("/html/body/div[4]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[1]/div[3]/span[1]"));
			Votes = driver.findElement(By
					.xpath("/html/body/div[4]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[1]/div[1]/span[1]"));
			
			Answers.add(new String[] {
					Heading.getText(),
					Answer.getText(),
					Views.getText(),
					Votes.getText()
			}); 
			
			if(i % 3 == 0) {
				js.executeScript("window.scrollBy(0,100)", "");
			}
		}
		
		System.out.println(Answers.toString());
		
		writer.writeAll(Answers);
		writer.close();
		
		
			//answer
			///html/body/div[4]/div[2]/div[1]/div[4]/div/div[1]/div[2]/div[1]
			///html/body/div[4]/div[2]/div[1]/div[4]/div/div[3]/div[2]/div[1]
			
			//votes
			///html/body/div[4]/div[2]/div[1]/div[4]/div/div[9]/div[1]/div[1]/span[1]
			///html/body/div[4]/div[2]/div[1]/div[4]/div/div[10]/div[1]/div[1]/span[1]
			///html/body/div[4]/div[2]/div[1]/div[4]/div/div[4]/div[1]/div[1]/span[1]
			
			//Views
			///html/body/div[4]/div[2]/div[1]/div[4]/div/div[1]/div[1]/div[3]/span[1]
			///html/body/div[4]/div[2]/div[1]/div[4]/div/div[3]/div[1]/div[3]/span[1]
			
			//Heading
			///html/body/div[4]/div[2]/div[1]/div[4]/div/div[8]/div[2]/h3/a
			///html/body/div[4]/div[2]/div[1]/div[4]/div/div[9]/div[2]/h3/a
		
		
	}

	
}
