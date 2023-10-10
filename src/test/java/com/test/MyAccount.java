package com.test;

import org.testng.annotations.Test;

import com.Pom.MyAccountpage;
import com.Pom.Registerpage;
import com.dataprovider.Addressbook;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class MyAccount extends BaseClass {


	@Test(priority = 1,enabled=false)
	private static void Editprofile() {
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		MyAccountpage.EditProfile(prop.getProperty("number"));
	}

	@Test(priority = 2,enabled=false)
	private static void ChangePassword() {
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		MyAccountpage.Changepassword(prop.getProperty("Password"), prop.getProperty("confirmpassword"));
	}

	@Test(priority = 3,enabled=false)
	private static void invalidChangePassword() {
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("Password"));
		MyAccountpage.Changepassword(prop.getProperty("invalidconfirmpassword"), prop.getProperty("confirmpassword"));
		MyAccountpage.Changepassword(prop.getProperty("PW"), prop.getProperty("PW"));
	}

	@Test(priority = 4,dataProvider = "Addaddressbook",dataProviderClass = Addressbook.class)
	private static void Addaddressbook(String firstname,String lastname,String Company,String address1,String address2
			,String city,String postcode,String country,String state) {
		
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		MyAccountpage.AddAddressbook(firstname, lastname, Company, address1, address2, city, postcode, country, state);
		
	}
}
