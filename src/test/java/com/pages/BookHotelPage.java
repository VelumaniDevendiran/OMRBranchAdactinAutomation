package com.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;


/** 
 * 
 * @author Velumani Devendiran
 * 
 * @Description Used to Maintain Book Hotel page Webelements
 * 
 * @Date 28/08/22
 *
 */
public class BookHotelPage extends BaseClass{
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement txtBookHotelMsg;
	
	public WebElement getTxtBookHotelMsg() {
		return txtBookHotelMsg;
	}
	

	@FindBy(id="first_name")
	private WebElement txtFirstName;
	
	@FindBy(id="last_name")
	private WebElement txtLastName;
	
	@FindBy(id="address")
	private WebElement txtAddress;
	
	@FindBy(id="cc_num")
	private WebElement txtCardNo;
	
	@FindBy(id="cc_type")
	private WebElement txtCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement txtCardMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement txtCardYear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtCardCvvNo;
	
	@FindBy(id="book_now")
	private WebElement txtBookNow;
	
	@FindBy(xpath="//label[text()='Please Enter your First Name']")
	private WebElement txtEnterFirstNameErrorMsg;
	
	@FindBy(xpath="//label[text()='Please Enter you Last Name']")
	private WebElement txtEnterLastNameErrorMsg;
	
	@FindBy(xpath="//label[text()='Please Enter your Address']")
	private WebElement txtEnterAddressErrormsg;
	
	@FindBy(xpath="//label[text()='Please Enter your 16 Digit Credit Card Number']")
	private WebElement txtEnterCardNoErrorMsg;
	
	@FindBy(id="cc_type_span")
	private WebElement txtEnterCardTypeErrorMsg;
	
	@FindBy(id="cc_expiry_span")
	private WebElement txtEnterCardExpMonthAndYearErrorMsg;
	
	
	@FindBy(xpath="//label[text()='Please Enter your Credit Card CVV Number']")
	private WebElement txtEnterCardCvvNoErroMsg;
	
	public WebElement getTxtEnterFirstNameErrorMsg() {
		return txtEnterFirstNameErrorMsg;
	}

	public WebElement getTxtEnterLastNameErrorMsg() {
		return txtEnterLastNameErrorMsg;
	}

	public WebElement getTxtEnterAddressErrormsg() {
		return txtEnterAddressErrormsg;
	}

	public WebElement getTxtEnterCardNoErrorMsg() {
		return txtEnterCardNoErrorMsg;
	}

	public WebElement getTxtEnterCardTypeErrorMsg() {
		return txtEnterCardTypeErrorMsg;
	}


	public WebElement getTxtEnterCardExpMonthAndYearErrorMsg() {
		return txtEnterCardExpMonthAndYearErrorMsg;
	}

	public WebElement getTxtEnterCardCvvNoErroMsg() {
		return txtEnterCardCvvNoErroMsg;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCardNo() {
		return txtCardNo;
	}

	public WebElement getTxtCardType() {
		return txtCardType;
	}

	public WebElement getTxtCardMonth() {
		return txtCardMonth;
	}

	public WebElement getTxtCardYear() {
		return txtCardYear;
	}

	public WebElement getTxtCardCvvNo() {
		return txtCardCvvNo;
	}

	public WebElement getTxtBookNow() {
		return txtBookNow;
	}

	// 1.Book A Hotel page by enter Details all fields
	public void bookHotel(String firstName, String lastName, String billingAddress, String cardno,String cardtype,String cardmonth,String cardyear,String cardcvno ) {
		elementSendKeys(getTxtFirstName(), firstName);
		elementSendKeys(getTxtLastName(), lastName);
		elementSendKeys(getTxtAddress(), billingAddress);
		elementSendKeys(getTxtCardNo(), cardno);
		elementSendKeys(getTxtCardType(), cardtype);
		elementSendKeys(getTxtCardMonth(), cardmonth);
		elementSendKeys(getTxtCardYear(), cardyear);
		elementSendKeys(getTxtCardCvvNo(), cardcvno);
		elementClick(getTxtBookNow());
	}

	// 2.Book A Hotel page without enter details any fields
	public void clickBooknow() {
		elementClick(getTxtBookNow());

	}
}
