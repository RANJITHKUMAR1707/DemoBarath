package com.Pom;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.BaseClass;

public class Registerpage extends BaseClass{
	

	@FindBy(xpath="//input[@name='firstname']")
	private static WebElement Firstname;


	@FindBy(xpath="//input[@name='lastname']")
	private static WebElement Lastname;

	@FindBy(xpath="//input[@name='email']")
	private static WebElement Emailid;

	@FindBy(xpath="//input[@name='telephone']")
	private static WebElement Phone;

	@FindBy(xpath="//input[@name='password']")
	private static WebElement Password;

	@FindBy(xpath="//input[@name='confirm']")
	private static WebElement ConfirmPassword;


	@FindBy(xpath="//label[text()='Yes']/input")
	private static WebElement YesNewsletter;

	@FindBy(xpath="//input[@name='agree']")
	private static WebElement privacypolicy;

	@FindBy(xpath="//input[@type='submit']")
	private static WebElement buttons;


	@FindBy(xpath="//div[@class='text-danger']")
	private static WebElement errormessage;

	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private static WebElement privacypolicyerrormessage;

	@FindBy(xpath="//div[@class='text-danger']")
	private static List<WebElement> fielderror;

	@FindBy(xpath="//input[@name='confirm']/following::div[@class='text-danger']")
	private static WebElement passwordmismatch;

	@FindBy(xpath="//div[@id='content']/h1[contains(.,'Your Account Has Been Created')]")
	private static WebElement Registersuccessfullmessage;

	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	public static WebElement Loginpageerror;
	
	@FindBy(xpath="//a[contains(.,'Continue')]")
	private static WebElement LoginContinuebutton;
	
	@FindBy(xpath="//div/a[contains(.,'Logout')]")
	private static WebElement Logout;
	/**
	 * Register a few user's
	 * @param firstname enter your first name
	 * @param lastname enter your lastname
	 * @param email enter your email(only name)
	 * @param phone enter your phone number
	 * @param password enter your password
	 * @param confirmpassword enter the confirm passwrod
	 * @param neednewsletter need news letter yes or  no
	 * @param acceptprivatepolicy need to accept the private policy?
	 */
	public static void Registeruser(String firstname,String lastname,String email,String phone,String password,
			String confirmpassword,String neednewsletter,String acceptprivatepolicy) {
		Dashboardpage.NavigatetoRegisterpage();
		String Emailentered;
		double number = Math.random()*999;
		int emailadd=(int)number;
		System.out.println(emailadd);
		Emailentered=email.concat(emailadd+"@gmail.com");
		sendkeys(Firstname, firstname);
		sendkeys(Lastname, lastname);
		sendkeys(Emailid, Emailentered);
		sendkeys(Phone, phone);
		sendkeys(Password, password);
		sendkeys(ConfirmPassword, confirmpassword);

		if(neednewsletter.equalsIgnoreCase("Yes")) {
			clickelement(YesNewsletter);
		}

		if(acceptprivatepolicy.equalsIgnoreCase("Yes")) {
			clickelement(privacypolicy);
		}

		clickelement(buttons);


		if(!acceptprivatepolicy.equalsIgnoreCase("Yes")) {
			verifyisdisplay(privacypolicyerrormessage);
		}
		if(firstname.isEmpty()||lastname.isEmpty()||email.isEmpty()||phone.isEmpty()||phone.isEmpty()) {
			verifyisalldisplay(fielderror);
		}
		if(!confirmpassword.equals(password)) {
			verifyisdisplay(passwordmismatch);
		}

		try {
			if(isdisplay(Registersuccessfullmessage)) {
				verifyisdisplay(Registersuccessfullmessage);
			}
		}catch (NoSuchElementException e) {
		}

	}
/**
 * Login to the website 
 * @param Email enter the email id
 * @param password enter the password
 */
	public static void Login(String Email, String password) {
		Dashboardpage.NavigatetoLoginpage();
		sendkeys(Emailid, Email);
		sendkeys(Password, password);
		clickelement(buttons);
	}
	/**
	 * navigate to register page from the login page
	 */
	public static void checkabletonavigateregisterpage() {
		clickelement(LoginContinuebutton);
		verifytitle("Register Account");
	}

public static void Logout() {
	clickelement(Logout);
	verifytitle("Account Logout");
	clickelement(LoginContinuebutton);
}
}
