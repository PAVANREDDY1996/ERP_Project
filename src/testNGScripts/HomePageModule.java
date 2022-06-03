package testNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commonMethods.BaseMethods;

public class HomePageModule {

  BaseMethods base;
  
  @Parameters({ "username", "password", "url" })
  @BeforeMethod
  public void launch_Application(String uname, String pass, String url) {
	  base = new BaseMethods();
	  base.openBrowser();
	  base.launchERP(url);
	  base.loginERP(uname, pass);
  }
  
  @AfterMethod
  public void close_Application() {
	  base.driver.close();
  }
	
  @Test
  public void TC5_AccessToStockItemsPage() {
	//click on the stock Items menu 
	  base.driver.findElement(By.xpath("//li[@id='mi_a_stock_items']")).click();
	// put the validation code to check stock Items page is opened or not
	 String pcaption = base.driver.findElement(By.id("ewPageCaption")).getText();
	 Assert.assertTrue(pcaption.equals("Stock Items"));
  }
  
  @Test
  public void TC6_AccessToCustomersPage() {
	  base.driver.findElement(By.id("mi_a_customers")).click();
	  String pageName = base.driver.findElement(By.id("ewPageCaption")).getText();
	  Assert.assertTrue(pageName.equals("Customers111"));
  }
  
}
