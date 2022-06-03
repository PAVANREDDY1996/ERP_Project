package automationPrograms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonMethods.BaseMethods;

public class TC7_AccessToStockCategoriesPage {
	public static void main(String[] args) {
		// Access to the Access To StockCategories Page
	
		BaseMethods base = new BaseMethods();
		base.openBrowser();
		base.launchERP();
		base.loginERP();
		
        WebElement stockItems = base.driver.findElement(By.id("mi_a_stock_items"));
		Actions actions = new Actions(base.driver);
		actions.moveToElement(stockItems).build().perform();
		
		WebElement stockCat = base.driver.findElement(By.id("mi_a_stock_categories"));
		actions.moveToElement(stockCat).build().perform(); 
		stockCat.click();
		  
		String pageName = base.driver.findElement(By.id("ewPageCaption")).getText();
		if(pageName.equals("Stock Categories")) {
			  System.out.println("Stock Categories page is displayed.. Testcase is passed"); 
		} else 
		{ 
			System.out.println("Testcase is Failed.."); 
		}
	}
}
