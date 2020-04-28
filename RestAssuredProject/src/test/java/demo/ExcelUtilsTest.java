package demo;

public class ExcelUtilsTest {
	
	public static void main(String[] args) {
		String projpath = System.getProperty("user.dir");
		String excelpath = projpath+"./data/TestData.xlsx";
		String sheetpath = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelpath,sheetpath);
		excel.getRowCount();
		excel.getCellData(0,0);
		excel.getCellData(0,1);
		excel.getCellData(1,0);
		excel.getCellData(1,1);

	}

	

}
