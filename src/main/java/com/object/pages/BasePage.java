package com.object.pages;


import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	//globally initialized
	public static WebDriver driver;

	public String browser = "chrome";


	//using constructor
	//same name as classname

	public BasePage(){

		if(driver==null){
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Chrome\\chromedriver-win64\\chromedriver.exe");
			driver= new ChromeDriver();

		}
		else if(browser.equals("")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Chrome\\chromedriver-win64\\chromedriver.exe");
			driver= new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://adactinhotelapp.com/");

	}

	//exceptional handling
	public boolean elementFound(WebElement element){
		boolean result=element.isDisplayed();
		return result;
	}

	//textbox
	public void setText(WebElement element,String name){
		if(name!=null){
			element.click();
			element.clear();
			element.sendKeys(name);
		}

	}

	//attribute value
	public String getTextAttribute(WebElement element1){
		return element1.getAttribute("value");

	}

	//button click
	public void buttonClick(WebElement element2){
		element2.click();

	}

	//mouseover
	public void mouseover(WebElement element3){
		Actions ac= new  Actions(driver);
		ac.moveToElement(element3).build().perform();
	}

	//drag and drop
	public static void draganddrop(WebElement from,WebElement to){
		Actions ac =new Actions(driver);
		ac.dragAndDrop(from, to).perform();
	}

	//dropdown

	public String selectFromDropDown(WebElement element4,String option){
		Select obj =new Select(element4);
		obj.selectByIndex(0);
		obj.selectByValue(option);
		obj.selectByVisibleText(option);
		return obj.getFirstSelectedOption().getText();
	}
	
	//wait concept
	public boolean isElementVisible(WebElement element){
		try{
			WebDriverWait wait= new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public void quiteDriver(){
		driver.quit();
	}
	
	//scroll up and down
	public void scroll(String Page){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.ScrollT(0, document.body.scrollHeight");
	}


}




