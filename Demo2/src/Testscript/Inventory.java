package Testscript;
import org.testng.annotations.Test;

import Driver.DriverTestcase;
import Driver.DataReader;

public class Inventory extends DriverTestcase {
	
	
@Test
	public void NavigatetoInventory() throws Exception
	{

	InventoryHelper.GotoInventory();
	InventoryHelper.VerifytheInventoryPage();

	}
@Test()
public void AddInvetory() throws Exception
{

InventoryHelper.EnterInventory("Class 1 (GVW 0 - 6000)", "Bus","2019","ABC","OTHER","Crew Cab","3000");
InventoryHelper.AddInventry();
InventoryHelper.AddDescription("Description for Automation");
InventoryHelper.SaveInventory();
InventoryHelper.PublishListing();

}



}
