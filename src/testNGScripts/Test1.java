package testNGScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	
  @BeforeTest
  public void initialSetup() {
	  System.out.println("This method will setup the initial test Data");
  }
  
  @AfterTest
  public void cleanUpSetup() {
	  System.out.println("This method will clean up the initial test Data");
  }

  @BeforeMethod
  public void openBrowser() {
	  System.out.println("This method will open a New Browser");
  }
  
  @AfterMethod
  public void closeBrowser() {
	  System.out.println("This method will close the driver instance");
  }
	
  @Test (priority = 1)
  public void TestCase_1() {
	  System.out.println("This is my first testcase in TestNG..");
  }
  
  @Test (priority = 2)
  public void TestCase_2() {
	  System.out.println("This is my second testcase in TestNG..");
  }
  
  @Test (priority = 0)
  public void TestCase_3() {
	  System.out.println("This is my third testcase in TestNG..");
  }
  
}
