package Driver;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class xmlreader {
	String fileloaction;
	public xmlreader(String filepath)
	{
		fileloaction=filepath;
	}
	
public String getlocator(String nodepath) throws DocumentException
{
	String locator=null;
	File Inputfile=new File(fileloaction);
	SAXReader xmlreader=new SAXReader();
	Document doc=xmlreader.read(Inputfile);
	locator=doc.selectSingleNode(nodepath).getText();
	//System.out.println(locator);
	return locator;
	
}

//public static void main(String args[]) throws Exception
//{
//	getlocator("C:\\Users\\ashwanis\\eclipse-workspace\\Demo\\src\\Locators\\locators.xml","//locators/home/Inputtextfield");
//	getlocator("C:\\Users\\ashwanis\\eclipse-workspace\\Demo\\src\\Locators\\locators.xml","//locators/home/okbutton");
//	getlocator("C:\\Users\\ashwanis\\eclipse-workspace\\Demo\\src\\Locators\\locators.xml","//locators/searchresult/firstlink");
//	
//}

}
