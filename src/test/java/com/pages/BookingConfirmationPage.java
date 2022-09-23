package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Velumani Devendiran
 *
 *@Description Used to maintain Booking confirmation page WebElements 
 *
 *@date 28/08/22
 */

public class BookingConfirmationPage extends BaseClass{
	
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	static String orderId;
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement txtBookingPageconfirmMsg;
	

	public WebElement getTxtBookingPageconfirmMsg() {
		return txtBookingPageconfirmMsg;
	}
	
	@FindBy(id="order_no")
	private WebElement txtOrderId;
	
	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	// 1.get order id
	public String getbookingOrderId() {
		
		orderId = elementGetAttributeValue(getTxtOrderId());
		System.out.println(orderId);
		return orderId;
		
		

	}
}
