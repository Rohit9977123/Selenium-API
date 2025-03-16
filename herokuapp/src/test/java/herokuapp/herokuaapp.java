package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class herokuaapp {
	WebDriver driver;
	@BeforeMethod

	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		
	}
	@Test
	public void upload()
	{
		driver.findElement(By.xpath("//*[@id=\'file-upload\']")).sendKeys("C:\\Users\\Lenovo\\Downloads\\Final_Nandaji_Ese.pdf");
		driver.findElement(By.id("file-submit")).click();
		
		String text=driver.getTitle();
		if(Text.contains("Final_Nandaji_Ese.pdf"))
		{
			System.out.println("my file is uploaded");
		}
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
