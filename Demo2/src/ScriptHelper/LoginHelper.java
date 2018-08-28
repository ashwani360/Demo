package ScriptHelper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Driver.DriverHelper;
import Driver.xmlreader;

public class LoginHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\Login.xml");
	
	public LoginHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void Login(String Application) throws Exception
	{
		// Click on the First link to navigate to the Login page
		openurl(Application);
		// Enter the User name
		SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/Username")),Getkeyvalue(Application+"_Username"));
		// Enter Password
		SendKeys(getwebelement(xml.getlocator("//locators/"+Application+"/Password")),Getkeyvalue(Application+"_Password"));
		// Click on Login button
		Clickon(getwebelement(xml.getlocator("//locators/"+Application+"/Loginbutton")));
		// Skip the Intro Part
		
		
	}
	public void VerifySuccessLogin(String application) throws Exception
	{
		// Verify that the name of the Logged in user is gettign displayed
		Assert.assertEquals(Getkeyvalue(application+"_LoggedinUser").contains(Gettext(getwebelement(xml.getlocator("//locators/"+application+"/Userinfo")))),true);
		
	}
	
}
