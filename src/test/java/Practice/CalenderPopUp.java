package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderPopUp {

	public static void main(String[] args) {
		
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get("https://www.makemytrip.com/");
		  
		  driver.findElement(By.xpath("//span[text()='Departure']")).click();
		  driver.findElement(By.xpath("[aria-label='Thu Apr 04 2024']")).click();
		  
		 WebElement nextMonth = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
		 
		  

	}

}
