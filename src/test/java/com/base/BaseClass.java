package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Velumani Devendiran
 * @Description Used to maintain all Reusable methods
 * @Date 26/08/2022
 * 
 */
public class BaseClass {

	public static WebDriver driver;

	/**
	 * @Description Used to get property file value pass the input as key and it
	 *              return the value
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	// Get Propertyfile Value

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"C:\\Users\\Velumani Devendiran\\eclipse-workspace\\OMRBranchAdactinAutomation\\Config\\Config.properties"));
		String string = (String) properties.get(key);
		return string;
	}

	/**
	 * @Description Used to browse websites on the Different browers
	 * @param browserType
	 */
	// 1. Get Driver:
	public static void getDriver(String browserType) {
		switch (browserType) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}

	/**
	 * @Description Used to Launch url in Browers
	 * @param url
	 */
	// 2. Enter URL:
	public static void enterUrl(String url) {
		driver.get(url);
	}

	/**
	 * @Description Used to Maximize the Browser page
	 */
	// 3. Window Maximize:
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @Description Used to Enter values in Webelement locators
	 * @param element
	 * @param data
	 */
	// 4. SenKeys:
	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	/**
	 * @Description Used to Click Webelement locators
	 * @param element
	 */
	// 5. Click:
	public void elementClick(WebElement element) {
		element.click();
	}

	/**
	 * @Description Used to Get values in Webelement locators
	 * @return Title
	 */
	// 6. Get Title:
	public String getApplicationTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @Description Used to find Webelement locators with help of findbyid
	 * @param attributevalue
	 * @return element
	 */
	// 7. Find Element ById:
	public WebElement elementFindById(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}

