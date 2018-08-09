package ScriptHelper;

import org.dom4j.DocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Driver.DriverHelper;
import Driver.xmlreader;

public class InventoryHelper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("C:\\Users\\ashwanis\\eclipse-workspace\\Demo2\\src\\Locators\\Inventory.xml");
	
	public InventoryHelper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void GotoInventory() throws Exception
	{
		// Click on the Inventory icon to navigate to the Login page
		Clickon(getwebelement(xml.getlocator("//locators/InventoryLink")));
		
	}
	public void VerifytheInventoryPage() throws Exception
	{
		// Verify that the name of the Logged in user is gettign displayed
		//Assert.assertEquals(Getkeyvalue("LoggedinUser"), Gettext(getwebelement(xml.getlocator("//locators/Userinfo"))));
		
	}
	public void EnterInventory(String a1, String a2,String a3,String a4,String a5,String a6,String a7) throws DocumentException, Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AddInventoryLink")));
		Select(getwebelement(xml.getlocator("//locators/ListingClass")),a1);
		Select(getwebelement(xml.getlocator("//locators/Category")),a2);
		Clickon(getwebelement(xml.getlocator("//locators/Addcategory")));
		Select(getwebelement(xml.getlocator("//locators/Year")),a3);
		Select(getwebelement(xml.getlocator("//locators/Make")),a4);
		Thread.sleep(1000);
		Select(getwebelement(xml.getlocator("//locators/Model")),a5);
		Select(getwebelement(xml.getlocator("//locators/Cabtype")),a6);
		SendKeys(getwebelement(xml.getlocator("//locators/Price")),a7);
		Thread.sleep(1000);
	}
	public void AddInventry() throws  Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/AddinvertyData")));
	}
	public void AddDescription(String Text) throws Exception
	{
		//Clickon(getwebelement(xml.getlocator("//locators/VIN")));
		//Switchtoifram();
		
		AddTextintoeditor(Text);
	}
	public void SaveInventory() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/Save")));
		Thread.sleep(3000);
	}
	public void PublishListing() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/PostListing")));
		Thread.sleep(1000);
		Clickon(getwebelement(xml.getlocator("//locators/AlertConfirm")));
	}
	
	
}
