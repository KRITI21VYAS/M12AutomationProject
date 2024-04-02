package Practice;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Scenario1 
{
  public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	 //read data from property file 
	  FileInputStream fis0 = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();		
		p.load(fis0);	
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASS = p.getProperty("password");
		
		
	//read data from excel file
		
		 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\AdSelenium_contacts.xlsx");				
			Workbook wbf = WorkbookFactory.create(fis);
			Sheet sh = wbf.getSheet("contacts");
			Row row = sh.getRow(1);
			Cell cell = row.getCell(2);
			String lastname = cell.getStringCellValue();
			
	//test script for contacts module		
		
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.get(URL);  
	  driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
	  driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASS);
	  driver.findElement(By.id("submitButton")).click();
	  	//navigate to contacts link
	  driver.findElement(By.linkText("Contacts")).click();
		//click on create contact lookup image
	  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click(); 
		 //create contact with mandatory field and save
	  driver.findElement(By.name("lastname")).sendKeys(lastname);	 
	  driver.findElement(By.xpath("//input[@value='  Save  ']")).click();	
		 //validate for contacts
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains("vyas")) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		//logout from the application
		 WebElement signout = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		 Actions a = new Actions(driver);
		 a.moveToElement(signout).build().perform();
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 driver.quit();
  
  }
}
		
		
	


