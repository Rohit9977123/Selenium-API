package herokuapp;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {

	 public static void main(String[] args) {

	      
		 WebDriver driver = new ChromeDriver();
	    
	           
	            driver.get("https://demo.automationtesting.in/Frames.html");
	            driver.manage().window().maximize();

	          
	            driver.switchTo().frame("singleframe"); // Switch to single frame
	            WebElement inputF = driver.findElement(By.xpath("//input[@type='text']"));
	            inputF.sendKeys("Testing Single Frame");
	            
	            
	            takeScreenshot(driver, "single_frame.png");

	         
	            driver.switchTo().defaultContent();

	           
	            WebElement nestedFTab = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
	            nestedFTab.click();

	           
	            WebElement outerFrame = driver.findElement(By.xpath("//div[@id='Multiple']//iframe"));
	            driver.switchTo().frame(outerFrame);

	           
	            WebElement innerFrame = driver.findElement(By.xpath("//iframe"));
	            driver.switchTo().frame(innerFrame);

	         
	            WebElement nestedIField = driver.findElement(By.xpath("//input[@type='text']"));
	            nestedIField.sendKeys("Testing Nested Frame");

	         
	            takeScreenshot(driver, "nested_frame.png");

	            
	            driver.switchTo().parentFrame();
	            driver.switchTo().defaultContent();

	       
	           
	            driver.quit();
	        }
	    

	    // Method to take screenshots
	    public static void takeScreenshot(WebDriver driver, String fileName) {
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(srcFile, new File(fileName));
	            System.out.println("Screenshot saved: " + fileName);
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	        }
	    }

}