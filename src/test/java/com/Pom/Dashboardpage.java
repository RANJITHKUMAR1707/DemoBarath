package com.Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.BaseClass;

public class Dashboardpage extends BaseClass{


	@FindBy(xpath="//a[contains(@title,'My Account')]")
	private static WebElement MyAccountdropdown;


	@FindBy(xpath="//li/a[contains(.,'Register')]")
	private static WebElement Register;

	@FindBy(xpath="//li/a[contains(.,'Login')]")
	private static WebElement Login;
/**
 * Navigate to Register page from dashboard
 */
	public static void NavigatetoRegisterpage() {
		clickelement(MyAccountdropdown);
		clickelement(Register);
	}

	/**
	 * Navigate to Login Page from dashboard
	 *
	 */
	public static void NavigatetoLoginpage() {
		clickelement(MyAccountdropdown);
		clickelement(Login);
	}
}
