package automationPrograms;

import org.openqa.selenium.By;

import commonMethods.BaseMethods;

public class TC5_ByUsingInheritanceConcept extends BaseMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TC5_ByUsingInheritanceConcept tc5 = new TC5_ByUsingInheritanceConcept();
		tc5.openBrowser();
		tc5.launchERP();
		tc5.loginERP();
		//click on the stock Items menu 
		tc5.driver.findElement(By.xpath("//li[@id='mi_a_stock_items']")).click();
		
		// put the validation code to check stock Items page is opened or not
		String pcaption = tc5.driver.findElement(By.id("ewPageCaption")).getText();
		if (pcaption.equals("Stock Items")) {
			System.out.println("Stock Item page has displayed, and Test case is Passed");
			} else {
				System.out.println("Stock Item page is not displayed, and Test case is Failed");
			}
	}
}
