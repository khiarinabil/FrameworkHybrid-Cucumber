package utils;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;



public class ConfigReader {
	public  Properties initilazeproperties() {
		
		Properties prop = new Properties();
		File filpro = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		try {
	FileInputStream fis = new FileInputStream(filpro);
	prop.load(fis);
		}catch(Throwable e) {e.printStackTrace();}
		
		
		
		return prop;
	}

}
