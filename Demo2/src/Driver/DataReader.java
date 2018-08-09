package Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataReader {
	@DataProvider(name="SearchData")
	public static Object[][] datareader() throws IOException
	{
		
		 FileInputStream file = new FileInputStream(new File("C:\\Users\\ashwanis\\eclipse-workspace\\Demo\\src\\Data\\Data.xlsx"));
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 XSSFRow r=sheet.getRow(0);
		Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
		 for(int i=1;i<=sheet.getLastRowNum();i++)
		 { 
			 r=sheet.getRow(i);
			 //System.out.println(r.getLastCellNum());
		   for(int j=0;j<=r.getLastCellNum()-1;j++)
			 {
			    //System.out.println(r.getCell(j));
			    data[i-1][j] = r.getCell(j).toString();
			 }
		
		 }
		 System.out.println(data.toString());
		 workbook.close();
		 return data;
		 
	}
	@DataProvider(name="Logindata")
	public static Object[][] LogindataReader() throws IOException
	{
		
//		 FileInputStream file = new FileInputStream(new File("C:\\Users\\ashwanis\\eclipse-workspace\\Demo\\src\\Data\\Data.xlsx"));
//		 XSSFWorkbook workbook = new XSSFWorkbook(file);
//		 XSSFSheet sheet = workbook.getSheetAt(0);
//		 XSSFRow r=sheet.getRow(0);
//		Object[][] data= new Object[sheet.getLastRowNum()][r.getLastCellNum()];  
//		 for(int i=1;i<=sheet.getLastRowNum();i++)
//		 { 
//			 r=sheet.getRow(i);
//			 //System.out.println(r.getLastCellNum());
//		   for(int j=0;j<=r.getLastCellNum()-1;j++)
//			 {
//			    //System.out.println(r.getCell(j));
//			    data[i-1][j] = r.getCell(j).toString();
//			 }
//		
//		 }
//		 System.out.println(data.toString());
//		 workbook.close();
//		 return data;
		
		return new Object[][] { { "C4C", "Salesuser" }};
		 
	}
	
//	public static void main(String []args) throws Exception {
//		System.out.println(datareader());
//	}
//	
}


