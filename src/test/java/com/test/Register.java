package com.test;

import org.testng.annotations.Test;

import com.Pom.Dashboardpage;
import com.Pom.Registerpage;
import com.dataprovider.Registerdataprovider;

public class Register extends BaseClass{

	
	
	@Test(dataProvider = "Register",dataProviderClass = Registerdataprovider.class)
	private void RegisterusersTC_001(String firstname,String lastname,String email,String phone,String password,
			String confirmpassword,String neednewsletter,String acceptprivatepolicy ) {

	
		Registerpage.Registeruser(firstname, lastname, email, phone, password, confirmpassword, 
				neednewsletter, acceptprivatepolicy);
	}
	
	

}
