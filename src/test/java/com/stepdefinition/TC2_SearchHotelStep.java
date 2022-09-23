package com.stepdefinition;

import com.base.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Then;
import junit.framework.Assert;

/**
 * 
 * @author Velumani Devendiran
 *
 * @Description User Should Search the hotel help of cucumber feature file input
 *              datas
 * @Date 28/08/2022
 */
public class TC2_SearchHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should enter details in Search Hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_enter_details_in_search_hotel_and(String location, String hotels, String roomType,
			String numberofRooms, String checkInDate, String checkOutDate, String adultsperRoom,
			String childrenperRoom) {
		pom.getSearchHotelPage().searchHotel(location, hotels, roomType, numberofRooms, checkInDate, checkOutDate,
				adultsperRoom, childrenperRoom);

	}

	@Then("User should verify  after Select Hotel page msg {string}")
	public void user_should_verify_after_select_hotel_page_msg(String expWelcomeMsg) {

		Assert.assertEquals("Verify after login welcome sucess msg", expWelcomeMsg,
				pom.getSearchHotelPage().elementGettext(pom.getSelectHotelPage().getTxtSelectHotelMsg()));

	}

	@Then("User should enter mandatory fields {string},{string},{string},{string} and {string}")
	public void user_should_enter_mandatory_fields_and(String location, String numberofRooms, String checkInDate,
			String checkOutDate, String adultsperRoom) {
		pom.getSearchHotelPage().mandatoryFields(location, numberofRooms, checkInDate, checkOutDate, adultsperRoom);
	}

	@Then("User should verifying after enter invalid date error messgae  {string} and {string}")
	public void user_should_verifying_after_enter_invalid_date_error_messgae_and(String expInDateerror,
			String expOutDateerror) {
		Assert.assertEquals("verifying after enter invalid date error messgae", expInDateerror,
				elementGettext(pom.getSearchHotelPage().getTxtCheckIndateerror()));
		Assert.assertEquals("verifying after enter invalid date error messgae", expOutDateerror,
				elementGettext(pom.getSearchHotelPage().getTxtCheckOutdateerror()));
	}

	@Then("User should click search button")
	public void user_should_click_search_button() {
		pom.getSearchHotelPage().searchWithoutEnter();
	}

	@Then("User should verify Search Hotel error message {string}")
	public void user_should_verify_search_hotel_error_message(String experrorLocation) {
		Assert.assertEquals("verify Search Hotel error message", experrorLocation,
				elementGettext(pom.getSearchHotelPage().getTxtErrorLocation()));
	}
}
