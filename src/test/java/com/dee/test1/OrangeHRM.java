package com.dee.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	@BeforeTest
	 public void InitialiseBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterTest 
	public void TearDown()
	{
		driver.quit();
	}
	
	
	@Test
	public void LaunchApp() throws InterruptedException{	
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
	}
	@Test
	public void EnterLoginDetails() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	}
	@Test	
	public void VerifyLoginDetails() {
		WebElement element = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']"));
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());
		

	}
	@Test
	public void NavigateToMyInfo() throws InterruptedException {
		driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
		Thread.sleep(2000);

	}
	@Test
	public void VerifyMyInfo() {
		WebElement element1= driver.findElement(By.xpath("//h6[normalize-space()='PIM']"));
		System.out.println(element1.isDisplayed());
		System.out.println(driver.getCurrentUrl());
	

	}

}