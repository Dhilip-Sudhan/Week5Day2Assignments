package AssignmentWeek5Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends MyBaseTest {
	
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws Exception{
		String sheetName="Duplicate Lead";
		Object data[][]=ReadExcelForDataProvider.readExcelData(sheetName);
		return data;
	}
	
	@Test(dataProvider="TestData")
	public void dupLead(String emailID) throws InterruptedException {
		
		// click Leads
		driver.findElement(By.linkText("Leads")).click();

		//Step 11: Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 12: Click on Email
		driver.findElement(By.linkText("Email")).click();
		
		//Step 13: Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys(emailID);
		
		//Step 14: Click find leads button
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 15: Capture name of First Resulting lead
		String namefirstlead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a[1]")).getText();
		System.out.println(namefirstlead);
		
		//Step 16: Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a[1]")).click();
		Thread.sleep(2000);
		String leadname = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(leadname);
		
		//Step 17: Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		Thread.sleep(2000);
		
		//Step 18: Verify the title as 'Duplicate Lead'
		String titleDup = driver.getTitle();
		if(titleDup.contains("Duplicate Lead")) {
			System.out.println("Duplicate Lead title is displayed");
		} else {
			System.err.println("Duplicate Lead title is not displayed");
		}

		//Step 19: Click Create Lead
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		Thread.sleep(5000);
		
		//Step 20: Confirm the duplicated lead name is same as captured name
		String dupnamelead = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(dupnamelead);
		Thread.sleep(2000);
		if(dupnamelead.equalsIgnoreCase(leadname)) {
			System.out.println("Lead Name and Duplicate Lead name should be matched");
		} else {
			System.err.println("Lead Name and Duplicate Lead name not matched");
		
		}
		
		//Step 21: Close the browser (Do not log out)
		driver.close();
	}

}
