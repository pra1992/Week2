package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  WebDriverManager.chromedriver().setup();
  ChromeDriver driver= new ChromeDriver();
  driver.get("https://en-gb.facebook.com/");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 //driver.findElement(By.ByXPath("//a[text()='Create New Account']")).click();
  driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
  driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("AAAA");
  driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("BBBB");
  driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("prasanthsnkr@gmail.com");
  driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("traj1992");
  WebElement dd1=driver.findElement(By.xpath("//select[@id='day']"));
  Select drop1= new Select(dd1);
  drop1.selectByValue("21");
  WebElement dd2= driver.findElement(By.xpath("//select[@id='month']"));
  Select drop2= new Select(dd2);
  drop2.selectByValue("11");
  WebElement dd3= driver.findElement(By.xpath("//select[@id='year']"));
  Select drop3= new Select(dd3);
  drop3.selectByValue("1992");
  driver.findElement(By.xpath("//span[@data-name='gender_wrapper']//label[text()='Female']/following-sibling::input")).click();
  System.out.println("Assignment is done");
  driver.close();
  
  
	}

}
