package com.Pom;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Browser.BaseClass;


public class Dashboardpage extends BaseClass{


	@FindBy(xpath="//a[contains(@title,'My Account')]")
	private static WebElement MyAccountdropdown;


	@FindBy(xpath="//li/a[contains(.,'Register')]")
	private static WebElement Register;

	@FindBy(xpath="//li/a[contains(.,'Login')]")
	private static WebElement Login;

	@FindBy(xpath="//li/a[contains(.,'Logout')]")
	private static WebElement Logout;

	@FindBy(xpath="//a/i[contains(@class,'home')]")
	private static WebElement homeicon;

	@FindBy(xpath="//input[@name='search']")
	private static WebElement Searchbar;

	@FindBy(xpath="//div[@id='search']//button[@type='button']")
	private static WebElement Searchbutton;

	@FindBy(xpath="//div[@class='caption']//a")
	private static List<WebElement> searchproduct;

	@FindBy(xpath="//p[contains(.,'There is no product')]")
	private static WebElement noproductmessage;

	@FindBy(xpath="//button/i[contains(@class,'heart')]")
	private static WebElement addtowishlist;

	@FindBy(xpath="//span[contains(.,'Wish List')]")
	private static WebElement wishlistdashboard;

	@FindBy(xpath="//input[@name='quantity']")
	private static WebElement addquantity;

	@FindBy(xpath="//button[contains(.,'Add to Cart')]")
	private static WebElement addtocart;

	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	private static WebElement Successmessage;

	@FindBy(xpath="//ul[@class='list-unstyled']/li/h2")
	private static WebElement productprice;


	@FindBy(xpath="//div[@id='cart']/button")
	private static WebElement addtocartbutton;

	@FindBy(xpath="//td[@class='text-left']/a")
	private static WebElement productaddtocart;

	@FindBy(xpath="//button[@title='Remove']")
	private static WebElement removebutton;

	@FindBy(xpath="//a[@title='Shopping Cart']")
	private static WebElement shoppingcart;

	@FindBy(xpath="//a[contains(.,'View Cart')]")
	private static WebElement viewcart;


	@FindBy(xpath="//div/a[contains(.,'Checkout')]")
	private static WebElement checkout;


	@FindBy(xpath="//div[@id='payment-new']/following-sibling::div//input[@type='button']")
	private static WebElement billingcontinuebutton;

	@FindBy(xpath="//div[@id='shipping-new']/following-sibling::div//input[@type='button']")
	private static WebElement Delevirycontinuebutton;
	@FindBy(xpath="//div/input[@id='button-shipping-method']//preceding::textarea")
	private static WebElement delevirymethodtextarea;


	@FindBy(xpath="//div/input[@id='button-shipping-method']")
	private static WebElement Delevirymethodcontinuebutton;

	@FindBy(xpath="//label/input[@name='payment_method']")
	private static WebElement paymentmethodcod;

	@FindBy(xpath="//input[@id='button-payment-method']")
	private static WebElement paymentmethodcontinuebutton;

	@FindBy(xpath="//input[contains(@value,'Confirm Order')]")
	private static WebElement confirmorderbutton;

	@FindBy(xpath="//input[@name='agree']")
	private static WebElement termsandcondition;

	@FindBy(xpath="//div/h1[contains(.,'Your order has been placed!')]")
	private static WebElement orderplaced;

	@FindBy(xpath="//li/a[.='Cameras']")
	private static WebElement Camerassection;

	@FindBy(xpath="//button[@data-original-title='Add to Cart']")
	private static WebElement wishlistaddtocart;
	/**
	 * 
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
	/**
	 * Log out the website using myaccount dropdown option
	 */
	public static void logoutusingdrowndown() {
		clickelement(MyAccountdropdown);
		clickelement(Logout);
	}

	public static void searchexistproduct(String productsearch) {
		homeicon.click();
		sendkeys(Searchbar, productsearch);
		clickelement(Searchbutton);
		if(isdisplay(searchproduct.get(0))) {
			verifyisalldisplay(searchproduct);
		}
	}
	public static void searchnonexistproduct(String productsearch) {
		homeicon.click();
		sendkeys(Searchbar, productsearch);
		clickelement(Searchbutton);
		if(isdisplay(noproductmessage)) {
			verifyisdisplay(noproductmessage);
		}
	}

	public static void addproductfromsearch(String productsearch,String productquantity) {
		homeicon.click();
		sendkeys(Searchbar, productsearch);
		clickelement(Searchbutton);
		for(int i=0;i<searchproduct.size();i++) {
			if(Gettext(searchproduct.get(i)).equals(productsearch)) {
				clickelement(searchproduct.get(i));

				sendkeyswithclear(addquantity, productquantity);
				implictwait(20);
				clickelement(addtocart);
				clickelement(addtocartbutton);
				verifyisdisplay(productaddtocart);
				clickelement(viewcart);

			}
		}
	}

	public static void checkout(String delevirytext) {

		clickelement(checkout);
		clickelement(billingcontinuebutton);
		clickelement(Delevirycontinuebutton);
		sendkeys(delevirymethodtextarea,delevirytext);
		clickelement(Delevirymethodcontinuebutton);
		isSelected(paymentmethodcod);
		clickelement(termsandcondition);
		clickelement(paymentmethodcontinuebutton);
		clickelement(confirmorderbutton);
		verifyisdisplay(orderplaced);

	}

	public static void checkoutfromwishlist(String cameraproduct,String deleveriytext) {
		homeicon.click();
		clickelement(Camerassection);
		for(int i=0;i<searchproduct.size();i++) {
			if(Gettext(searchproduct.get(i)).equalsIgnoreCase(cameraproduct)) {
				clickelement(searchproduct.get(i));
				clickelement(addtowishlist);
				verifyisdisplay(Successmessage);
				clickelement(wishlistdashboard);
				clickelement(wishlistaddtocart);
				verifyisdisplay(Successmessage);
				clickelement(shoppingcart);
				checkout(deleveriytext);
			}
		}
	}
}

