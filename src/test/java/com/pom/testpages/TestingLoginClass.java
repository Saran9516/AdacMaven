package com.pom.testpages;

import org.junit.Test;

import com.object.pages.BasePage;
import com.object.pages.LoginCredentials;
public class TestingLoginClass {
	
	BasePage bp;
	LoginCredentials lc;
	
	
	//using constructor
	//same name as classname
	
	public TestingLoginClass(){
		
		//creating object
		
		bp=new BasePage();
		lc=new LoginCredentials();
		
	}
	@Test
	public void openAdactinHotel() throws InterruptedException{
		Thread.sleep(3000);
		
		bp.setText(lc.getUsername(), "SaravananSaran");
		bp.setText(lc.getPassword(), "Saran@123");
		bp.buttonClick(lc.getLogin());
		
	}

}
