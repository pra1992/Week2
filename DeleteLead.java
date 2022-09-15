package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
   WebDriverManager.chromedriver().setup();
   ChromeDriver driver= new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   driver.get("http://leaftaps.com/opentaps/control/main");
   driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
   driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
   driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
   driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
   driver.findElement(By.xpath("//a[text()='Leads']")).click();
   driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
   driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Accenture");
   driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Prasanth");
   driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("sankaran");
   driver.findElement(By.xpath("//input[@id='createLeadForm_primaryPhoneNumber']")).sendKeys("7502687078");
   driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
   driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
   driver.findElement(By.xpath("//span[text()='Phone']")).click();
   driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("7502687078");
   driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
   Thread.sleep(5000);
   String firstId=driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
   String footerMessage= driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor']/div")).getText();
   String[] subStringFooterMessage=footerMessage.split("\\ ");
   int rowsBeforeDeletion=-Integer.parseInt(subStringFooterMessage[6]);
   int noOfRowsBeforeDeletion=Math.abs(rowsBeforeDeletion);
   driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
   
   driver.findElement(By.xpath("//a[text()='Delete']")).click();
   
   driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
   driver.findElement(By.xpath("//span[text()='Phone']")).click();
   driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("7502687078");
   driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
   Thread.sleep(5000);

  // String noRecordsMessage= driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
   String footerMessageAfterDeletion= driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor']/div")).getText();
   String[] subStringFooterMessageAfterDeletion=footerMessageAfterDeletion.split("\\ ");
   int rowsAfterDeletion=-Integer.parseInt(subStringFooterMessageAfterDeletion[6]);
   int noOfRowsAfterDeletion= Math.abs(rowsAfterDeletion);
   if(footerMessageAfterDeletion.equals("No records to display")||noOfRowsAfterDeletion<noOfRowsBeforeDeletion)
	   System.out.println("Record Is Deleted");
   else
	   System.out.println("Record Is Not Deleted");
   
   
   driver.close();
   
   
   
   
	}

}
