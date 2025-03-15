package herokuapp;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandle {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#Open%20New%20Tab");
		driver.manage().window().maximize();
	}
	@Test
	public void Open_New_Window()
	{
		//driver.findElement(By.id("Open New Window")).click();
		
        WebElement elementalSeleniumLink = driver.findElement(By.id("Open New Window"));
        elementalSeleniumLink.click();

        // Get the current window handle
        String mainWindowHandle = driver.getWindowHandle();

        // Switch to the new tab
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        
        
        driver.switchTo().window(mainWindowHandle);
	}
	
	@AfterMethod
	public void Teadown()
	{
		driver.close();
	}

}
