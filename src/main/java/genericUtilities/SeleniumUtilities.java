package genericUtilities;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * 
 * This class consists of generic method related to Selenium WebDriver
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;


public class SeleniumUtilities {
	/**
	 * This method will maximize the browser
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{		
		driver.manage().window().maximize();	
	}
	
	/**
	 * This method will minimize the browser
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{		
		driver.manage().window().minimize();	
	}
	
	/**
	 * This method will add 15 seconds of implicit wait
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	/**
	 * This method will wait for 30 seconds for a web element to be visible
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	
	/**
	 * This method will handle dropDown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropDown by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element , String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle dropDown by visibleText
	 * @param element
	 * @param text
	 */
	public void handleDropDown(String text,WebElement element ) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse Hover actions on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).click().build().perform();
	}
	
	/**
	 * This method will perform right click action on the element
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions a = new Actions(driver);
		a.contextClick().build().perform();
	}
	
	/**
	 * This method will perform the  double click action on  the element
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		Actions a = new Actions(driver);
		a.doubleClick().build().perform();
	}
	
	
	/**
	 * This method will perform drag and drop action 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
	}
	
	/**
	 *  This method will scroll down the page 
	 */
	public void scrollDownThepage(WebDriver driver) {
		Actions a = new Actions(driver);
		a.keyDown(Keys.PAGE_DOWN).build().perform();	
	}
	
	/**
	 *  This method will scroll up the page 
	 */
	public void scrollUpThepage(WebDriver driver) {
		Actions a = new Actions(driver);
		a.keyUp(Keys.PAGE_UP).build().perform();	
	}
	
	/**
	 *  This method will scroll down the page to a particular webElement using java script executor
	 */
	public void ScrollUp(WebDriver driver,WebElement element ) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments.scrollIntoView();",element);
	}
	
	/**
	 * This method will handle frame by using web element
	 * @param driver
	 * @param element
	 */
	public void framehandle(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * this method will handle frames by index
	 * @param driver
	 * @param frameIndex
	 */
	public void framehandle(WebDriver driver,int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * this method will handle frames by name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void framehandle(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 *  this method will accept alert pop up 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
	  	  driver.switchTo().alert().accept();  	
	}
	
	/**
	 * this method will cancel alert pop up 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
	  	 driver.switchTo().alert().dismiss();  
	}
	
	
	/**
	 *  this method will enter text to alert pop up
	 * @param driver
	 */
	public void alertHandleByEnteringText(WebDriver driver,String text) {
	  	driver.switchTo().alert().sendKeys(text);  	
	}
	
	
	/**
	 * This method will capture the alert text and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
	  	return driver.switchTo().alert().getText();	  	
	}

	
	/**
	 * this method will capture the ScreenShot of the webPage and return the path to the caller
	 * @param driver
	 * @param screenShotName
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException {
	
		TakesScreenshot ss = (TakesScreenshot)driver;
		File from = ss.getScreenshotAs(OutputType.FILE);
		File to = new File(".\\ScreenShots\\"+screenShotName+".png");
		Files.copy(from, to);  //we can also use FileFandler
		return to.getAbsolutePath();//used for extent reports--->to see screen shot in report. with the proper path we can fetch that screen shot in report
	}
	
	
	
	
	
   
}
