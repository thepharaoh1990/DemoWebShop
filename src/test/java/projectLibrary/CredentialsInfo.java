package projectLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CredentialsInfo {
	public static final Logger logger = LogManager.getLogger(CredentialsInfo.class);
	
	Properties property;
	String filepath = "src/test/resources/credentials.properties";
	
	
	public CredentialsInfo () {
		property = new Properties();
		
		
		try {
			FileInputStream file = new FileInputStream(filepath);
			property.load(file);
			file.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		String filepath = "src/test/resources/credentials.properties";
//		CredentialsInfo creds = new CredentialsInfo(filepath);
//		String keyName = "key Name";
//		String keyValue = creds.property.getProperty(keyName);
//		System.out.println(keyName);
//		
//		String locatorType = locatorElem.split(":")[0];
//		String locatorValue = locatorElem.split(":")[0];
	// Method to get the value by key from the properties file
//    
	 // Method to get the value by key from the properties file
    public String getValue(String key) {
        String value = property.getProperty(key);
        if (value != null) {
            logger.info("Retrieved value for key '" + key + "': " + value.split(":")[1]);
            return value.split(":")[1].trim(); // Trimming to remove any extra space
        } else {
            logger.error("Key not found: " + key);
            return null; //  if key is not found
        }
    }
		
	
	
	

}
