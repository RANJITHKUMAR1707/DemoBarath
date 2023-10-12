package com.test;

import org.testng.annotations.Test;

import com.Browser.BaseClass;
import com.Pom.Registerpage;
import com.dataprovider.Registerdataprovider;

public class Register extends BaseClass{



	@Test(priority = 1,dataProvider =  "Register",dataProviderClass = Registerdataprovider.class)
	private void RegisterusersTC_001(String firstname,String lastname,String email,String phone,String password,
			String confirmpassword) {


		Registerpage.ValidRegisteruser(firstname, lastname, email, phone, password, confirmpassword);
	}

	@Test(priority = 2)
	private void policyerrorTC_002() {

		Registerpage.notselectprivacypolicy(prop.getProperty("firstname"), prop.getProperty("lastname"), 
				Randomemail(prop.getProperty("email")), prop.getProperty("phone"), prop.getProperty("INPW"), prop.getProperty("INPW"));
	}


}
