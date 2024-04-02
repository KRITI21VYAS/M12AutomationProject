package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1:create Seperate POM class for every webpage
 
	//Rule 2 : identify webElements using @findBy and make the private
	@FindBy(name = "user_name")
	private WebElement usernameTextField;
	
	@FindBy(name = "user_password")
	private WebElement passwordtextField;
	
	@FindBy(id = "submitButton")
	private WebElement submitButton;
	
	//Rule 3: Create a constructor for initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//provide getters (only)
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordtextField() {
		return passwordtextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//provide Business library if required--->Generic method
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password) {
		usernameTextField.sendKeys(username);
		passwordtextField.sendKeys(password);
		submitButton.click();
	}
	
	
}
