package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;


/**
 * 
 * @author Velumani Devendiran
 *
 *@Description Used to maintain selectHotel page WebElements 
 *
 *@date 28/08/22
 */
public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@class='login_title']")
	private WebElement txtSelectHotelMsg;

	public WebElement getTxtSelectHotelMsg() {
		return txtSelectHotelMsg;
	}

	@FindBy(xpath="//input[@type='radio']")
	private WebElement txtSelectButton;
	

	public WebElement getTxtSelectButton() {
		return txtSelectButton;
	}

	@FindBy(xpath="//input[@type='submit']")
	private WebElement txtContinue;
	

	public WebElement getTxtContinue() {
		return txtContinue;
	}

	@FindBy(id="username_show")
	private WebElement txtMsg;
	
	@FindBy(xpath="//label[@class='reg_error']")
	private WebElement txtErrorSelectHotel;

	public WebElement getTxtErrorSelectHotel() {
		return txtErrorSelectHotel;
	}

	public WebElement getTxtMsg() {
		return txtMsg;
	}

	// 1.Select hotel page by select hotel name
	public void selectHotelClick() {
		
		elementClick(getTxtSelectButton());

	}

	// 2.Select hotel without select hotel name and click continue
	public void SelectHotelContinue() {
		
		elementClick(getTxtContinue());

	}
	
	
}
