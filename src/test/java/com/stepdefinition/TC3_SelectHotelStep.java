package com.stepdefinition;

import com.base.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Then;
import junit.framework.Assert;

/**
 * 
 * @author Velumani Devendiran
 * @Description User should select the Hotel
 * @Date 28/08/2022
 */
public class TC3_SelectHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should selct hotel and click continue")
	public void user_should_selct_hotel_and_click_continue() {
		pom.getSelectHotelPage().selectHotelClick();
		pom.getSelectHotelPage().SelectHotelContinue();

	}

	@Then("User should verify after continue {string}")
	public void user_should_verify_after_continue(String welcomMsgBook) {
		Assert.assertEquals("verify after continue", welcomMsgBook,
				elementGettext(pom.getBookHotelPage().getTxtBookHotelMsg()));
	}

	@Then("User should not select hotel name and click continue button")
	public void user_should_not_select_hotel_name_and_click_continue_button() {
		pom.getSelectHotelPage().SelectHotelContinue();
	}

	@Then("User should verify error msg after continue {string}")
	public void user_should_verify_error_msg_after_continue(String verifyMsg) {
		pom.getSelectHotelPage().SelectHotelContinue();
		Assert.assertEquals("verify  after Select Hotel page msg", verifyMsg,
				elementGettext(pom.getSelectHotelPage().getTxtErrorSelectHotel()));
	}

}
