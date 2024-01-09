package hooks;




import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import java.util.Properties;

import org.openqa.selenium.WebDriver;


import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import utils.ConfigReader;



public class MyHook {
	WebDriver driver;
	
	@Before
	public void setup() {
		//ConfigReader configreader = new ConfigReader();//
	 // Properties prop = configreader.initilazeproperties();
		 Driverfactory.initializeBrowser("headless");
		 driver = Driverfactory.getDriver();
		 driver.manage().deleteAllCookies();
		 driver.get("http://tutorialsninja.com/demo/");
	}
	
	@After
	public void teardown(Scenario scenario) {
	String scenarioName	=scenario.getName().replace(" ", "_");
	if(scenario.isFailed()) {
		   byte[] srcscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		   scenario.attach(srcscreenshot, "image/png", scenarioName);
		   
	}
		
		driver.close();
	}

}
