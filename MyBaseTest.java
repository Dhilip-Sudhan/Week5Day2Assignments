package AssignmentWeek5Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;


public class MyBaseTest {
	
		public ChromeDriver driver;
		
		// Browser Launch and Login
		@BeforeMethod
		
		public void setup() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/main");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			String text = driver.findElement(By.tagName("h2")).getText();
			System.out.println(text);
			driver.findElement(By.linkText("CRM/SFA")).click();
			Thread.sleep(3000);
		}
		
		// Logout and Close the application
		@AfterMethod
		public void teardown() {
			driver.close();
		}

}
