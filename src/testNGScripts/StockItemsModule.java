package testNGScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commonMethods.BaseMethods;

public class StockItemsModule {

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
  public void TC9_Verify_admin_user_is_able_to_create_new_stockItem() {
	base.AccessToStockItemsPage();
	base.addStockItem();
  }
  
    
}
