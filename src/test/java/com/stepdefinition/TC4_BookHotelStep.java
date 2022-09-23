package com.stepdefinition;

import java.util.List;
import java.util.Map;

import com.base.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Then;
import junit.framework.Assert;

/**
 * 
 * 
 * @author Velumani Devendiran
 * @Description User to Book a hotel with help of Cucumber feature file datas
 * @Date 28/08/2022
 *
 */
public class TC4_BookHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should perform book hotel {string},{string} and {string}")
	public void user_should_perform_book_hotel_and(String firstName, String lastName, String billingAddress,
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> details = dataTable.asMaps();
		Map<String, String> card = details.get(1);
		String cardno = card.get("creditCardNo");
		String cardtype = card.get("creditCardType");
		String cardmonth = card.get("expiryMonth");
		String cardyear = card.get("expiryYear");
		String cardcvno = card.get("cvvNumber");

		pom.getBookHotelPage().bookHotel(firstName, lastName, billingAddress, cardno, cardtype, cardmonth, cardyear,
				cardcvno);
	}

	@Then("User should verify after click book now msg {string}")
	public void user_should_verify_after_click_book_now_msg(String expertConfirmMsg) throws InterruptedException {

		Thread.sleep(5000);
		Assert.assertEquals("verify after Booknow", expertConfirmMsg,
				elementGettext(pom.getBookingConfirmationPage().getTxtBookingPageconfirmMsg()));
	}

	@Then("User should click Book now option With out enter details")
	public void user_should_click_book_now_option_with_out_enter_details() {
		pom.getBookHotelPage().clickBooknow();
	}

	@Then("User should verify Error msg {string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_error_msg_and(String firstNameErrorMsg, String lastNameErrorMsg,
			String billingAddressErrorMsg, String cardnoErrorMsg, String cardtypeErrorMsg, String cardExpMonthandYear,
			String cardcvnoErrorMsg) {

		Assert.assertEquals("Please Enter your First Name", firstNameErrorMsg,
				elementGettext(pom.getBookHotelPage().getTxtEnterFirstNameErrorMsg()));
		Assert.assertEquals("Please Enter you Last Name", lastNameErrorMsg,
				elementGettext(pom.getBookHotelPage().getTxtEnterLastNameErrorMsg()));
		Assert.assertEquals("Please Enter your Address", billingAddressErrorMsg,
				elementGettext(pom.getBookHotelPage().getTxtEnterAddressErrormsg()));
		Assert.assertEquals("Please Enter your 16 Digit Credit Card Number", cardnoErrorMsg,
				elementGettext(pom.getBookHotelPage().getTxtEnterCardNoErrorMsg()));
		Assert.assertEquals("Please Select your Credit Card Type", cardtypeErrorMsg,
				elementGettext(pom.getBookHotelPage().getTxtEnterCardTypeErrorMsg()));
		Assert.assertEquals("Please Select your Credit Card Expiry Month", cardExpMonthandYear,
				elementGettext(pom.getBookHotelPage().getTxtEnterCardExpMonthAndYearErrorMsg()));
		Assert.assertEquals("Please Enter your Credit Card CVV Number", cardcvnoErrorMsg,
				elementGettext(pom.getBookHotelPage().getTxtEnterCardCvvNoErroMsg()));

	}
}
