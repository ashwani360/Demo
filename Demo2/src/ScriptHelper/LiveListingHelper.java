package ScriptHelper;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Driver.DriverHelper;
import Driver.xmlreader;

public class LiveListingHelper extends DriverHelper{
	
	
	
	public LiveListingHelper(WebDriver parentdriver) {
		super(parentdriver);
	}


	WebElement el;
	xmlreader xml=new xmlreader("C:\\Users\\ashwanis\\eclipse-workspace\\Demo2\\src\\Locators\\Inventorylivelisting.xml");
	
	
	public void VerifyLivetitle(String result) throws Exception
	{
		Thread.sleep(3000);
		Switchtoliveandverify(xml.getlocator("//locators/Title"),result);
		
		
	}
	public void Searchandverify(String text) throws Exception, DocumentException
	{
		SendKeys(getwebelement(xml.getlocator("//locators/Keyword")),text);
		Clickon(getwebelement(xml.getlocator("//locators/Search")));
		Assert.assertEquals(text, Gettext(getwebelement(xml.getlocator("//locators/Title"))));
		
	}
}

