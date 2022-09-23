package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import com.base.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

/**
 * 
 * @author Velumani Devendiran
 * @Description User to Login Adaction hotel with help of chrome browser. Date
 * @Date 28/08/2022
 *
 */
public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the adactin page")
	public void user_is_on_the_adactin_page() throws FileNotFoundException, IOException {
//		getDriver(getPropertyFileValue("browserType"));
//		enterUrl(getPropertyFileValue("url"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User should perform login {string},{string}")
	public void user_should_perform_login(String username, String password) {
		pom.getLoginPage().login(username, password);

	}

	@When("User should perform login {string},{string} with entry key")
	public void user_should_perform_login_with_entry_key(String username, String password) throws AWTException {
		pom.getLoginPage().loginWithEnter(username, password);

	}

	@Then("User should verifying after login error contains {string}")
	public void user_should_verifying_after_login_error_contains(String expInvalidMsg) {

		Assert.assertEquals("Verify error contains", expInvalidMsg,
				elementGettext(pom.getLoginPage().getTxtInvalidMsg()));

	}

}
