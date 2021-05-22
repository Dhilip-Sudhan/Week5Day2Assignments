package AssignmentWeek5Day2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Week5Day1.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends MyBaseTest {
	
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws Exception{
		String sheetName="Create Lead";
		Object data[][]=ReadExcelForDataProvider.readExcelData(sheetName);
		return data;
	}
	
	@Test(dataProvider="TestData")
	public void createLead(String companyName,String firstName, String lastName) throws InterruptedException {
		
		// click Leads
		driver.findElement(By.linkText("Leads")).click();
		
		// click Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Step 11: Enter the Company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		String CompanyName = driver.findElement(By.id("createLeadForm_companyName")).getText();
		
			
		//Step 12: Enter the First Name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
			
		//Step 13: Enter the Last Name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
			
		//Step 14: a) Find the Element
		WebElement eleSourceDropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		//Step 14: b) Convert the WebElement as Select
		Select dp1 = new Select(eleSourceDropdown);
		
		//Step 14: c) Choose the option by getvisibletext
		dp1.selectByVisibleText("Employee");
		
		//Step 15 : a) Marketing campaign
		WebElement eleMarketCamp = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		
		//Step 15: b) Convert the WebElement as Select
		Select dpMarkcamp = new Select(eleMarketCamp);
		
		//Step 15: c) Choose the option by getvisibletext
		dpMarkcamp.selectByVisibleText("Automobile");
		
		//Step 16 : First Name (Local)
		driver.findElement(By.name("firstNameLocal")).sendKeys("Dhilip Sudhan");
		
		//Step 17 : Last Name (Local)
		driver.findElement(By.name("lastNameLocal")).sendKeys("Muralidharan");
		
		//Step 18 : Salutation
		driver.findElement(By.name("personalTitle")).sendKeys("QA");
		
		//Step 19 : Birth Date
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("04/25/21");
		
		//Step 20 : Title
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Automation Engineer");
		
		//Step 21 : Department
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Quality");
		
		//Step 22 : Annual Revenue
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("1000000");
		
		//Step 23 : a) Preferred Currency
		WebElement elePrefCurr = driver.findElement(By.id("createLeadForm_currencyUomId"));
		
		//Step 23: b) Convert the WebElement as Select
		Select dpPrefCurr = new Select(elePrefCurr);
		
		//Step 23: c) Choose the option by getvisibletext
		dpPrefCurr.selectByVisibleText("INR - Indian Rupee");
		
		//Step 24 : a) Industry
		WebElement eleIndustry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		
		//Step 24: b) Convert the WebElement as Select
		Select dpIndustry = new Select(eleIndustry);
		
		//Step 24: c) Choose the option by getvisibletext
		dpIndustry.selectByVisibleText("Distribution");
		
		//Step 25 : Number of employees
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("777");
		
		//Step 26 : a) Ownership
		WebElement eleOwner = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		
		//Step 26: b) Convert the WebElement as Select
		Select dpOwner = new Select(eleOwner);
		
		//Step 26: c) Choose the option by getvisibletext
		dpOwner.selectByVisibleText("Partnership");
		
		//Step 27: SIC code
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("4567");
		
		//Step 28: Ticker Symbol
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("blue");
		
		//Step 29: Description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Automation code");
		
		//Step 30: Important Note
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("My first Automation code");
		
		//Step 31: Country Code
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("007");

		//Step 32: Area Code
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("0422");
		
		//Step 33: Phone number
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("451046");
		
		//Step 34: Extension
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("422");
		
		//Step 35: Person to Ask for
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Muralidharan");
		
		//Step 36: Email Address
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@gmail.com");
		
		//Step 37: Web URL
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://www.google.com");
		
		//Step 38: To Name
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Sruthi");
		
		//Step 39: Attention Name
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Vijayalakshmi");
		
		//Step 40: a) Country
		WebElement eleCountry = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		
		//Step 40: b) Convert the WebElement as Select
		Select dpCountry = new Select(eleCountry);
		
		//Step 40: c) Choose the option by getvisibletext
		dpCountry.selectByVisibleText("India");
		
		Thread.sleep(2000);
		
		//Step 41: a) State/Province
		WebElement eleStateProv = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		//Step 41: b) Convert the WebElement as Select
		Select dpStateProv = new Select(eleStateProv);
		
		//Step 41: c) Choose the option by getvisibletext
		dpStateProv.selectByVisibleText("TAMILNADU");
		
		//Step 42: Address Line 1
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Rajendran Nagar");
		
		//Step 43: Address Line 2
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Narasimanaickenpalayam");
		
		//Step 44: City
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Coimbatore");
		
		//Step 45: Zip/postal Code
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("641031");
		
		//Step 46: Zip/Postal code Extension
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("641031");
		
		//Step 47: Click Create Lead
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(5000);
		
		//Step 52: Get the Company name and verify it
		String eleCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(eleCompanyName);
		
		String eleCompName = eleCompanyName.replaceAll("[^a-zA-Z]", " ");
		System.out.println(eleCompName);
		
		//if(eleDupName.contains(eleDuplicateName)) {
		//if(eleDuplicateName.contains(eleDupName)) {
		if(eleCompName.contains(CompanyName)) {
			System.out.println("Company name should be displayed");
		} else {
			System.err.println("Company name should be displayed");
		}
		
			
	}
	
	
}

	/*
	@DataProvider(name="TestData")
	public Object[][] fetchdata() {
		String[][] data = new String [2][3];
		
		data[0][0] = "Zoho";
		data[0][1] = "Sruthi Dhilip";
		data[0][2] = "Dhilip Sruthi";
		
		data[1][0] = "Google";
		data[1][1] = "Viji Murali";
		data[1][2] = "Murali Viji";
		
		return data;
	}*/

