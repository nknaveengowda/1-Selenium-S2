package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	//defining these in class level
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	//Constructor name same as class name. Can replace projectPath+ "/excel/Data.xlsx"=excelpath. and "Sheet1" with sheetName
	public ExcelUtils(String excelpath, String sheetName) {
		try {
			
			workbook = new XSSFWorkbook(excelpath);//Create reference for workbook 
			sheet = workbook.getSheet(sheetName);//Create reference of worksheet
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//getRowCount();
		//getCellDataString(0,0);
		//getCellDataNumber(1,1);
	}

	public static int getRowCount() {
		int rowCount=0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();//call rowCount function
			System.out.println("No of rows : "+rowCount);

		}catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;

	}
	
	public static int getColCount() {
		int colCount=0;
		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();//call ColCount function
			System.out.println("No of Cols : "+colCount);

		}catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;

	}

	public static String getCellDataString(int rowNum, int colNum) {
		String cellData=null;
		try {

			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();//Call function to get Cell String data
			System.out.println(cellData);

		}catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}

	public static void getCellDataNumber(int rowNum, int colNum) {
		try {

			Double cellData = sheet.getRow(rowNum).getCell(rowNum).getNumericCellValue();//call fuction to get cell numeric data
			System.out.println(cellData);

		}catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
