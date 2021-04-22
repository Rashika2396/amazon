package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cases {

	
	public static WebDriver driver;
	public static void capturescreen() throws IOException {
		Date d = new Date();
		String fileName = (d.toString().replace(":","_").replace(" ","_") + ".jpg");
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshot,new File("C:\\Users\\pc\\eclipse-workspace\\testing\\src\\Screenshot\\error.jpg"));
	}
		
	
	public String baseurl ="https://www.amazon.in/";
	@ BeforeTest 
	public void baseurl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	@Test
	public void login() {
		
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		WebDriverWait wait =new WebDriverWait(driver,05);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ap_email")));
				driver.findElement(By.id("ap_email")).sendKeys("rashika23dec@gmail.com");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				driver.findElement(By.id("ap_password")).sendKeys("9898052214");
				driver.findElement(By.id("signInSubmit")).click();
	}
	@Test
	public void search() {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("grocery");
	 driver.findElement(By.xpath("//input[@value='Go']")).click();
	}
	@Test
	public  void sort () {
driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
Select sortdrop = new Select(driver.findElement(By.id("s-result-sort-select")));

List allOptions = sortdrop.getOptions();
  
System.out.println(allOptions.size());
 sortdrop.selectByIndex(2);

}
	@Test
public void brand() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 List<WebElement> check = driver.findElements(By.className("a-list-item"));
		 System.out.println(check.size());
	}		 
	@AfterTest
	public void accountandlist() throws IOException  {
		
		WebDriverWait wait3 = new  WebDriverWait(driver, 10);
		WebElement element1 = wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-link-accountList")));
		Actions action = new Actions(driver);
	
		driver.findElement(By.id("nav_prefetch_yourorders")).click();
		capturescreen();
			
	}


	    
	     
	      
	     
	
	      
		
	}


