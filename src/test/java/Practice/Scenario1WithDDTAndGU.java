package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtilities;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndGU {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//create object of all utility classes
		ExcelFileUtility eutil = new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		SeleniumUtilities sutil = new SeleniumUtilities();
		
		String URL = putil.readDataFromPropertyfile("url");
		String USERNAME = putil.readDataFromPropertyfile("username");
		String PASS = putil.readDataFromPropertyfile("password");
		
		
	//read data from excel file
		
			String lastname = eutil.readDataFromExcelfile("contacts", 1, 2);
			
	//test script for contacts module		
		
	  WebDriver driver = new ChromeDriver();
	  sutil.maximizeWindow(driver);
	  sutil.implicitWait(driver);
	  driver.get(URL); 
	  //LOGIN TO THE APPLICATION
//	  driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
//	  driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASS);
//	  driver.findElement(By.id("submitButton")).click();
	  
	  LoginPage lp = new LoginPage(driver);
	  lp.loginToApp(USERNAME, PASS);
	  
//	  lp.getUsernameTextField().sendKeys(USERNAME);
//	  lp.getPasswordtextField().sendKeys(PASS);
//	  lp.getSubmitButton().click();
	  
	  	//navigate to contacts link
	  ContactsPage contacts = new ContactsPage(driver);
	  contacts.clickOnCreateContactLookUpimg();
	 // driver.findElement(By.linkText("Contacts")).click();
		//click on create contact lookup image
	  CreateNewContactPage createContact=new CreateNewContactPage(driver);
	 String last_name= eutil.readDataFromExcelfile("contacts", 1, 2);
	  createContact.CreateNewContact(last_name);
	  
	 // driver.findElement(By.xpath("//img[@title='Create Contact...']")).click(); 
		 //create contact with mandatory field and save
	 // driver.findElement(By.name("lastname")).sendKeys(lastname);	 
	 // driver.findElement(By.xpath("//input[@value='  Save  ']")).click();	
		 //validate for contacts
	  ContactInfoPage info = new ContactInfoPage(driver);
	    WebElement contact_Header = info.getContactHeader();
	  
	  
		//String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if(contactHeader.contains("vyas")) {
//			System.out.println("pass");
//		}else {
//			System.out.println("fail");
//		}
		//logout from the application
		 WebElement signout = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		 sutil.mouseHoverAction(driver, signout);
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 driver.quit();
  
  }

	}


