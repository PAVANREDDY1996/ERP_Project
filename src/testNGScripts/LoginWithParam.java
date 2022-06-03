package testNGScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonMethods.BaseMethods;

public class LoginWithParam {
	
  BaseMethods base;

  @Parameters({ "username", "password", "url" })
  @Test
  public void LoginTC(String uname, String pass, String url) {
	  
	  base = new BaseMethods();
	  base.openBrowser();
	  base.launchERP(url);
	  base.loginERP(uname, pass);
  }
}
