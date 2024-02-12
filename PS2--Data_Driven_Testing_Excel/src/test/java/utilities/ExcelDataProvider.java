package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Set up the WebDriver instance
		System.setProperty("webdriver.chrome.driver", "C:\\ZSelenium Jars and drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) {
		System.out.println(username+" | "+password);
		
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelPath = "E:\\eclipse workspace\\1)Selenium-S2\\PS2--Data_Driven_Testing_Excel\\excel\\Data.xlsx";		
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
		
	}
	
	public Object[][]testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				
				String cellData = excel.getCellDataString(i, j);
				System.out.println(cellData+" | ");
				data[i-1][j] = cellData;
				
			}
			System.out.println();
		}
		return data;
	}
}
