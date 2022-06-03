package automationPrograms;

import org.openqa.selenium.By;

import commonMethods.BaseMethods;

public class TC5_AccessToStockItemsPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BaseMethods base = new BaseMethods();
		base.openBrowser();
		base.launchERP();
		base.loginERP();
		//click on the stock Items menu 
		base.driver.findElement(By.xpath("//li[@id='mi_a_stock_items']")).click();
		
		// put the validation code to check stock Items page is opened or not
		String pcaption = base.driver.findElement(By.id("ewPageCaption")).getText();
		if (pcaption.equals("Stock Items")) {
			System.out.println("Stock Item page has displayed, and Test case is Passed");
			} else {
				System.out.println("Stock Item page is not displayed, and Test case is Failed");
			}
	}
}
