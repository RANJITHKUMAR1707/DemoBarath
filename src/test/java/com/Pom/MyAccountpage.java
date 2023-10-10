package com.Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.BaseClass;

public class MyAccountpage extends BaseClass {

	@FindBy(xpath="//div/a[contains(.,'Edit Account')]")
	private static WebElement EditAccount;

	@FindBy(xpath="//div/a[contains(.,'Password')]")
	private static WebElement PasswordAccount;

	@FindBy(xpath="//div/a[contains(.,'Address Book')]")
	private static WebElement AddressBook;

	@FindBy(xpath="//div/a[contains(.,'Wish List')]")
	private static WebElement WishList;


	@FindBy(xpath="//div/a[contains(.,'Order History')]")
	private static WebElement OrderHistory;

	@FindBy(xpath="//div/a[contains(.,'Downloads')]")
	private static WebElement Downloads;

	@FindBy(xpath="//div/input[@name='telephone']")
	private static WebElement Telephone;

	@FindBy(xpath="//div/input[@type='submit']")
	private static WebElement Continuebutton;

	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	private static WebElement Successmessage;


	@FindBy(xpath="//input[@name='password']")
	private static WebElement Password;

	@FindBy(xpath="//input[@name='confirm']")
	private static WebElement ConfirmPassword;

	@FindBy(xpath="//input[@name='confirm']/following::div[@class='text-danger']")
	private static WebElement passwordmismatch;

	@FindBy(xpath="//a[contains(.,'New Address')]")
	private static WebElement NewAddressbutton;

	@FindBy(xpath="//input[@name='firstname']")
	private static WebElement Firstname;

	@FindBy(xpath="//input[@name='lastname']")
	private static WebElement Lastname;

	@FindBy(xpath="//input[contains(@name,'company')]")
	private static WebElement Companyname;

	@FindBy(xpath="//input[@id='input-address-2']")
	private static WebElement Address2;

	@FindBy(xpath="//input[@id='input-address-1']")
	private static WebElement Address1;

	@FindBy(xpath="//input[@id='input-city']")
	private static WebElement City;

	@FindBy(xpath="//input[@id='input-postcode']")
	private static WebElement Postcode;

	@FindBy(xpath="//select[@id='input-country']")
	private static WebElement Country;

	@FindBy(xpath="//select[@id='input-zone']")
	private static WebElement State;

	public static void EditProfile(String EditPhonenumber) {
		clickelement(EditAccount);
		Telephone.clear();
		sendkeys(Telephone, EditPhonenumber);
		clickelement(Continuebutton);
		verifyisdisplay(Successmessage);
	}

	public static void Changepassword(String password,String confirmpassword) {
		clickelement(PasswordAccount);

		sendkeys(Password,password);
		sendkeys(ConfirmPassword,confirmpassword);
		clickelement(Continuebutton);
		if(!password.equals(confirmpassword)) {
			verifyisdisplay(passwordmismatch);
		}else {	
			verifyisdisplay(Successmessage);
		}
	}

	public static void AddAddressbook(String firstname,String lastname,String Company,String address1,String address2
			,String city,String postcode,String country,String state) {
		clickelement(AddressBook);
		clickelement(NewAddressbutton);
		sendkeys(Firstname, firstname);
		sendkeys(Lastname, lastname);
		sendkeys(Companyname,Company);
		sendkeys(Address1,address1);
		sendkeys(Address2,address2);
		sendkeys(City, city);
		sendkeys(Postcode,postcode);
		selectbyvisibletext(Country, country);
		selectbyvisibletext(State,state);
		clickelement(Continuebutton);
		verifyisdisplay(Successmessage);
	}
}
