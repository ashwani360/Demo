package Driver;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ScriptHelper.Assignment2Helper;
import ScriptHelper.LoginHelper;

public class DriverTestcase {
	
	public static WebDriver dr;
	
	public static LoginHelper Login;
	
	public static Assignment2Helper AssignmentmentHelper;
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
		//dr.get(url);
		
		Login=new LoginHelper(getwebdriver());
		
		 AssignmentmentHelper=new Assignment2Helper(getwebdriver());
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
