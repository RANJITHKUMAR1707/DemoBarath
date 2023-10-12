package com.test;

import org.testng.annotations.Test;

import com.Browser.BaseClass;
import com.Pom.Registerpage;

public class Login extends BaseClass{

	
	@Test(priority = 1)
	public static void ValidLoginTC_003() {
	    verifyURL(prop.getProperty("URL"));
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		verifytitle("My Account");
	}
	
	@Test(priority = 2)
	private static void INValidLoginTC_004() {
		Browserinfo();
		Registerpage.Login(prop.getProperty("INUN"), prop.getProperty("INPW"));
	    verifyisdisplay(Registerpage.Loginpageerror);
		Registerpage.checkabletonavigateregisterpage();
	}
	
	
	@Test(priority=3)
	public static void LogoutTC_005() {
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		Registerpage.Logoutusingcolumnoption();
	}
	
	@Test(priority=4,enabled=true)
	private static void LogoutTC_006() {
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		Registerpage.logoutusingdrowndown();
	}
}
