package com.test;

import org.testng.annotations.Test;

import com.Browser.BaseClass;
import com.Pom.Dashboardpage;
import com.Pom.Registerpage;

public class Searchproduct extends BaseClass {

	@Test(priority =1,enabled=true)
	private static void VerifythesearchproductTC_013() {
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		Dashboardpage.searchexistproduct(prop.getProperty("existproduct"));
		Dashboardpage.searchnonexistproduct(prop.getProperty("nonexistproduct"));
	}
	
	@Test(priority =2,enabled=true)
	private static void searchproductaddtocartTC_014() {
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		Dashboardpage.addproductfromsearch(prop.getProperty("addtocart"),prop.getProperty("productquantity"));
	}
	
	@Test(priority =3,enabled=true)
	private static void searchproductcheckoutTC_015() {
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		Dashboardpage.addproductfromsearch(prop.getProperty("addtocart"),prop.getProperty("productquantity"));
		Dashboardpage.checkout(prop.getProperty("checkoutmessage"));
	}
	
	@Test(priority = 4,enabled=true)
	private static void addtocartTC_016() {
		Registerpage.Login(prop.getProperty("UN"), prop.getProperty("PW"));
		Dashboardpage.checkoutfromwishlist(prop.getProperty("cameraproduct"),prop.getProperty("checkoutmessage"));
	}
}
