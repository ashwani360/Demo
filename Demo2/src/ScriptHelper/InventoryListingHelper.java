package ScriptHelper;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Driver.DriverHelper;
import Driver.xmlreader;

public class InventoryListingHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("C:\\Users\\ashwanis\\eclipse-workspace\\Demo2\\src\\Locators\\Inventorylisting.xml");
	
	public InventoryListingHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

	public void VerifyListing(String result) throws Exception, Exception
	{
		Thread.sleep(3000);
		Assert.assertEquals(result, Gettext(getwebelement(xml.getlocator("//locators/Name"))));
		
	}
	public void ViewLive() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/ViewLive")));
	}
}