	/**
	 * @Description Used to find Webelement locators with help of findbyName
	 * @param attributevalue
	 * @return element
	 */
	// 8. Find Element ByName:
	public WebElement elementFindByName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}

	/**
	 * @Description Used to find Webelement locators with help of FindByClass
	 * @param attributevalue
	 * @return element
	 */
	// 9. Find Element ByClassName:
	public WebElement elementFindByClassName(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}

	/**
	 * @Description Used to find Webelement locators with help of findByXpath
	 * @param text
	 * @return txt
	 */
	// 10. Find ElementByXpath:
	public WebElement elementFindByXpath(String text) {
		WebElement txt = driver.findElement(By.xpath(text));
		return txt;
	}

	/**
	 * @Description Used to Current Web page URL
	 * @return currenturl
	 */

	// 11. Get Current URL
	public String getApplicationURL() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * @Description Used to Quit all web pages
	 */
	// 12. Close All window:
	public static void quitWindow() {
		driver.quit();
	}

	/**
	 * @Description Used to close current Window
	 */
	// 13. Close current window:
	public void closeWindow() {
		driver.close();
	}

	/**
	 * @Description Used to get Webelement text
	 * @param element
	 * @return text
	 */

	// 14. Get text:
	public String elementGettext(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @Description Used to get Webelement value
	 * @param element
	 * @return attribute
	 */

	// 15. get Attribute by value:
	public String elementGetAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	/**
	 * @Description Used to get Webelement attribute
	 * @param element
	 * @param attributename
	 * @return attribute
	 */
	// 16. get Attribute byName:
	public String elementGetAttribute(WebElement element, String attributename) {
		String attribute = element.getAttribute(attributename);
		return attribute;
	}

	/**
	 * @Description Used to select webelement text
	 * @param element
	 * @param text
	 */
	// 17. Select Drop Down by text:
	public void selectOptionBytext(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @Description Used to get select Webelement Value
	 * @param element
	 * @param value
	 */
	// 18. Select DropDown option by Attribute:
	public void selectionOprionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * @Description Used to get Webelement with help of index
	 * @param element
	 * @param index
	 */
	// 19. Select DropDown option by Index:
	public void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * @Description Used to send attribute value in Webelement with help of
	 *              JavaScript
	 * @param element
	 * @param text
	 */
	// 20. Insert values in textBox by JS:

	public void elementsenkKeysJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].setAttribute('value'," + text + ")", element);
	}

	/**
	 * @Description Used to wait time of get element text
	 * @param arg0
	 * @throws InterruptedException
	 */

	// 21. Set SleepTime:
	public void sleep(long arg0) throws InterruptedException {
		Thread.sleep(3000);
	}

	/**
	 * @Description Used to Mouse Over Action
	 * @param element
	 */

	// 22. Mouse OverAction moveToElement:
	public void moveTOElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * @Description Used to Drag and Drop for a value from Source to Destination
	 * @param source
	 * @param target
	 */
	// 23. Drag and Drop:
	public void drogAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	/**
	 * @Description Used to select Right Click
	 * @param target
	 */
	// 24. Right Click (drog and drop):
	public void contextClick(WebElement target) {
		Actions action = new Actions(driver);
		action.contextClick(target).perform();
	}

	/**
	 * @Description Used to Perform keybord acction whille keyPress with help of
	 *              Robot Class
	 * @param keycode
	 * @throws AWTException
	 */
	// 25. KeyBoard Action KeyPress using Robot Class:
	public void keyPress(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keycode);
	}

	/**
	 * @Description Used to Perform keybord acction whille keyrelease with help of
	 *              Robot Class
	 * @param Keycode
	 * @throws AWTException
	 */
	// 26. Keyboard Action Keyrelease by using Robot Class:
	public void keyRelease(int Keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(Keycode);
	}

	/**
	 * @Description Used to perform for keyUp action
	 * @param target
	 * @param key
	 */
	// 27. Actions KeyUp:
	public void keyUp(WebElement target, CharSequence key) {
		Actions action = new Actions(driver);
		action.keyUp(target, key);
	}

	/**
	 * @Description Used to perform for keyDown action
	 * @param target
	 * @param key
	 */
	// 28. Action KeyDown:
	public void keyDown(WebElement target, CharSequence key) {
		Actions action = new Actions(driver);
		action.keyDown(target, key);
	}

	/**
	 * @Description Used to select doubleclick function
	 */
	// 29. Double Click:
	public void doubleClick() {
		Actions action = new Actions(driver);
		action.doubleClick();
	}

	/**
	 * @Description Used to perform alerts function
	 * @return alert
	 */
	// 30. Alerts
	public Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	/**
	 * @Description Used to perform Accept alert
	 */
	// 31. Alert to ok (or) accept:
	public void accept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * @Description Used to perform Cancel alert
	 */
	// 32. Alert to Cancel or Dismiss :
	public void dismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * @Description Used to perform takescreen shot while checking some errors or
	 *              doubt clarifaction to take screenshot on particular page or
	 *              Webelement
	 * @param pathname
	 */
	// 33. TakeScreen Shot:
	public void getScreenShotAs(String pathname) {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File screenshotAs = tk.getScreenshotAs(OutputType.FILE);
		File desfile = new File(pathname);
	}

	/**
	 * @Description Used to copy file from one source to destination
	 * @param srcFile
	 * @param desFile
	 * @throws IOException
	 */
	// 34. Copy File:
	public void copyFile(File srcFile, File desFile) throws IOException {
		FileUtils.copyFile(srcFile, desFile);
	}

	/**
	 * @Description Used to click webelement with help of JavaScript
	 * @param element
	 * @param text
	 */
	// 35. Click button by using JavaScript JS:
	public void clickJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].click", element);
	}

	/**
	 * @Description Used to create URL navigation
	 * @param url
	 */
	// 36. navigate the URL:
	public void navigationTo(String url) {
		Navigation navigate = driver.navigate();
		navigate.to(url);
	}

	/**
	 * @Description Used to Backward URL
	 */
	// 37. Navigate Backward Url:
	public void navigateBack() {
		Navigation navigate = driver.navigate();
		navigate.back();
	}

	/**
	 * @Description Used to Forward URL
	 */
	// 38. Navigate Forward Url:
	public void navigateForward() {
		Navigation navigate = driver.navigate();
		navigate.forward();
	}

	/**
	 * @Description Used to Refresh URL
	 */
	// 39. navigate refresh URL:
	public void navigaterefresh() {
		Navigation navigate = driver.navigate();
		navigate.refresh();
	}

	/**
	 * @Description Used to Scrolldown in Object with help of Java Scribt
	 * @param scrollDown
	 */
	// 40. To ScrollDown By Java Script:
	public void scrollDownJS(Object scrollDown) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0],scrollIntoview(true)", scrollDown);
	}

	/**
	 * @Description Used to ScrollUP in Object with help of Java Scribt
	 */
	// 41. To ScrollUp by using javaScript:
	public void scrollupJS(Object scrollUp) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoview(false)", scrollUp);
	}

	/**
	 * @Descrription Used to deselect visible text Webelements
	 * @param element
	 * @param text
	 */
	// 42. DropDown deselect option By text:
	public void deselectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	/**
	 * @Description
	 * @param element
	 *            Used to deselect visible value Webelements
	 * @param value
	 */

	// 43. DropDown Deselese Option ByAttribute
	public void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * @Description Used to deselectAll Webelements
	 * @param element
	 */
	// 44. DropDown deselect all option:
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	/**
	 * @Description Used to Verify drop down is multiple Webelement
	 * @param element
	 * @return
	 */

	// 45. DropDown is multiple option:
	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	/**
	 * @Description Used to verify dropdownall webelements
	 * @param element
	 * @return
	 */

	// 46. DropDown get All option:
	public List<WebElement> getAllOption(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getAllSelectedOptions();
		return options;
	}

	/**
	 * @Description User should get all selected webelemnts using select class
	 * @param element
	 * @return
	 */
	// 47. DropDown get all selected Option:
	public List<WebElement> getAllSelectedOption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;
	}

	/**
	 * @Description Used to select all dropdown select webelement
	 * @param element
	 */
	// 48. DropDown First Select Option:
	public void getSelectOption(WebElement element) {
		Select select = new Select(element);
		select.getFirstSelectedOption();
	}

	/**
	 * @Description Used to switch frame using frame index
	 * @param index
	 */
	// 49. Switch to Frame By index:
	public void frambeByIndex(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * @Description Used to get file location
	 * @param Location
	 * @return Location
	 */

	// 50. Get File:
	public String getFile(String Location) {
		File file = new File(Location);
		return Location;
	}

	/**
	 * @Description Used to Read values from Excel with help of file, File
	 *              Inputstream, Work book (XSSFWorkBook)and using switch for Cell
	 *              values Numeric(Dateformat) and String
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return rev
	 * @throws InvalidFormatException
	 * @throws IOException
	 */

	// 51. Get Data From Excel:
	public String readValueExcel(String sheetName, int rownum, int cellnum) throws InvalidFormatException, IOException {
		String rev = "";
		File file = new File("C:\\Users\\Velumani Devendiran\\eclipse-workspace\\MavenFirst\\Excel\\Test.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();

		switch (cellType) {
		case STRING:
			rev = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				rev = dateFormat.format(dateCellValue);
			} else {
				double d = cell.getNumericCellValue();
				long round = Math.round(d);
				if (round == d) {
					rev = String.valueOf(round);
				}
			}

		}
		return rev;
	}

	/**
	 * * @Description Used Write values from Excel with help of file, File
	 * Outputstream, Work book (XSSFWorkBook)
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws IOException
	 */
	// 52. write data from Excel:
	public void writeValueExcel(String sheetName, int rownum, int cellnum, String data) throws IOException {

		File file = new File("C:\\Users\\Velumani Devendiran\\eclipse-workspace\\MavenFirst\\Excel\\Test.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}
	/**
	 * @Description Used to clear webelement text 
	 * @param element
	 */

	// 53. Clear Text
	public void elementClear(WebElement element) {
		element.clear();

	}

}
