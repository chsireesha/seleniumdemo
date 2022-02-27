package com.pippin.demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	static WebDriver driver = null;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anchu\\Downloads\\chromedriver_win32_98\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		driver = new ChromeDriver(options);
		openSite();
		login();
	}

	private static void openSite() {
		// Open website
		driver.navigate().to("https://demo.pippintitle.com/");
		// wait for loading website
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.urlContains("login"));
		// maximize window
		driver.manage().window().maximize();
	}

	private static void login() throws InterruptedException {
		// Enter Email
		driver.findElement(By.id("Email_Address")).sendKeys("pippintitle_demotest@mailinator.com");
		Thread.sleep(2000);
		// Enter Password
		driver.findElement(By.id("User_Password")).sendKeys("DemoTest#567#");
		Thread.sleep(1000);
		// click on Go button
		driver.findElement(By.id("loginBtnLogin")).click();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		if (driver != null) {
			driver.close();
		}
	}

}
