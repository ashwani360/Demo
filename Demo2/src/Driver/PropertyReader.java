package Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	public String readproperty(String key) throws IOException
	{ String St=null;
	
	Properties pr= new Properties();
	InputStream file= new FileInputStream("C:\\Users\\ashwanis\\eclipse-workspace\\Demo2\\src\\Config\\config.properties");
	pr.load(file);
	St=pr.getProperty(key);
	return St;
		
	}
	
//	public static void main(String args[]) throws IOException {
//		System.out.println(readproperty("browser"));
//		System.out.println(readproperty("url"));
//		
//	}
}
