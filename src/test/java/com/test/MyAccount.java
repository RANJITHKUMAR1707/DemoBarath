package com.test;

import org.testng.annotations.Test;

import com.Pom.MyAccountpage;
import com.Pom.Registerpage;
import com.dataprovider.Addressbook;

public class MyAccount extends Login {

	static String editemail;

	@Test(priority = 1,enabled=true)
	private void EditprofileTC_007() {
		editemail=Randomemail(prop.getProperty("email"));
		Registerpage.Login(Registerpage.Emailentered, prop.getProperty("PW"));
		MyAccountpage.EditProfile(prop.getProperty("number"),editemail);
		Registerpage.logoutusingdrowndown();
		Registerpage.Login(editemail, prop.getProperty("PW"));
		verifytitle("My Account");

	}

	@Test(priority = 2,enabled=true,dependsOnMethods = "EditprofileTC_007")
	private  void EditprofileTC_008() {
		Registerpage.Login(Registerpage.Emailentered, prop.getProperty("PW"));
		verifyisdisplay(Registerpage.Loginpageerror);
	}

	@Test(priority = 3,enabled=true)
	private  void ChangePasswordTC_009() {
		Registerpage.Login(editemail, prop.getProperty("PW"));
		MyAccountpage.Changepassword(prop.getProperty("Password"), prop.getProperty("confirmpassword"));
	}

	@Test(priority = 4,enabled=true)
	private void invalidChangePasswordTC_010() {
		Registerpage.Login(editemail, prop.getProperty("Password"));
		MyAccountpage.Changepassword(prop.getProperty("invalidconfirmpassword"), prop.getProperty("confirmpassword"));
	}

	@Test(priority = 5,dataProvider = "Addaddressbook",dataProviderClass = Addressbook.class)
	private void AddaddressbookTC_011(String firstname,String lastname,String Company,String address1,String address2
			,String city,String postcode,String country,String state) {

		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		MyAccountpage.AddAddressbook(firstname, lastname, Company, address1, address2, city, postcode, country, state);

	}
	@Test(priority = 6,enabled=true)
	private void deletealladressbook_012() {
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		MyAccountpage.deleteaddress();
	}
}
