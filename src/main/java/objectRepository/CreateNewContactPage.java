package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.ExcelFileUtility;
import genericUtilities.SeleniumUtilities;

public class CreateNewContactPage extends SeleniumUtilities{
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveButton;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	//Business Library
	/**
	 * This method will create new contact
	 * @param lastname
	 */
	public void CreateNewContact(String lastname) {
		lastNameTextField.sendKeys(lastname);
		saveButton.click();	
	}
	
	/**
	 * This method will create new contact with lead source drop down
	 * @param lastname
	 * @param leadSourceValue
	 */
	public void CreateNewContact(String lastname,String leadSourceValue) {
		lastNameTextField.sendKeys(lastname);
		handleDropDown(leadSourceDropDown,leadSourceValue);
		saveButton.click();	
	}
	
	

}
