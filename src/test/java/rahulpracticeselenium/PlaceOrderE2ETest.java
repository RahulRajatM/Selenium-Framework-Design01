package rahulpracticeselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderE2ETest {

	//UserName- 123iamrajat@gmail.com, Password= P1ssword

	@Test
	public void placeOrder() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("userEmail")).sendKeys("123iamrajat@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("P1ssword");
		driver.findElement(By.id("login")).click();
		
	   driver.findElement(By.cssSelector("[class='card-body'] h5 b")).click();
		
		// Click Add to Cart button
		WebElement addToCartBtn = driver.findElement(By.cssSelector("button[wishlist='false']"));
		addToCartBtn.click();

		// Wait for and verify the success message
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toastMsg = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container .toast-success"))
		);
		String successText = toastMsg.getText();
		Assert.assertTrue(successText.contains("Product Added To Cart"), "Success message not found!");

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		System.out.println("Place Order E2E Test:: PASSED");
		// Optionally, close the browser
		driver.quit();
	}
}