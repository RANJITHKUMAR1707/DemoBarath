package com.test;

import org.testng.annotations.Test;

import com.Pom.Registerpage;

public class Login extends BaseClass{

	
	@Test(priority = 1)
	private static void ValidLoginTC_001() {
	    verifyURL(prop.getProperty("URL"));
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		verifytitle("My Account");
	}
	
	@Test(priority = 2)
	private static void INValidLoginTC_002() {
		Browserinfo();
		Registerpage.Login(prop.getProperty("INUN"), prop.getProperty("INPW"));
	    verifyisdisplay(Registerpage.Loginpageerror);
		Registerpage.checkabletonavigateregisterpage();
	}
	
	
	@Test(priority=3)
	private static void LogoutTC_003() {
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		Registerpage.Logout();
	}
	
}
