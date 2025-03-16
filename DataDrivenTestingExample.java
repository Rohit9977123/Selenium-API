package DataDrivenTesingDemo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTestingExample {


	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");

		// Step 1 :  read an external file using FileInputStream class
		
		FileInputStream file=new FileInputStream("C:\\Users\\Lenovo\\Documents\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\ApachePOIDataDriven\\src\\main\\resources\\DataDriven.xlsx");

      //// Step 2 : Use APachePOi libraries to connect with excel - WorkcookFactory.
		Workbook book=WorkbookFactory.create(file);
	// fetch values from excel from and entering into webelements
		String username=book.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String Password=book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		
		
		driver.findElement(By.id("username")).sendKeys(username);
		
		driver.findElement(By.id("password")).sendKeys(Password);
		
		driver.findElement(By.id("submit")).click();
		book.close();
		
		String Text=driver.findElement(By.cssSelector("[class=\'post-title\']")).getText();
		if(Text.contains("Logged In Successfully"))
		{
			System.out.println("Congratulations student. You successfully logged in!");
			
		}
		else
		{
			System.out.println("Sorry  student. You  are successfully logged in!");
		}
	}
	

}
