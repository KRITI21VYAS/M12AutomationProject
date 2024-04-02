package contactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

public class CreateNewContactWithLeadSource extends BaseClass
{
	@Test(groups="RegressionSuite")
  public void createContactWithMandatoryfield() throws EncryptedDocumentException, IOException {
		//read data from excel file	
	    String lastname = eutil.readDataFromExcelfile("contacts", 4, 2);
	    String leadSource = eutil.readDataFromExcelfile("contacts", 4, 3);
			
	//test script for contacts module
	  
	  //navigate to contacts link
	   HomePage hp=new HomePage(driver);
	   hp.clickOnContactsLink();
	  
	  //click on contact lookUp image
	  ContactsPage cp = new ContactsPage(driver);
	  cp.clickOnCreateContactLookUpimg();
			
	  //create contact with mandatory fields
	  CreateNewContactPage createContact=new CreateNewContactPage(driver);
	  createContact.CreateNewContact(lastname, leadSource);
	  
	  //validate for contacts
	  ContactInfoPage info = new ContactInfoPage(driver);
	    String contact_Header = info.captureContactHeaderText();	
		Assert.assertTrue(contact_Header.contains(lastname));
			System.out.println(contact_Header);
			
	  
  }
	
}
