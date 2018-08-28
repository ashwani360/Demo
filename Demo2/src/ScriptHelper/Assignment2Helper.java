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
		openurl("WallnethubTestInsurance");
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Insurance Page has been opened");	  
	}
	
	public void Mouseoveronrating() throws Exception
	{
		Moveon(getwebelement(xml.getlocator("//locators/insurancepage/CurrentRating")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Mouse over on the Rating Section in Right of page");
	}
	
	public void Mouseoveronfourthrating() throws Exception
	{
		Moveon(getwebelement(xml.getlocator("//locators/insurancepage/fourthrating")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Mouse over on the Fourth start to submit the rating four");
	}
	
	public void Assertfourthrating() throws Exception
	{
		//Thread.sleep(4000);
		int selectedstars=getwebelementscount(xml.getlocator("//locators/insurancepage/Allselected"));
		Assert.assertEquals(selectedstars+1, 4);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Verify that Fourth Start is hilighted");
	}
	
	public void ClickonFourthRating() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/insurancepage/fourthrating")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the 4th Rating");
	}
	
	public void OpenDropDown() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/reiviewpage/DropDownlist")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Open the DropDwon to select the Service");
	}
	
	public void SelectHealthoption() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/reiviewpage/HealthOption")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Health Services");
	}
	
	public void SelectFourRating() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/reiviewpage/FourthStar")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the 4 rating");
	}
	
	public void EnterTextData() throws Exception
	{
		SendKeys(getwebelement(xml.getlocator("//locators/reiviewpage/ReviewComment")),Getkeyvalue("Review_Comment"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter the Review comment with more than 200 words");
	}
	
	public void Submitreview() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/reiviewpage/SubmitReview")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on the Submit button to submite the review");
	}
	
	public void VerifyReviewSubmited() throws Exception
	{
		Assert.assertEquals(Gettext(getwebelement(xml.getlocator("//locators/reiviewpage/ConfirmationMessage"))).contains("Awesome!"),true);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Verify that the Confirmation message is getting displayed");
	}
	
	public void GotoProfile() throws Exception
	{
		Moveon(getwebelement(xml.getlocator("//locators/profilepage/OpenProfileDropdown")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Open the Profile list");
		
		Clickon(getwebelement(xml.getlocator("//locators/profilepage/ProfileLink")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Select the Profile option");
	}
	
	public void GotoReviewSection() throws Exception
	{
		Clickon(getwebelement(xml.getlocator("//locators/profilepage/ReviewTab")));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Go to the Review Tab");
	}
	
	public void VerifySubmitedReview() throws Exception
	{
		Assert.assertEquals(Gettext(getwebelement(xml.getlocator("//locators/profilepage/ReviewComment"))),Getkeyvalue("Review_Comment"));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Verify that the Submited review is is displaying with the same comments");
	}
}
