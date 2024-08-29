package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path = ".\\testData\\Opencart_LoginData.xlsx";	//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path); 	//creating an object for XLUtility
		
		int totalrow=xlutil.getRowCount("sheet1");
		int totalcell=xlutil.getCellCount("sheet1",1);
		
		String logindata[][]=new String[totalrow][totalcell];	//created for two dimension array which can storage data
		
		for(int i=1;i<=totalrow;i++)	//1	//read the data from xl stroring in two dimensional array
		{
			for(int j=0;j<totalcell;j++)	//0	//i is row & j is col
			{
				logindata[i-1][j]=xlutil.getCellData("sheet1", i, j);	//1,0
			}
		}
		return logindata;	//returning two dimensional array
	}
	
}
