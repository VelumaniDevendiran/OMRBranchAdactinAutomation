package com.stepdefinition;

import com.base.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Then;
import junit.framework.Assert;

/**
 * 
 * @author Velumani Devendiran
 * @Description Used to maintain Common steps on verify login message
 * @Date 28/08/2022
 *
 */

public class CommonStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify after login {string}")
	public void user_should_verify_after_login(String expWelcomeMsg) {

		Assert.assertEquals("Verify after login welcome sucess msg", expWelcomeMsg,
				elementGetAttributeValue(pom.getSearchHotelPage().getWelcomemessage()));

	}

}
