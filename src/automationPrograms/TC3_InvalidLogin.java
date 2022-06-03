package automationPrograms;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TC3_InvalidLogin {
	public static void main(String[] args) {
		// Invalid Login TestCase
		System.setProperty("webdriver.chorme.driver",  "chormedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/webapp/login.php");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("master");
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String alertWindow = driver.getWindowHandle();	
		driver.switchTo().window(alertWindow);
		
		String actResult = driver.findElement(By.xpath("//div[@class='alert alert-danger ewError']")).getText();
		System.out.println("Actual Result is : " + actResult);
		if(actResult.contains("Incorrect")) {
			System.out.println("Invalid login Testcase is passed");
		} else {
			System.out.println("Testcase is Failed..");
		}
	}

}
