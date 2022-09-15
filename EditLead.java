package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
  WebDriverManager.chromedriver().setup();
  
  ChromeDriver driver= new ChromeDriver();
  driver.get("http://leaftaps.com/opentaps/control/login");
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.xpath("//*[@id='username']")).sendKeys("DemoSalesManager");
	driver.findElement(By.xpath("//*[@id='password']")).sendKeys("crmsfa");
	driver.findElement(By.xpath("//*[@class='decorativeSubmit']")).click();
	driver.findElement(By.xpath("//*[contains(text(),'CRM/SFA')]")).click();
	driver.findElement(By.xpath("//a[text()='Leads']")).click();
	driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	Thread.sleep(5000);
	String FirstName=driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']/div)[1]")).getText();
	driver.findElement(By.xpath("//div[@class='x-tab-panel-bwrap']//input[@name='firstName']")).sendKeys(FirstName);
	driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
    String TitleOfPage=driver.getTitle();
    if(TitleOfPage.contains("View Lead"))
    	System.out.println("We have reached Edit Page and Condition is Pass");
    driver.findElement(By.xpath("//a[text()='Edit']")).click();
    driver.findElement(By.xpath("//div[@class='fieldgroup-body']//input[@name='companyName']")).clear();
    driver.findElement(By.xpath("//div[@class='fieldgroup-body']//input[@name='companyName']")).sendKeys("accenture");
    String CompanyName=driver.findElement(By.xpath("//div[@class='fieldgroup-body']//input[@name='companyName']")).getAttribute("value");
    driver.findElement(By.xpath("//input[@value='Update']")).click();
    String companyNameInDisplay=driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
    if(companyNameInDisplay.contains(CompanyName))
    	System.out.println("Edit Action Is Success");
    else
    	System.out.println("Edit Action Is Fail");
    driver.close();
    
	
	
	
	
	
	}

}
