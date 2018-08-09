package Testscript;
import org.testng.annotations.Test;

import Driver.DriverTestcase;
import Driver.DataReader;

public class InventoryListing extends DriverTestcase {
	
	
@Test
	public void VerifyListing() throws Exception
	{

	InventorylistingHelper.VerifyListing("2019 ABC OTHER12");

	}
@Test
public void ViewLive() throws Exception
{

InventorylistingHelper.ViewLive();

}

}
