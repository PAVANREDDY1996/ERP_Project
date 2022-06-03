package automationPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_RESET {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chorme.driver",  "chormedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/webapp/login.php");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='btnreset']")).click();
		
		String uname = driver.findElement(By.xpath("//input[@id='username']")).getAttribute("value");
		String password = driver.findElement(By.xpath("//input[@id='password']")).getAttribute("value");
		
		if(uname.isEmpty() && password.isEmpty()) {
			System.out.println("RESET is working, Testcase passed");
		} else {
			System.out.println("RESET is not working, Testcase failed");
		}
	}
}
