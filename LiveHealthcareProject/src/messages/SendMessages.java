package messages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendMessages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String,String> patientMsgMap = new HashMap<String,String>();
		HashMap<String,String> adminMsgMap = new HashMap<String,String>();
		
        // URL
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		
		// LOGIN
		driver.findElement(By.name("username")).sendKeys("ria1");
		driver.findElement(By.name("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		
		// Profile Tab:
		  driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		
		// Get the ACTUAL value:
		String Fname = driver.findElement(By.id("fname")).getAttribute("value");	
		patientMsgMap.put("Fname",Fname);
		
		// Massage
		driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();
		
		patientMsgMap.put("subject", "Monthly Visit");
		
	    // Subject
		driver.findElement(By.id("subject")).sendKeys("Monthly Visit");
		
		patientMsgMap.put("message", "Need an appointment with a doctor");
		
		// Body Message
		driver.findElement(By.id("message")).sendKeys("Need an appointment with a doctor");
	
		
		patientMsgMap.put("date", getFutureDate(0, "dd-MM-YYYY"));
		
		// Send Button
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		
		String expected = "Message successfully sent";
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		alert.accept();
		
		Assert.assertEquals(actual, expected);
		
		
		System.out.printf("patient Msg Map" + patientMsgMap);
		
		
		
		
		
		
		
		//URL to ADMIN page
		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		
		// LOGIN
	    driver.findElement(By.name("username")).sendKeys("Ben@123");
	    driver.findElement(By.name("password")).sendKeys("Frank@123");
		driver.findElement(By.name("submit")).click();
				
		// Massage
		driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();
		
		
		
		
		
		
		
		
		
	}
		public static String getFutureDate(int NooFdays,String pattern)
	     
	     {
	    	 Calendar cal = Calendar.getInstance(); // (We are NOT able to create a an Object for the class like 
	                                                // "Calendar cal = new calendar" because the method is static, the Class is abstract)
	         cal.add(Calendar.DAY_OF_MONTH, NooFdays);

	         Date d = cal.getTime();
	         System.out.println("Current Date :" + d);

	         SimpleDateFormat sdf = new SimpleDateFormat();  // To Create a Date format
	         String defaultFormat = sdf.format(d);
	         System.out.println(defaultFormat);


	         sdf = new SimpleDateFormat("dd/MM/yyyy"); // diffrent Date format
	         String FormattedDate = sdf.format(d);
	         System.out.println(FormattedDate);
			 return FormattedDate;      
	     }
		
	}
