package com.priyankasingla.learningselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OderPlacementProcess {

	WebDriver wd;
	WebDriverWait wait;
	Actions action;

	@BeforeMethod
	public void setUp() {

		// Creating chrome driver navigating path
		System.setProperty("webdriver.chrome.driver", "C:\\Library\\chromdriver\\chromedriver.exe");

		// reference created directly
		wd = new ChromeDriver();

		// wait = new WebDriverWait(wd, 10);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get the URL
		wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		// Maximize browser
		wd.manage().window().maximize();

	}

	@Test
	public void orderPlacement() {
		action = new Actions(wd);

		// Sending random email
		WebElement emailAddress = wd.findElement(By.cssSelector("input[id='email'][name='email']"));
		emailAddress.sendKeys("Priyankasingla@gmail.com");

		// Sending random password
		WebElement password = wd.findElement(By.cssSelector("input[id='passwd'][name='passwd']"));
		// used web element and called with method name and given temporary value
		password.sendKeys("Singla@1234");

		// Sign in button
		WebElement signIn = wd.findElement(By.id("SubmitLogin"));
		action.click(signIn).perform();

		System.out.println("*******SINGIN Succesfull*******");

		Assert.assertEquals(wd.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account",
				"Not Directed to username Webpage!");
		System.out.println("Directed to your account Webpage.");
		
		// Assert for the Account
				WebElement userConfirmation = wd.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
				String accountConfirmation = userConfirmation.getText();
				Assert.assertEquals(accountConfirmation, "priyanka Singla", "User not Logged in.");
				System.out.println("Assertion passed! Welcome Priyanka Singla...");
		
		

		WebElement womenTab = wd.findElement(By.className("sf-with-ul"));
		womenTab.click();
		
		
		WebElement quickView = wd.findElement(By.cssSelector("img[title='Faded Short Sleeve T-shirts']"));
		quickView.click();
		//wd.findElement(By.xpath("//span[contains(text(),'Quick view')]")).click();
		

		wd.switchTo().frame(0);
		System.out.println("Switching to Iframe");
		System.out.println("Product Selected: Shorts");

		// Increase qty to 2
		WebElement quantityIncrement = wd
				.findElement(By.cssSelector(".btn.btn-default.button-plus.product_quantity_up"));
		quantityIncrement.click();
		System.out.println("Quantity Incremented to: 2");

		// Select size as L
		// Creating reference to store web browser element by id
		WebElement size = wd.findElement(By.cssSelector(".form-control.attribute_select.no-print"));
		// Creating reference variable with parameterized constructor of select class
		Select select = new Select(size);
		// Selected visible text
		select.selectByVisibleText("L");
		System.out.println("Size selected: L");

		// Click on Add to Cart
		WebElement addToCartBtn = wd.findElement(By.cssSelector("button[type='submit'][name ='Submit']"));
		addToCartBtn.submit();
		System.out.println("Adding to Cart...");

		// Assert total price, should be
		// same as previous page
		WebElement totalPrice = wd.findElement(By.cssSelector("span[id='total_price']"));
		String price = totalPrice.getText();
		Assert.assertEquals(price, "$35.02", "Price is not Same!");
		System.out.println("Assertion Passed! Price is : 32.02");

		// Click on procced to checkout
		WebElement checkOutBtn = wd
				.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium"));
		checkOutBtn.click();
		System.out.println("Checked Out...");

		// text area Comments
		WebElement comments = wd.findElement(By.cssSelector("textarea[name = 'message']"));
		comments.sendKeys("Its a Gift!");
		System.out.println("Message: Its a Gift!");

		// Procced to pay
		WebElement proccedToPay = wd.findElement(By.cssSelector("button[type='submit'][name='processAddress']"));
		proccedToPay.submit();
		System.out.println("Procced to pay...");

		// Check marked read privacy
		WebElement selectCheckBox = wd.findElement(By.id("cgv"));
		selectCheckBox.click();
		System.out.println("Read Tearms and Condtions. CheckMarked!");

		// Procced to standard processing
		WebElement standardProcced = wd.findElement(By.cssSelector("button[name= 'processCarrier'][type='submit']"));
		standardProcced.click();
		System.out.println("Delievery: Standard Process!");

		// Paying by wire
		WebElement payByWire = wd.findElement(By.cssSelector("a[title='Pay by bank wire']"));
		payByWire.click();
		System.out.println("Payment Method: ByWire");

		// Assert the payment method text
		WebElement paymentMethod = wd.findElement(By.className("page-subheading"));
		String payMethod = paymentMethod.getText();
		Assert.assertEquals(payMethod, "BANK-WIRE PAYMENT.", "Payment Method is not Correct!");
		System.out.println("Assertion Passed! Payment method Confirmed!");

		// Final submit button
		WebElement finalSubmit = wd
				.findElement(By.cssSelector("button[type='submit'][class='button btn btn-default button-medium']"));
		action.click(finalSubmit).perform();
		System.out.println("*******Order Placed*******");

		// Assert the order confirmation
		WebElement orderConfirmation = wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong"));
		String confirmation = orderConfirmation.getText();
		Assert.assertEquals(confirmation, "Your order on My Store is complete.", "Order is not Completed!");
		System.out.println("Assertion passed! Order is completed!");
		
	}

}
