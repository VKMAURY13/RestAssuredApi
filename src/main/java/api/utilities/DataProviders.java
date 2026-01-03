package api.utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import api.path.IPathConstatnts;

public class DataProviders {
	
	@DataProvider(name="data")
	public String[][] getAllData() throws EncryptedDocumentException, IOException
	{
		String path = IPathConstatnts.EXCEL_PATH;
		ExcelUtility eu = new ExcelUtility(path);
		
		int rownum = eu.getRowCount("DDT");
		int cellnum = eu.getCellCount(path, 0);
		
		String [][] apidata = new String[rownum][cellnum];
		
		for(int i=1; i<rownum; i++)
		{
			for(int j=0; j<cellnum; j++)
			{
				apidata[i-1][j] = eu.getCellValue(path, i, j);
				
			}
		}
		
		return apidata;
	}
	
	@DataProvider(name = "Usernames")
	public String[] getUserNames() throws EncryptedDocumentException, IOException
	{
		String path = IPathConstatnts.EXCEL_PATH;
		ExcelUtility eu = new ExcelUtility(path);
		
		int rownum = eu.getRowCount("DDT");
		
		String[] apidata = new String[rownum];
		
		for(int i=1; i<rownum; i++)
		{
			apidata[i-1] = eu.getCellValue("DDT", i, 2);
		}
		return apidata;
	}
	
	
	@DataProvider(name = "UserId")
	public String[] getUserNamesByID() throws EncryptedDocumentException, IOException
	{
		String path = IPathConstatnts.EXCEL_PATH;
		ExcelUtility eu = new ExcelUtility(path);
		
		int rownum = eu.getRowCount("DDT");
		
		String[] apidata = new String[rownum];
		
		for(int i=1; i<rownum; i++)
		{
			apidata[i-1] = eu.getCellValue("DDT", i, 1);
		}
		return apidata;
	}
	

}
