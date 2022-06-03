package automationPrograms;
import org.openqa.selenium.By;

import commonMethods.BaseMethods;

public class TC6_AccessToCustomersPage {
	public static void main(String[] args) {
		// Access to the Customers Page
	
		BaseMethods base = new BaseMethods();
		base.openBrowser();
		base.launchERP();
		base.loginERP();
		base.driver.findElement(By.id("mi_a_customers")).click();
		String pageName = base.driver.findElement(By.id("ewPageCaption")).getText();
		if(pageName.equals("Customers")) {
			System.out.println("Customers page is displayed.. Testcase is passed");
		} else {
			System.out.println("Testcase is Failed..");
		}
	}

}
