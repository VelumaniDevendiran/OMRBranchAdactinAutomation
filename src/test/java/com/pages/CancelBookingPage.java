package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Velumani Devendiran
 *
 *@Description Used to maintain Cancel Booking page WebElements 
 *
 *@date 28/08/22
 */
public class CancelBookingPage extends BaseClass {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	private static String BookingId = null;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement txtBookedItinerary;

	@FindBy(id = "order_id_text")
	private WebElement txtSearchBox;

	@FindBy(id = "search_hotel_id")
	private WebElement txtClickGo;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement clickCancelBtn;

	public WebElement getClickCancelBtn() {
		return clickCancelBtn;
	}

	@FindBy(xpath = "//label[@class='reg_error']")
	private WebElement cancelConfirm;

	public WebElement getCancelConfirm() {
		return cancelConfirm;
	}

	public WebElement getTxtBookedItinerary() {
		return txtBookedItinerary;
	}

	public WebElement getTxtSearchBox() {
		return txtSearchBox;
	}

	public WebElement getTxtClickGo() {
		return txtClickGo;
	}

	// 1.Cancel Booking
	public void cancelBooking(String BookingId) {

		elementClick(getTxtBookedItinerary());

		elementSendKeys(getTxtSearchBox(), BookingId);

		elementClick(getTxtClickGo());

		elementClick(getClickCancelBtn());

		accept();

	}

	public void CancelExistingOrderId() {

		elementClick(getTxtBookedItinerary());
		elementClick(getClickCancelBtn());
		accept();

	}

}
