package Excel_Java;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Excel_File {
 public WebDriver driver;
 @BeforeClass
 public void startup() {
	 System.setProperty("webdriver.gecko.driver", "E:\\Driver\\geckodriver.exe");
		driver=new FirefoxDriver();
 }
 @AfterClass
  public void teardown() {
	 driver.quit();
 }
 @Test
  public void login() throws Exception{
	 // Reading user name and password from the Excel and assigning to variables
	 // in jxl we have concept of only Column and row
	 FileInputStream FileInput=new FileInputStream("E:\\Excel_File\\Excel1.xlsx");
	 XSSFWorkbook workbook=new XSSFWorkbook(FileInput);
	 XSSFSheet Sheet=workbook.getSheet("test");
	 XSSFCell cell=Sheet.getRow(1).getCell(1);
	 System.out.println(Sheet.getRow(1).getCell(1));
	 String un=cell.getStringCellValue();
	 String pw=cell.getStringCellValue();
	 //Typing Username and password from the Excel file
	 driver.navigate().to("http://183.82.125.5/nareshit/login.php");
	 driver.findElement(By.name("txtUserName")).sendKeys(un);
	 Reporter.log("Entering User name");
	 driver.findElement(By.name("txtPassword")).sendKeys(pw);
	 Reporter.log("Entering the Password");
	 driver.findElement(By.name("Submit")).click();
	 Thread.sleep(3000);
	 System.out.println("Login Completed");
	 Reporter.log("Login Completed");
	 driver.findElement(By.linkText("Logout")).click();
	 Reporter.log("Logout Completed");
 }
}
