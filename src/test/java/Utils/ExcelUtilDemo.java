package Utils;

public class ExcelUtilDemo {
	
	static String profielpath = System.getProperty("user.dir");
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		ExcelUtils excel = new ExcelUtils(profielpath+"/Excel/testdata1.xlsx", "Sheet1");
		excel.getRowCount();
		excel.getColumnCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1,1);
	}

}
