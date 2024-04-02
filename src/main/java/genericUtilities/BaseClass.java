package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of basic configuration of TestNg
 * @author 91831
 *
 */
public class BaseClass {
	public ExcelFileUtility eutil=new ExcelFileUtility();
    public PropertyFileUtility putil = new PropertyFileUtility();
	public SeleniumUtilities sutil = new SeleniumUtilities();
	public WebDriver driver;
	public static WebDriver sdriver;//for listeners --so that we will not give the entire base class access,only listner class can use this driver
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig() {
		System.out.println("DB Connection Successfull");
	}
	
	//@Parameters("Browser")
	// @BeforeTest  //for parallel execution
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String value*/) throws IOException {
		String url = putil.readDataFromPropertyfile("url");
		driver = new ChromeDriver();
//		if(value.equals("Chrome")) 
//		{
//			driver = new ChromeDriver();
//		}else if (value.equals("Edge")) {
//			driver = new EdgeDriver();
//		}else {
//			System.out.println("select a browser");
//		}
		sutil.maximizeWindow(driver);
		sutil.implicitWait(driver);
		sdriver=driver; // for listeners only we are doing this
		driver.get(url);
		System.out.println("Browser launch successfull");
		
	}
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException{
		
	 String userName=putil.readDataFromPropertyfile("username");
	String passWord = putil.readDataFromPropertyfile("password");
	 LoginPage lp = new LoginPage(driver);
	 lp.loginToApp(userName, passWord);
	 System.out.println("login to app successfull");	 
	}
	
	@AfterMethod(alwaysRun=true)
	public void afConfig() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("logout of app succssfull");
	}
	
	@AfterTest  //for parallel execution
	//@AfterClass(alwaysRun=true)
	public void acConfig() {
		driver.quit();
		System.out.println("browser closure successfull");
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig() {
		System.out.println("DataBase connection closure");
	}
	

}
