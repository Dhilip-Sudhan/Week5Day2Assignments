package AssignmentWeek5Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends MyBaseTest {
	
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws Exception{
		String sheetName="Delete Lead";
		Object data[][]=ReadExcelForDataProvider.readExcelData(sheetName);
		return data;
	}

	@Test(dataProvider="TestData")
	public void deleteLead(String phNumber) throws InterruptedException {
		
		// click Leads
		driver.findElement(By.linkText("Leads")).click();
		
		//Step 11: Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 12: Click on Phone
		driver.findElement(By.linkText("Phone")).click();
		
		//Step 13: Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys(phNumber);
		
		//Step 14: Click find leads button
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 15: Capture lead ID of First Resulting lead
		String FirstResLead = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).getText();
		System.out.println(FirstResLead);
		
		//Step 16: Click First Resulting lead
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		Thread.sleep(2000);
		
		//Step 17: Click Delete
		driver.findElement(By.linkText("Delete")).click();
		
		//Step 18: Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 20: Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(FirstResLead);
		
		//Step21: Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		
		//Step 22:Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String NoRectext = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println(NoRectext);
		if(NoRectext.equalsIgnoreCase("No records to display")) {
			System.out.println("Created Lead should be deleted");
		} else {
			System.err.println("Created Lead is not deleted");
		}
		
		//Step 23: Close the browser (Do not log out)
		driver.close();
		
	
		

	}

}
