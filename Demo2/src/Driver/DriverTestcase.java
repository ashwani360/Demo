package Driver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.LogStatus;

import Reporter.ExtentManager;
import Reporter.ExtentTestManager;
import ScriptHelper.InventoryHelper;
import ScriptHelper.InventoryListingHelper;
import ScriptHelper.LiveListingHelper;
import ScriptHelper.LoginHelper;
import junit.framework.Assert;

public class DriverTestcase {
	
	public static WebDriver dr;
	
	public static LoginHelper Login;
	public static InventoryHelper InventoryHelper;
	public static InventoryListingHelper InventorylistingHelper;
	public static LiveListingHelper InventorylivelistingHelper;
	@BeforeTest
	public void setup() throws IOException
	{
		// Open Browser
		
		PropertyReader pr=new PropertyReader();
		String targatedbrowser=pr.readproperty("browser");
		String url=pr.readproperty("URL");
		System.out.println("URL");
		if(targatedbrowser.equals("chrome"))
		{ DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ashwanis\\eclipse-workspace\\Demo\\lib\\chromedriver.exe");
			dr= new ChromeDriver(capabilities);
		}
		else if (targatedbrowser.equals("ie"))
		{
			System.out.println("For IE inprogress");
		}
		
		else
		{
			System.out.println("For FF inprogress");
		}
		
		
		// Open URL
		dr.manage().window().maximize();
		dr.get(url);
		
		Login=new LoginHelper(getwebdriver());
		InventoryHelper=new InventoryHelper(getwebdriver());
		 InventorylistingHelper=new InventoryListingHelper(getwebdriver());
		 InventorylivelistingHelper=new LiveListingHelper(getwebdriver());
	}

	
	@AfterTest
	public void Teardown()
	{
		dr.close();
	}
	public WebDriver getwebdriver() {
		return dr;
	}
}
