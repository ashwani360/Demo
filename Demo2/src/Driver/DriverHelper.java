package Driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class DriverHelper {
	
	WebDriver driver;
	Wait<WebDriver> wait;
	WebElement el;
	public DriverHelper(WebDriver dr)
	{
		driver=dr;
		wait = new FluentWait<WebDriver>(dr)       
				.withTimeout(60, TimeUnit.SECONDS)    
				.pollingEvery(5, TimeUnit.SECONDS)    
				.ignoring(NoSuchElementException.class); 
	}
	 
	public WebElement getwebelement(final String locator) throws InterruptedException
	{   //System.out.println("Indriverhelper"+driver);
	 //WebElement el;
	final String[] finalval;
		if(locator.startsWith("name"))
		{
			finalval=locator.split("=");
			//System.out.println(finalval[1]);
			//System.out.println("Indriverhelper"+driver);
			//wait.until();  
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
					el=driver.findElement(By.name(finalval[1]));
					return driver.findElement(By.name(finalval[1]));     
				 }  
				});  
		}
		else if(locator.startsWith("id"))
		{
			finalval=locator.split("=");
			//System.out.println(finalval[1]);
			//System.out.println("Indriverhelper"+driver);
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
					el=driver.findElement(By.id(finalval[1]));
					return driver.findElement(By.id(finalval[1]));     
				 }  
				});
			 //el= driver.findElement(By.id(finalval[1]));
		}
		else if (locator.startsWith("//"))
		{
			wait.until(new Function<WebDriver, WebElement>() {       
				public WebElement apply(WebDriver driver) { 
					el=driver.findElement(By.xpath(locator)); 
					return driver.findElement(By.xpath(locator));     
				 }  
				});
			
		}
		Thread.sleep(1000);
		return el;
	}
	
	public void openurl(String environment) throws Exception {
		String URL=null;
		PropertyReader pr=new PropertyReader();
		URL=pr.readproperty(environment+"URL");
		driver.get(URL);
		
	}
	public void Clickon(WebElement el) {
		
		el.click();
	}
public void Select(WebElement el, String index) {
		
		Select sl=new Select(el);
		sl.selectByVisibleText(index);
	}
	public void SendKeys(WebElement el,String value) {
		el.sendKeys(value);
	}
	public void Switchtoliveandverify(String locator,String expected) throws Exception
	{
		System.out.println("Switching Frame");
		System.out.println(driver.getWindowHandles());
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window((String) tabs.get(1));
		
		
		//Assert.assertEquals(getwebelement(locator).getText().toString(), expected);

//		driver.switchTo().defaultContent();
	}
	public void AddTextintoeditor(String value) throws Exception {
		Thread.sleep(3000);
		Actions act1=new Actions(driver);
		WebElement el=driver.findElement(By.xpath("//*[@id='addModify']/div[3]/div[3]/div[13]/div/div[1]/input"));
		el.click();
		for(int i=0;i<1;i++)
		{
			act1.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(1000);
			System.out.println(i+"th TAB ENTERED");
		}
		Thread.sleep(2000);
		act1.sendKeys("Data description").build().perform();
		Thread.sleep(2000);

	}
	public void SendinputKeys(WebElement el,Keys key) {
		el.sendKeys(key);
	}
	public void SendKeyboardKeys(WebElement el,Keys key) {
		el.sendKeys(key);
	}
	public String GetText(WebElement el) {
		String actual=el.getText().toLowerCase().toString();
		return actual;
	}
	public String Getkeyvalue(String Key) throws IOException
			{ PropertyReader pr=new PropertyReader();
		      String Keyvalue;
			 Keyvalue=pr.readproperty(Key);
		
			return Keyvalue;
			}
	public void VerifyTextpresent(String text) throws IOException
	{ 
		System.out.println(text);
		Assert.assertFalse(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
	}
	public String Gettext(WebElement el) throws IOException
	{ 
		String text=el.getText().toString();
		return text;
	}
	
}
