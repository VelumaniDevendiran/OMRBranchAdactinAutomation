  package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Velumani Devendiran
 *
 *@Description Used to maintain Login page WebElements 
 *
 *@date 28/08/22
 */
public class LoginPage extends BaseClass{
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement txtusername;
	
	@FindBy(id="password")
	private WebElement txtpassword;
	
	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}
	

	@FindBy(id="login")
	private WebElement btnlogin;
	
	@FindBy(xpath="//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement txtInvalidMsg;
	
	public WebElement getTxtInvalidMsg() {
		return txtInvalidMsg;
	}

	// 1.login with valid credentials
	// 3.login with invalid credentials
	public void login(String username, String password) {
		
		elementSendKeys(getTxtusername(), username);
		elementSendKeys(getTxtpassword(), password);
		elementClick(getBtnlogin());

	}

	// 2.login with valid credentials with Enter
	public void loginWithEnter(String username, String password) throws AWTException {
		
		elementSendKeys(getTxtusername(), username);
		elementSendKeys(getTxtpassword(), password);
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
}
