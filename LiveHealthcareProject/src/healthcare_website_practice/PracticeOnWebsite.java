package healthcare_website_practice;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeOnWebsite {
	
	private static final char LowerCase = 0;

	//@Test
	//public void ValidatePatientModul()
	
	

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		
		// Navigate to Application URL:
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		// Login:
		driver.findElement(By.name("username")).sendKeys("ria1");
		driver.findElement(By.name("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		
		
		
		
		
		// Verify "Patient Portal" text is displayed (Using ASSERT) (TestNG)
		  //String expected = "Patient Portal";	
		  //String actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();  // Add ACTUAL, EXPECTED & SoftAssert
		  //SoftAssert sa = new SoftAssert();   // SoftAssert didnt work on my end
		  //sa.assertEquals(actual, expected);
		
		
		
		
//		// Verify "Patient Portal" text is displayed (Using if & else) >> Code from myself not class
//		boolean b = driver.findElement(By.xpath("//h3[@class='panel-title']")).isDisplayed();
//		
//		if (b) {
//			
//			System.out.println("Patient Portal: " +"is displayed");
//			
//		}
//		
//		else {
//			
//			System.out.println("Patient Portal: " +"is NOT displayed");
//					
//		}
		
		
		
		// Profile Tab:
		  driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		
		
		 
//		// Verify "Personal Details" text is displayed
//		boolean bl = driver.findElement(By.xpath("//h3[@class='panel-title']")).isDisplayed();
//		
//		if (bl)  {
//			
//			System.out.print("Personal Details: " +"is displayed");
//			
//		}	
//			
//		else	{
//			
//			System.out.print("Personal Details: " +"is NOT displayed");
//		}
//			
		
		
		
		// Click on Edit button;
		driver.findElement(By.id("Ebtn")).click();
		
		
		
		String ExpectedFname =  GenerateRandomString();
		
		// Fillout EDIT Profile:
		driver.findElement(By.id("fname")).clear();		
		driver.findElement(By.id("fname")).sendKeys(ExpectedFname);
		driver.findElement(By.id("Sbtn")).click();
		
		// Accept alert notifications
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		// Get the ACTUAL value:
		String ActualFname = driver.findElement(By.id("fname")).getAttribute("value");
		
		// Validate the Actual = Expected 
		Assert.assertEquals(ExpectedFname, ActualFname);
		
		
		// Make it dynamic, we should add Random Logic function:
		
	    }
		public static String GenerateRandomString()		
		{
				Random Rand = new Random();
				int UpperCase = 65+Rand.nextInt(26);
				char UpperChar = (char) UpperCase;
				System.out.println(UpperChar);
				
				int LowerCase = 97+Rand.nextInt(26);
				char LowerChar = (char) LowerCase;
				System.out.println(LowerChar);
				
				String RandomString = "EditFunction"+UpperChar+LowerChar;
				System.out.println(RandomString);
		        return RandomString;
		}
		
		
			

	}


 