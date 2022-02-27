package com.pippin.demotest;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OrderNumberVerification extends BaseTest {
	@Test
	public void orderNumberVerificationTest() throws InterruptedException

	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/app-root/div/div/flex/div/div[1]/app-sidebar/ul/li[1]")).click();
		orderDisplayVerification();
		logout();

	}

	private void logout() {
		//Arrow button click
		driver.findElement(By.xpath("//i[@class='material-icons css-p4x832']")).click();
		//Logout 
		driver.findElement(By.xpath("//button[text()='Logout']")).click();
	}

	private void orderDisplayVerification() {
		// order search
		String orderid = driver.findElement(By.xpath("//span[@class='wrapInSingleLine']")).getText();
		// Sending order number to search field
		driver.findElement(By.xpath("//input[@ng-reflect-id='homeInpSearch']")).sendKeys(orderid);
		// Order existence verification
		WebElement orderlist = driver.findElement(By.xpath("//tr[@class='ng-star-inserted']"));
		assertTrue(orderlist.isDisplayed());
	}
}
