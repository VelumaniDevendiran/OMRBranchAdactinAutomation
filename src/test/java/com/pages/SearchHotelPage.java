package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Location;

/**
 * 
 * @author Velumani Devendiran
 *
 *@Description Used to maintain Searchhotel page WebElements 
 *
 *@date 28/08/22
 */
public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@value='Hello Velumani!']")
	private WebElement welcomemessage;
	

	public WebElement getWelcomemessage() {
		return welcomemessage;
	}

	@FindBy(id = "location")
	private WebElement txtlocation;
	@FindBy(id = "hotels")
	private WebElement txthotels;
	@FindBy(id = "room_type")
	private WebElement txtroomType;
	@FindBy(id = "room_nos")
	private WebElement txtnumberofRooms;
	@FindBy(id = "datepick_in")
	private WebElement txtcheckInDate;
	@FindBy(id = "datepick_out")
	private WebElement txtcheckOutDate;
	@FindBy(id = "adult_room")
	private WebElement txtadultsperRoom;
	@FindBy(id = "child_room")
	private WebElement txtchildrenperRoom;

	@FindBy(id = "checkin_span")
	private WebElement txtCheckIndateerror;

	@FindBy(id = "checkout_span")
	private WebElement txtCheckOutdateerror;

	@FindBy(id = "Submit")
	private WebElement txtSearch;

	@FindBy(id = "location_span")
	private WebElement txtErrorLocation;

	public WebElement getTxtErrorLocation() {
		return txtErrorLocation;
	}

	public WebElement getTxtSearch() {
		return txtSearch;
	}

	public WebElement getTxtCheckIndateerror() {
		return txtCheckIndateerror;
	}

	public WebElement getTxtCheckOutdateerror() {
		return txtCheckOutdateerror;
	}

	public WebElement getTxtlocation() {
		return txtlocation;
	}

	public WebElement getTxthotels() {
		return txthotels;
	}

	public WebElement getTxtroomType() {
		return txtroomType;
	}

	public WebElement getTxtnumberofRooms() {
		return txtnumberofRooms;
	}

	public WebElement getTxtcheckInDate() {
		return txtcheckInDate;
	}

	public WebElement getTxtcheckOutDate() {
		return txtcheckOutDate;
	}

	public WebElement getTxtadultsperRoom() {
		return txtadultsperRoom;
	}

	public WebElement getTxtchildrenperRoom() {
		return txtchildrenperRoom;
	}

	// 1.Search hotel with valid credentials
	// 3.Search hotel with invalid date credentials
	public void searchHotel(String location, String hotels, String roomType, String numberofRooms, String checkInDate,
			String checkOutDate, String adultsperRoom, String childrenperRoom) {
		elementSendKeys(getTxtlocation(), location);
		elementSendKeys(getTxthotels(), hotels);
		elementSendKeys(getTxtroomType(), roomType);
		elementSendKeys(getTxtnumberofRooms(), numberofRooms);
		elementClear(getTxtcheckInDate());
		elementSendKeys(getTxtcheckInDate(), checkInDate);
		elementClear(getTxtcheckOutDate());
		elementSendKeys(getTxtcheckOutDate(), checkOutDate);
		elementSendKeys(getTxtadultsperRoom(), adultsperRoom);
		elementSendKeys(getTxtchildrenperRoom(), childrenperRoom);
		elementClick(getTxtSearch());

	}

	// 2.Search hotel by mandatory fields
	public void mandatoryFields(String location, String numberofRooms, String checkInDate, String checkOutDate,
			String adultsperRoom) {
		elementSendKeys(getTxtlocation(), location);
		elementSendKeys(getTxtnumberofRooms(), numberofRooms);
		elementSendKeys(getTxtcheckInDate(), checkInDate);
		elementSendKeys(getTxtcheckOutDate(), checkOutDate);
		elementSendKeys(getTxtadultsperRoom(), adultsperRoom);
		elementClick(getTxtSearch());

	}

	// 4.Search hotel without entering all fields
	public void searchWithoutEnter() {
		elementClick(getTxtSearch());

	}

}
