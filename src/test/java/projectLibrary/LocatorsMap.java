package projectLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocatorsMap {
	
	public static final Logger logger = LogManager.getLogger(LocatorsMap.class);
	Properties property;
	
	public LocatorsMap (String filePath) {
		property = new Properties();
		
		try {
			FileInputStream file = new FileInputStream(filePath);
			property.load(file);
			file.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String filepath = "src/test/resources/locatorsMap.properties";
		LocatorsMap locators = new LocatorsMap(filepath);
		String locatorName = "locator name";
		String locatorElem = locators.property.getProperty(locatorName);
		System.out.println(locatorElem);
		
		String locatorType = locatorElem.split(":")[0];
		String locatorValue = locatorElem.split(":")[0];
	}

}
