
package com.priyankasingla.learningselenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountSignup {

	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Creating chrome driver navigating path
		System.setProperty("webdriver.chrome.driver", "C:\\Library\\chromdriver\\chromedriver.exe");

		// reference created directly
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get the URL
		wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		// Maximize browser
		wd.manage().window().maximize();

	}

	@Test
	public void verifyCustomerDetails() {

		/** Webpage one **/

		// object reference created
		WebElement email = wd.findElement(By.id("email_create"));
		// used web element and called with method name and given temporary value
		
		
		//adding random string so that we don't need to change emails each time. 
		Random r = new Random();
		String emailRandom = "email"+r.nextInt()+"@gmail.com";
		email.sendKeys(emailRandom);
		

		WebElement submitBtn = wd.findElement(By.id("SubmitCreate"));
		// used reference to call command click in order to submit form
		submitBtn.click();

		/** webpage 2 **/
		// Mr & Mrs
		// WebElement title = wd.findElement(By.xpath("//div[@id =
		// 'uniform-id_gender2']"));
		// used web element and called with method name and given temporary value
		// title.click();
		// System.out.println(title.isSelected());
		WebElement title = wd.findElement(By.id("id_gender2"));
		title.click();

		// First name
		// object reference created
		WebElement firstName = wd.findElement(By.id("customer_firstname"));
		// used web element and called with method name and given temporary value
		firstName.sendKeys("priyanka");

		// Last name

		WebElement lastName = wd.findElement(By.id("customer_lastname"));
		// used web element and called with method name and given temporary value
		lastName.sendKeys("Singla");

		// password

		WebElement password = wd.findElement(By.id("passwd"));
		// used web element and called with method name and given temporary value
		password.sendKeys("Singla@1234");

		// dob

		// Creating reference to store web browser element by id
		WebElement dobDate = wd.findElement(By.id("days"));
		// Creating reference variable with parameterized constructor of select class
		Select select1 = new Select(dobDate);
		// Selected visible text
		select1.selectByIndex(10);

		// Creating reference to store web browser element by id
		WebElement dobMonth = wd.findElement(By.id("months"));
		// Creating reference variable with parameterized constructor of select class
		Select select2 = new Select(dobMonth);
		// Selected visible text
		select2.selectByIndex(4);

		// Creating reference to store web browser element by id
		WebElement dobYear = wd.findElement(By.id("years"));
		// Creating reference variable with parameterized constructor of select class
		Select select3 = new Select(dobYear);
		// Selected visible text
		select3.selectByIndex(19);

		// sign up with news letters
		WebElement signupNewsLetter = wd.findElement(By.id("newsletter"));
		// used web element and called with method name and given temporary value
		signupNewsLetter.isSelected();

		// First Name

		WebElement addressFirstName = wd.findElement(By.id("firstname"));
		// used web element and called with method name and given temporary value
		addressFirstName.sendKeys("Priyanka");

		// Last Name

		WebElement addressLastName = wd.findElement(By.id("lastname"));
		// used web element and called with method name and given temporary value
		addressLastName.sendKeys("Singla");

		// Company
		WebElement company = wd.findElement(By.id("company"));
		// used web element and called with method name and given temporary value
		company.sendKeys("Invesco Investment Company");

		// Address
		WebElement address = wd.findElement(By.id("address1"));
		// used web element and called with method name and given temporary value
		address.sendKeys("4460 w shaw ave");

		// City
		WebElement city = wd.findElement(By.id("city"));
		// used web element and called with method name and given temporary value
		city.sendKeys("Fresno");
		
		//state
		
		WebElement state = wd.findElement(By.id("id_state"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText("California");

		// ZIP
		WebElement zip = wd.findElement(By.id("postcode"));
		// used web element and called with method name and given temporary value
		zip.sendKeys("93722");

	

		// Additional info
		WebElement additionalInfo = wd.findElement(By.id("other"));
		// used web element and called with method name and given temporary value
		additionalInfo.sendKeys("This is my First Signup.");

		// Home Phone

		WebElement phoneNo = wd.findElement(By.id("phone"));
		// used web element and called with method name and given temporary value
		phoneNo.sendKeys("8195073520");

		// Mobile number
		WebElement mobileNo = wd.findElement(By.id("phone_mobile"));
		// used web element and called with method name and given temporary value
		mobileNo.sendKeys("4836752131");

		// Assign an address alias for future reference
		WebElement aliasEmail = wd.findElement(By.id("alias"));
		// used web element and called with method name and given temporary value
		aliasEmail.sendKeys("121 Edwards Street");

		// register

		WebElement registerBtn = wd.findElement(By.id("submitAccount"));
		// used reference to call command click in order to submit form
		registerBtn.click();

	}

}
