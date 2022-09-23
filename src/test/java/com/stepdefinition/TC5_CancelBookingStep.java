package com.stepdefinition;

import com.base.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Then;
import junit.framework.Assert;

/**
 * 
 * @author Velumani Devendiran
 * @Description User should cancel the hotel with help of future file and
 *              Booking Orderid
 * @Date 28/08/2022
 */
public class TC5_CancelBookingStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should cancel booking with generated order id")
	public void user_should_cancel_booking_with_generated_order_id() throws InterruptedException {
		Thread.sleep(5000);
		String bookingId = pom.getBookingConfirmationPage().getbookingOrderId();
		pom.getCancelBookingPage().cancelBooking(bookingId);
	}

	@Then("User should Verify after Cancel selected {string}")
	public void user_should_verify_after_cancel_selected(String cancelConfirm) {

		String actualCancelledMsg = pom.getCancelBookingPage().getCancelConfirm().getText();
		Assert.assertEquals("verify a booking cancelled message", cancelConfirm, actualCancelledMsg);
	}

	@Then("User should cancel booking with exitsing {string}")
	public void user_should_cancel_booking_with_exitsing(String bookingId) {

		pom.getCancelBookingPage().CancelExistingOrderId();

	}
}
