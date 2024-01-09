package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.CommonUtlis;

public class Driverfactory {
	   static WebDriver driver = null;
	  
	public static WebDriver initializeBrowser(String browserName) {
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			 driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("mozila")) {
			 driver= new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("headless")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			 driver = new ChromeDriver(options);
		}
		
		
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtlis.PAGE_LOAD_TIME));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtlis.IMPLICIT_WAIT_TIME));
		 
		 return driver;
		
		
		
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
}
