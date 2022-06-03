package testNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import commonMethods.BaseMethods;

public class LoginModule {

  BaseMethods base;
  
  @BeforeMethod
  public void launch_Application() {
	  base = new BaseMethods();
	  base.openBrowser();
	  base.launchERP();
  }
  
  @AfterMethod
  public void close_Application() {
	  base.driver.close();
  }
	
  @Test
  public void TC1_Login() {
	  base.loginERP();
  }
  
  @Test
  public void TC2_Logout() {
	  base.loginERP();
	  base.driver.findElement(By.id("mi_logout")).click();
	  Assert.assertFalse(base.driver.findElement(By.id("btnsubmit")).isEnabled());
  }
  
  @Test
  public void TC3_InvalidLogin() {
	    base.driver.findElement(By.xpath("//input[@id='username']")).clear();
		base.driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin123");
		base.driver.findElement(By.xpath("//input[@id='password']")).clear();
		base.driver.findElement(By.xpath("//input[@id='password']")).sendKeys("master");
		base.driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		
		base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String alertWindow = base.driver.getWindowHandle();	
		base.driver.switchTo().window(alertWindow);
		
		String actResult = base.driver.findElement(By.xpath("//div[@class='alert alert-danger ewError']")).getText();
		System.out.println("Actual Result is : " + actResult);
		Assert.assertTrue(actResult.contains("Incorrect"));
  }
  
  @Test
  public void TC4_RESET() {
	    base.driver.findElement(By.xpath("//button[@id='btnreset']")).click();
		String uname = base.driver.findElement(By.xpath("//input[@id='username']")).getAttribute("value");
		String password = base.driver.findElement(By.xpath("//input[@id='password']")).getAttribute("value");
		Assert.assertTrue(uname.isEmpty() && password.isEmpty());
  }
}
