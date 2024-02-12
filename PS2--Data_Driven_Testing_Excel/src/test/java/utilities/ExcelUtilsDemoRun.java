package utilities;

public class ExcelUtilsDemoRun {

	public static void main(String[] args) {
		// Create new class to call excel function
		String projectPath = System.getProperty("user.dir");//help to work on other machines
		ExcelUtils excel = new ExcelUtils(projectPath+"/excel/Data.xlsx", "Sheet1"); 
	    
		excel.getRowCount();
		excel.getCellDataString(0,0);
		excel.getCellDataNumber(1,1);
	
	}

}
