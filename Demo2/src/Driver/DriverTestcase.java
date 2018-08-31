package Driver;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		{ 
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			Map<String, Object> prefs = new HashMap<String, Object>();
			 // Set the notification setting it will override the default setting
			prefs.put("profile.default_content_setting_values.notifications", 2);

            // Create object of ChromeOption class
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
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
		
		dr.manage().window().maximize();
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
