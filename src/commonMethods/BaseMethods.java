package commonMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseMethods {
	
	public WebDriver driver;
	
	//Open Browser
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "Tools//chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	//To Launch the ERP Application
	public void launchERP() {
		driver.get("http://webapp.qedgetech.com/login.php");
		driver.manage().window().maximize();
	}
	
	public void launchERP(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	//Login to the Application
	public void loginERP() {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("master");
		driver.findElement(By.id("btnsubmit")).click();
		String pName = driver.findElement(By.id("ewPageCaption")).getText();
		Assert.assertEquals(pName, "Dashboard");
	}
	
	public void loginERP(String uname, String pass) {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("btnsubmit")).click();
		String pName = driver.findElement(By.id("ewPageCaption")).getText();
		Assert.assertEquals(pName, "Dashboard");
	}
	
	//Logout ERP
		public void logoutERP() {
			driver.findElement(By.id("mi_logout")).click();
			//validate Login button existance
			
			if(driver.findElement(By.id("btnsubmit")).isEnabled()) {
				System.out.println("Logout is success, and Test case is Passed");
			} else {
				System.out.println("Logout is failed, and Test case is Failed");
			}
		}
	
	//close Application
	public void closeApp() {
		driver.close();
	}

	public void loginParam(String uname, String pass) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("btnsubmit")).click();
		String pName = driver.findElement(By.id("ewPageCaption")).getText();
		Assert.assertEquals(pName, "Dashboard");
	}

	public void AccessToStockItemsPage() {
		//click on the stock Items menu 
		  driver.findElement(By.xpath("//li[@id='mi_a_stock_items']")).click();
		// put the validation code to check stock Items page is opened or not
		 String pcaption = driver.findElement(By.id("ewPageCaption")).getText();
		 Assert.assertTrue(pcaption.equals("Stock Items"));
	}
	
	public void AccessToCustomersPage() {
		  driver.findElement(By.id("mi_a_customers")).click();
		  String pageName = driver.findElement(By.id("ewPageCaption")).getText();
		  Assert.assertTrue(pageName.equals("Customers"));
	}
	
	public void AccessToStockCategoriesPage() {
	      WebElement stockItems = driver.findElement(By.id("mi_a_stock_items"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(stockItems).build().perform();
			
		  WebElement stockCat = driver.findElement(By.id("mi_a_stock_categories"));
		  actions.moveToElement(stockCat).build().perform(); 
	      stockCat.click();
			  
		  String pageName = driver.findElement(By.id("ewPageCaption")).getText();
		  Assert.assertTrue(pageName.equals("Stock Categories"));
	}
	
	public void AccessToUOMPage() {
	     WebElement stockItems = driver.findElement(By.id("mi_a_stock_items"));
			
			Actions actions = new Actions(driver);
			actions.moveToElement(stockItems).build().perform();
			
			WebElement uom = driver.findElement(By.id("mi_a_unit_of_measurement"));
			actions.moveToElement(uom).build().perform();
			uom.click();
			
			String pageName = driver.findElement(By.id("ewPageCaption")).getText();
			Assert.assertTrue(pageName.equals("Unit of Measurement"));
	}
	
	public void addStockItem() {
		
		WebElement addStock = driver.findElement(By.xpath("(//span[@data-caption='Add'])[1]"));
		addStock.click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		Select category = new Select(driver.findElement(By.id("x_Category")));
		category.selectByVisibleText("mobiles");
		Select supplierNumber = new Select(driver.findElement(By.id("x_Supplier_Number")));
		supplierNumber.selectByVisibleText("First Supplier");
		WebElement stockName = driver.findElement(By.xpath("//input[@id='x_Stock_Name']"));
		stockName.sendKeys("Samsung Galaxy S21");
		Select uom = new Select(driver.findElement(By.id("x_Unit_Of_Measurement")));
		uom.selectByVisibleText("Units");
		WebElement purchasePrice = driver.findElement(By.xpath("//input[@id='x_Purchasing_Price']"));
		purchasePrice.sendKeys("100000");
		WebElement sellingPrice = driver.findElement(By.xpath("//input[@id='x_Selling_Price']"));
		sellingPrice.sendKeys("125000");
		WebElement notes = driver.findElement(By.xpath("//input[@id='x_Notes']"));
		notes.sendKeys("Samsung Galaxy S21");
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String alertWindow = driver.getWindowHandle();	
		driver.switchTo().window(alertWindow);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		WebElement confirm = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
		confirm.click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		BaseMethods.this.AccessToStockItemsPage();
		
	}

}
