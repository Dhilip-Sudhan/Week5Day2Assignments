package AssignmentWeek5Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends MyBaseTest {
	
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws Exception{
		String sheetName="Edit Lead";
		Object data[][]=ReadExcelForDataProvider.readExcelData(sheetName);
		return data;
	}

	@Test(dataProvider="TestData")
	public void editLead(String firstName,String companyName) throws InterruptedException {
		
		// click Leads
		driver.findElement(By.linkText("Leads")).click();

		//Step 11: Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 12: Enter first name
		driver.findElement(By.xpath("//span[text()='Name and ID']//following::input[2]")).sendKeys(firstName);
		
		//Step 13: Click Find leads button
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 14: Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a")).click();
		
		//Step 15: Verify title of the page
		String titleDup = driver.getTitle();
		if(titleDup.contains("View Lead")) {
			System.out.println("View Lead title is displayed");
		} else {
			System.err.println("View Lead title is not displayed");
		}

		//Step 16: Click Edit
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(2000);
		
		//Step 17: Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);
		String updatedcompanyExp = driver.findElement(By.id("updateLeadForm_companyName")).getText();
		System.out.println(updatedcompanyExp);
		
		//Step 18: Click Update
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		Thread.sleep(2000);
		
		//Step 19:Confirm the changed name appears
		/*String updatedcompanyAct = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(updatedcompanyAct);
		if(updatedcompanyExp.contains(updatedcompanyAct)) {
			System.out.println("Changed name should be matched");
		} else {
			System.err.println("Changed name not matched");
		
		}*/
		
		//Step 20: Close the browser (Do not log out)
		driver.close();
	}

}
