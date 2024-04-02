package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
 @FindBy(xpath = "//span[@class='dvHeaderText']")
 private WebElement contactHeader;
 
 
 //Initialization
 public ContactInfoPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 //utilization
public WebElement getContactHeader() {
	return contactHeader;
}
//Business library
/**
 * This method will capture the contact header text and return it to caller
 * @return
 */
public String captureContactHeaderText() {
	return contactHeader.getText();
}
 
 
}
