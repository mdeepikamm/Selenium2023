package com.dee.test1;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstClass {
	@Test
	public void TestGoogle() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("testing",Keys.ENTER);
		String expectedTitle="testing - Google Search";
		String actualTitle=driver.getTitle();
		assertEquals(actualTitle, expectedTitle,"Title Mismatch");
		driver.quit();

	}
	@Test
	public void TestFacebook() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Allow all cookies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("testing",Keys.ENTER);
		Thread.sleep(2000);
		SoftAssert softAssert = new SoftAssert();
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Log in to Facebook";
		softAssert.assertEquals(actualTitle, expectedTitle,"Title Mismatch");
		System.out.println(actualTitle);
		
		//URL Assertion
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.facebook.com/45";
		softAssert.assertNotEquals(actualUrl, expectedUrl,"URL Mismatch");
		System.out.println(actualUrl);
		
		//Text Assertion
		String actualText = driver.findElement(By.id("email")).getAttribute("value");
		String expectedText= "";
		softAssert.assertEquals(actualText, expectedText,"Email is not empty");
		System.out.println(actualText);
		
		//Border Assertion
		String actualBorder = driver.findElement(By.id("email")).getCssValue("border");
		String expectedBorder= "1px solid rgb(240, 40, 73)";
		softAssert.assertEquals(actualBorder, expectedBorder,"Border Mismatch");
		System.out.println(actualBorder);
		
		//ErrorMessage Assertion
		String actualErrorMessage = driver.findElement(By.xpath("(//div[@id='email_container']/div)[2]")).getText();
		String expectedErrorMessage= "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage,"ErrorMessage Mismatch");
		System.out.println(actualErrorMessage);	
		
		driver.quit();
		softAssert.assertAll();

	}

}
