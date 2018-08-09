package ScriptHelper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Driver.DriverHelper;
import Driver.xmlreader;

public class LoginHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("C:\\Users\\ashwanis\\eclipse-workspace\\Demo2\\src\\Locators\\Login.xml");
	
	public LoginHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void Login() throws Exception
	{
		// Click on the First link to navigate to the Login page
		Clickon(getwebelement(xml.getlocator("//locators/LoginNavigation")));
		Thread.sleep(1000);
		// Enter the User name
		SendKeys(getwebelement(xml.getlocator("//locators/Username")),Getkeyvalue("Username"));
		// Enter Password
		SendKeys(getwebelement(xml.getlocator("//locators/Password")),Getkeyvalue("Password"));
		// Click on Login button
		Clickon(getwebelement(xml.getlocator("//locators/Loginbutton")));
		// Skip the Intro Part
		
		Clickon(getwebelement(xml.getlocator("//locators/SkipeIntro")));
		//System.out.pri
		//SendinputKeys(getwebelement(xml.getlocator("//locators/SkipeIntro")),Keys.ESCAPE);
		Thread.sleep(1000);
		
	}
	public void VerifySuccessLogin() throws Exception
	{
		// Verify that the name of the Logged in user is gettign displayed
		Assert.assertEquals(Getkeyvalue("LoggedinUser"), Gettext(getwebelement(xml.getlocator("//locators/Userinfo"))));
		
	}
	
}
