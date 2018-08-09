package Testscript;
import org.testng.Assert;
import org.testng.annotations.Test;

import Driver.DriverTestcase;
import Driver.DataReader;

public class Livelisting extends DriverTestcase {
	
	
@Test
	public void VerifyliveListing() throws Exception
	{

	InventorylivelistingHelper.VerifyLivetitle("2019 ABC OTHER");

	}
@Test
public void SearchforVehicle() throws Exception
{

InventorylivelistingHelper.Searchandverify("2019 ABC OTHER");

}

}
