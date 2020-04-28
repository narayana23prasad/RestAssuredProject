package demo;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelpath,String sheetname) {
		try {
			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetname);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public static void main(String[] args) {
//		getRowCount();
//		getCellData();
//	}
	
	
	public static void getCellData(int rowNum,int colNum) {
		try {
//			String projpath = System.getProperty("user.dir");
//			String excelpath = projpath+"./data/TestData.xlsx";
			
			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			
			
			//String value = sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println(value);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getRowCount() {
		
		try {
//			String projpath = System.getProperty("user.dir");
//			String excelpath = projpath+"./data/TestData.xlsx";
//			workbook = new XSSFWorkbook(excelpath);
//			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows: "+ rowCount);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
