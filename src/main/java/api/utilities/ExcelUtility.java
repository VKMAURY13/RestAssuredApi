package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	String path;
	String sheetname;
	int rowcount;
	int cellno;
	FileInputStream fis;
	Workbook wb;
	Sheet sh;
	Row row;
	Cell cell;
	FileOutputStream fos;
	CellStyle style;
	

	public ExcelUtility(String path)
	{
		this.path = path;
	}
	
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
	{
		fis  = new FileInputStream(path);
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(sheetname);
		int rowcount = sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}
	
	public int getCellCount(String sheetname, int rowcount) throws EncryptedDocumentException, IOException
	{
		fis = new FileInputStream(path);
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(sheetname);
		row = sh.getRow(rowcount);
		int cellnum = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellnum;
		
	}
	
	public String getCellValue(String sheetname, int rownum, int colunnum) throws EncryptedDocumentException, IOException
	{
		
		fis = new FileInputStream(path);
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(sheetname);
		row = sh.getRow(rownum);
		cell = row.getCell(colunnum);
		
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(cell);
		
		wb.close();
		fis.close();
		
		return data;
		
	}
	
	public void setCellData(String sheetname, int rownum, int cellnum, String data) throws IOException {
		
		File file = new File(path);
		
		if(!file.exists())
		{
			// Create new file dynamically
		    wb = WorkbookFactory.create(true); // true = .xlsx, false = .xls
		    wb.createSheet("Data");
		}
		
		else
		{
			fis = new FileInputStream(path);
			wb = WorkbookFactory.create(fis);
		}
		
		if(wb.getSheetIndex(sheetname)==-1)
			wb.createSheet();
		sh = wb.getSheet(sheetname);
		
		if(sh.getRow(rownum)==null)
			sh.createRow(rownum);
		row = sh.getRow(rownum);
		
		cell = row.createCell(cellnum);
		cell.setCellValue(data);
		
		fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		
		
	}
	
	public void fillGreenColor(String sheetname, int rownum, int colonnum) throws EncryptedDocumentException, IOException
	{
		fis = new FileInputStream(path);
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(sheetname);
		row = sh.getRow(rownum);
		cell = row.getCell(colonnum);
		style = wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		wb.close();
		fis.close();
	}
	
	public void fillRedColor(String sheetname, int rownum, int colonnum) throws EncryptedDocumentException, IOException
	{
		fis = new FileInputStream(path);
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(sheetname);
		row = sh.getRow(rownum);
		cell = row.getCell(colonnum);
		style = wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		wb.close();
		fis.close();
		
	}
	
}
