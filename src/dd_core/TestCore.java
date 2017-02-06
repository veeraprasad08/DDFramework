//The purpose of this program is to load web driver, excel, properties and log files
package dd_core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import dd_util.ExcelReader;


public class TestCore{
	
	public static WebDriver driver = null;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\dd_properties\\testdata.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	
	
	@BeforeSuite
	public static void setup() throws IOException{
		
		if(driver==null){
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\OR.properties");
			OR.load(fis);
			log.debug("OR properties file loaded");
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Config.properties");
			config.load(fis);
			log.debug("Config properties file loaded");
			
		//	driver = new FirefoxDriver();
			
			if(config.getProperty("browser").equals("firefox")){
				
				driver = new FirefoxDriver();
				System.out.println("beforeloading url");
				
			} else if(config.getProperty("browser").equals("chrome")){
				
				
				System.setProperty("webdriver.chrome.driver", "user.dir");
				driver = new ChromeDriver();
				System.out.println("beforeloading url");
								
			} else if(config.getProperty("browser").equals("ie")){
				
				System.getProperty("webdriver.ie.driver", "user.dir");
				driver = new InternetExplorerDriver();
				System.out.println("beforeloading url");
			}
				
				
			driver.get(config.getProperty("testsiturl"));
			System.out.println("after loading url");
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			System.out.println("after timeout");
			
							
		}
		
						
	}
		
		//@AfterSuite
		@AfterSuite
	    public static void teardown(){
		   
		   driver.quit();
	   }	
	
}