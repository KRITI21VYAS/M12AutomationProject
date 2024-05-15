package contactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtilities;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(genericUtilities.ListnersImplementation.class)
public class CreateNewContactTest extends BaseClass {

	@Test(groups="SmokeSuite")
	public void createContactWithMandatoryfield() throws IOException, InterruptedException
 {
		
		//read data from excel file	
		    String lastname = eutil.readDataFromExcelfile("contacts", 1, 2);
				
		//test script for contacts module
		  
		  //navigate to contacts link
		   HomePage hp=new HomePage(driver);
		   hp.clickOnContactsLink();
		  
		  //click on contact lookUp image
		  ContactsPage cp = new ContactsPage(driver);
		  cp.clickOnCreateContactLookUpimg();
				
		  //create contact with mandatory fields
		  CreateNewContactPage createContact=new CreateNewContactPage(driver);
		  createContact.CreateNewContact(lastname);
		 // Assert.fail();//for listeners-onTestFailure-screenshot--> this assert.fail is used to explicitly fail a test script
		  
		  //validate for contacts
		  ContactInfoPage info = new ContactInfoPage(driver);
		    String contact_Header = info.captureContactHeaderText();	
			Assert.assertTrue(contact_Header.contains(lastname));
				System.out.println(contact_Header);			
				
}
	@Test
	public void sample() {
		System.out.println("from sample");
		System.out.println("omg");
	}
}
