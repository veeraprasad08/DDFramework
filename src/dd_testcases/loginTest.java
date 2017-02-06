package dd_testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import dd_core.TestCore;

public class loginTest extends TestCore{
	
	
	@Test
	public void doLogin(){
		
		System.out.println("in the method");
		driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys("veeraprasad.t");
		driver.findElement(By.xpath(OR.getProperty("next"))).click();
		//driver.findElement(By.xpath(OR.getProperty("password")))config.
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("Sreenithya13");
		driver.findElement(By.xpath(OR.getProperty("signin"))).click();
		

}
}
