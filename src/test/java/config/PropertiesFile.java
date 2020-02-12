package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.ExtentReportsTestNGDemo;

public class PropertiesFile {	

	static Properties prop = new Properties();

	static String PropFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties";



	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
	}

	public static void getProperties() {			
		try {
			InputStream InputProp = new FileInputStream(PropFilePath);
			prop.load(InputProp);				
			ExtentReportsTestNGDemo.BrowserName = prop.getProperty("browser");
			System.out.println("BrowserName is "+ ExtentReportsTestNGDemo.BrowserName);
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} 
	}

	public static void setProperties() {			
		try {			
			OutputStream OutputProp = new FileOutputStream(PropFilePath);		
			//prop.setProperty("browser", "firefox");		
			//prop.store(OutputProp, "updated the file On");		
			prop.setProperty("Result", "PASS");
			prop.store(OutputProp, "updated the file On");
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} 

	
	}



}
