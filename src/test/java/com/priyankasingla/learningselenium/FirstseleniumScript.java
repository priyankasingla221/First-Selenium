package com.priyankasingla.learningselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** Automation: **/
public class FirstseleniumScript {

	WebDriver webDriver;

	@BeforeMethod
	public void setUp() {
		
		//Creating chrome driver navigating path
		System.setProperty("webdriver.chrome.driver", "C:\\Library\\chromdriver\\chromedriver.exe");
		
		//reference created directly
		webDriver = new ChromeDriver();

		// get the URL
		webDriver.get("http://automationpractice.com/index.php?controller=contact");
		
		//Maximize browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void sendkeysTest() {
		
		//Creating reference to store web browser element by id
		WebElement heading = webDriver.findElement(By.id("id_contact"));
		//Creating reference variable with parameterized constructor of select class
		Select select = new Select(heading);
		//Selected visible text
		select.selectByVisibleText("Webmaster");
		
		
		//object reference created
		WebElement email = webDriver.findElement(By.id("email"));
		//used web element and called with method name and given temporary value
		email.sendKeys("priyankasingla@gmail.com");

		//Similar as above one
		WebElement orderReference = webDriver.findElement(By.id("id_order"));
		//Temporary value to Order reference field 
		orderReference.sendKeys("IVU78546");

		WebElement message = webDriver.findElement(By.id("message"));
		//Temporary value to Message field 
		message.sendKeys("Please let me know status of my Order IVU78546.");
		
		
		WebElement submitBtn = webDriver.findElement(By.id("submitMessage"));
		//used reference to call command click in order to submit form
		submitBtn.click();
			
		//used reference variable of chrome driver to quit web browser
		webDriver.quit();
		
		
	
		

	}

}
