package Testscript;
import org.testng.annotations.Test;
import Driver.DriverTestcase;
import Reporter.ExtentTestManager;


public class Assignment extends DriverTestcase {	
	
@Test
	public void LoginonFaceBook() throws Exception
	{
		ExtentTestManager.getTest().setDescription("Login on FaceBook");
		Login.Login("Facebook");
		Login.VerifySuccessLogin("Facebook");
	}
@Test
public void PostStatusonFacebook() throws Exception
{
	ExtentTestManager.getTest().setDescription("Post Hello World Status on Facebook");
	AssignmentmentHelper.GotoHomepage();
	AssignmentmentHelper.Poststatus();
	AssignmentmentHelper.VerifyStatus();
}

@Test
	public void LoginonWallnethub() throws Exception
	{
		ExtentTestManager.getTest().setDescription("Login in to Wallnethub");
		Login.Login("Wallnethub");
		Login.VerifySuccessLogin("Wallnethub");
	}

@Test
	public void WriteReviewonWallnethub() throws Exception
	{
		ExtentTestManager.getTest().setDescription("Write a review on wallnethub for the Test insurance Componey");
		AssignmentmentHelper.OpenInsurancepage();
		AssignmentmentHelper.Mouseoveronrating();
		AssignmentmentHelper.Mouseoveronfourthrating();
		AssignmentmentHelper.Assertfourthrating();
		AssignmentmentHelper.ClickonFourthRating();
		AssignmentmentHelper.OpenDropDown();
		AssignmentmentHelper.SelectHealthoption();
		AssignmentmentHelper.SelectFourRating();
		AssignmentmentHelper.EnterTextData();
		AssignmentmentHelper.Submitreview();
		AssignmentmentHelper.VerifyReviewSubmited();
	}

@Test
	public void VerifySubmittedReview() throws Exception
	{
		ExtentTestManager.getTest().setDescription("Verify the Submitted Review in The User profile");
		AssignmentmentHelper.GotoProfile();
		AssignmentmentHelper.GotoReviewSection();
		AssignmentmentHelper.VerifySubmitedReview();
		
	}
}
