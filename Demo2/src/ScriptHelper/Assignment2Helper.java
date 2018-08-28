package ScriptHelper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Driver.DriverHelper;
import Driver.xmlreader;
import Reporter.ExtentTestManager;

public class Assignment2Helper extends DriverHelper{
	
	
	
	WebElement el;
	xmlreader xml=new xmlreader("src\\Locators\\Assignment2.xml");
	
	public Assignment2Helper(WebDriver parentdriver)
	{
		super(parentdriver);
	}

//---------------------------------
	public void OpenInsurancepage() throws Exception
	{
		// Click on the First link to navigate to the Login page
		openurl("WallnethubTestInsurance");
		// Enter the User name 	
		Thread.sleep(4000);
		
	}
	public void Mouseoveronrating() throws Exception
	{
		Moveon(getwebelement(xml.getlocator("//locators/insurancepage/CurrentRating")));
	}
	public void Mouseoveronfourthrating() throws Exception
	{
		Moveon(getwebelement(xml.getlocator("//locators/insurancepage/fourthrating")));
		
	}
	public void Assertfourthrating() throws Exception
	{
		
		//Thread.sleep(4000);
		int selectedstars=getwebelementscount(xml.getlocator("//locators/insurancepage/Allselected"));
		Assert.assertEquals(selectedstars+1, 4);
	}
	public void ClickonFourthRating() throws Exception
	{
		
		Clickon(getwebelement(xml.getlocator("//locators/insurancepage/fourthrating")));
	}
	public void OpenDropDown() throws Exception
	{
		
		Clickon(getwebelement(xml.getlocator("//locators/reiviewpage/DropDownlist")));
	}
	public void SelectHealthoption() throws Exception
	{
		
		Clickon(getwebelement(xml.getlocator("//locators/reiviewpage/HealthOption")));
		
	}
	public void SelectFourRating() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/reiviewpage/FourthStar")));
	}
	public void EnterTextData() throws Exception
	{
		SendKeys(getwebelement(xml.getlocator("//locators/reiviewpage/ReviewComment")),Getkeyvalue("Review_Comment"));
	}
	public void Submitreview() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/reiviewpage/SubmitReview")));
	}
	public void VerifyReviewSubmited() throws Exception
	{
		Assert.assertEquals(Gettext(getwebelement(xml.getlocator("//locators/reiviewpage/ConfirmationMessage"))).contains("Awesome!"),true);
	}
	public void GotoProfile() throws Exception
	{
		Moveon(getwebelement(xml.getlocator("//locators/profilepage/OpenProfileDropdown")));
		Clickon(getwebelement(xml.getlocator("//locators/profilepage/ProfileLink")));
	}
	public void GotoReviewSection() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/profilepage/ReviewTab")));
	}
	public void VerifySubmitedReview() throws Exception
	{
		Assert.assertEquals(Gettext(getwebelement(xml.getlocator("//locators/profilepage/ReviewComment"))),Getkeyvalue("Review_Comment"));
	}
}
