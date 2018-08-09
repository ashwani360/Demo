package Testscript;
import org.testng.annotations.Test;

import Driver.DriverTestcase;
import Reporter.ExtentTestManager;
import Driver.DataReader;

public class Login extends DriverTestcase {
	
	
@Test
	public void LoginasAdmin() throws Exception
	{
	//ExtentTestManager.getTest().setDescription("Login as an admin");
	Login.Login();
	Login.VerifySuccessLogin();
	
	}


}
