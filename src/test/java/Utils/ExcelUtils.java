package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook Workbook= null;
	static XSSFSheet sheet= null;

	
	//profielpath+"/Excel/testdata1.xlsx"
	
	
	public ExcelUtils(String excelPath, String Sheetname) {	
		try {
		
			Workbook = new XSSFWorkbook(excelPath);
			sheet = Workbook.getSheet(Sheetname);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}


	public  static void main(String[] args) {
		getRowCount();
		getColumnCount();
		getCellDataString(0,0);
		getCellDataNumber(1,1);
	}

	/*
	 * public void ExcelUtils() { 
	 * getRowCount(); 
	 * getColCount(); 
	 * getCellDataString();
	 * getCellDataNumeric();
	 * 
	 * 
	 * }
	 */

	public static int getRowCount() {
		int rowCount = 0;
		try {
			
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Excel Row Count is :  "+ rowCount);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return rowCount;
	}

	public static int getColumnCount() {
		int colCount = 0;
		try {			
			 colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Excel Column Count is :  "+ colCount);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return colCount;
	}
	
	public static String getCellDataString(int rowNum, int colNum) {
		String CellData = null;
		try {		
			 CellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println("Cell data is  :  "+ CellData);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		return CellData;
	}
	
	public  static Object getCellDataNumber(int rowNum, int colNum) {
		Object CellData = null;

		try {
			
			 CellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println("Cell data is :  "+ CellData);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		return CellData;
	}




}
