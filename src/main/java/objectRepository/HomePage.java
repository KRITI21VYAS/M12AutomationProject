package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

public class HomePage extends SeleniumUtilities {
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(xpath = "(//td[@class='small'])[2]")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignout() {
		return signout;
	}
	
	//Business Library
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactsLink() {
		contactsLink.click();
	}
	
	/**
	 * This method will logout of the application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException {
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(2000);
		signout.click();
	} 
	
	

}
