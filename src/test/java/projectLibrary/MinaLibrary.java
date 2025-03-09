package projectLibrary;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import testBase.TestPrep;

public class MinaLibrary extends TestPrep {

//	private WebDriver driver;
//	public CredentialsInfo creds;
	CredentialsInfo creds = new CredentialsInfo();

	// start any browser
	public WebDriver beginChrome() {
		try {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			delay(2);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	public WebDriver beginFirefox() {
		try {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			delay(2);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	public WebDriver beginEdge() {
		try {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			delay(2);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	public WebDriver beginSafari() {
		try {
			driver = new SafariDriver();
			driver.manage().window().maximize();
			delay(2);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	// close browser and kill object
	public void tearDown() {
		try {
			driver.close();
			driver.quit();
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	// method to go to website
	public void gotoWebsite(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	// method that gets website title
	public String getWebsiteTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}

		return title;

	}

	public void delay(double inSeconds) {
		try {
			long millisec = (long) (inSeconds * 1000);
			Thread.sleep(millisec);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	// a method that finds element
	public WebElement locateElement(String locatorName) {
		try {

		String filepath = "src/test/resources/locatorsMap.properties";
		LocatorsMap locators = new LocatorsMap(filepath);

		String locatorElem = locators.property.getProperty(locatorName);
		// System.out.println(locatorElem);

		String locatorType = locatorElem.split(":")[0];
		String locatorValue = locatorElem.split(":")[1];

		WebElement element;
		if (locatorType.toLowerCase().equals("id")) {
			element = driver.findElement(By.id(locatorValue));
			return element;
		} else if (locatorType.toLowerCase().equals("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
			return element;
		} else if (locatorType.toLowerCase().equals("name")) {
			element = driver.findElement(By.name(locatorValue));
			return element;
		} else if (locatorType.toLowerCase().equals("cssselector")) {
			element = driver.findElement(By.cssSelector(locatorValue));
			return element;
		} else if (locatorType.toLowerCase().equals("linktext")) {
			element = driver.findElement(By.linkText(locatorValue));
			return element;
		} else if (locatorType.toLowerCase().equals("partiallinktext")) {
			element = driver.findElement(By.partialLinkText(locatorValue));
			return element;
		} else if (locatorType.toLowerCase().equals("tagname")) {
			element = driver.findElement(By.tagName(locatorValue));
			return element;
		}
		return null;
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
			return null;
		}

	}
	
	// method to locate list of elements using findElements()
		public List<WebElement> locateElements(String locatorName){
			try {
				String filePath = "src/test/resources/locatorsMap.properties";
				LocatorsMap locators = new LocatorsMap(filePath);
				String locatorElem = locators.property.getProperty(locatorName);
				String locatorType = locatorElem.split(":")[0];
				String locatorValue = locatorElem.split(":")[1];
				
				switch(locatorType.toLowerCase()) {
				case "id":
					return driver.findElements(By.id(locatorValue));
				
				case "xpath":
					return driver.findElements(By.xpath(locatorValue));
					
				case "css":
					return driver.findElements(By.cssSelector(locatorValue));
					
				case "name":
					return driver.findElements(By.name(locatorValue));
					
				case "linkText":
					return driver.findElements(By.linkText(locatorValue));
					
				case "partialLinkText":
					return driver.findElements(By.partialLinkText(locatorValue));
					
				case "tageName":
					return driver.findElements(By.tagName(locatorValue));
					
				default:
					return new ArrayList<WebElement>();
				}
				
			}catch (Exception e) {
				logger.error("Error locating elements: ", e);
		        assertEquals(true, false, "Exception occurred while locating elements.");
		        return new ArrayList<>();
			}
		}

	// Method to get a property value from locators map.properties
	public void getkeyAndValue() {

		p = new Properties();
		String filepath = "src/test/resources/locatorsMap.properties";
		try (FileInputStream file = new FileInputStream(filepath)) {
			p.load(file);

		} catch (IOException e) {
			logger.error("Could not load properties from file: " + filepath, e);
		}

	}

	// click method using actions class
	public void clickElem(WebElement elem) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(elem).build().perform();
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	// a method that gets text
	public String getTextFromElement(WebElement element) {
		try {
//		 element = ml.locateElement();
		String text = element.getText();
		System.out.println(element.getText());
		return text;
	} catch (Exception e) {
		logger.error("Error: ", e);
		assertEquals(true, false);
	}
		return null; // return null to indicate no valid text was retrieved from webelement
	}

	// a method that selects from a drop down reading from properties file
	public void selectFromDropdownMenu(String dropdownlocator, String optionKey) {

		try {
			WebElement dropDownElement = ml.locateElement(dropdownlocator);

			String selectedOption = creds.getValue(optionKey);

			Select dropDown = new Select(dropDownElement);
			dropDown.selectByVisibleText(selectedOption);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}

	}

	// create a method to highlight element
	public void highligElement(WebElement element) {

		try {
			for (int i = 1; i < 4; i++) {
				WrapsDriver wrappedelement = (WrapsDriver) element;
				JavascriptExecutor js = (JavascriptExecutor) wrappedelement.getWrappedDriver();
				js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,
						"color: green; border: 3px solid red");
				delay(0.5);
				js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "");
				delay(0.5);
			}
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	// a method that scrolls to view element
	public void scrollToViewElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.scrollToElement(element);
			actions.build().perform();
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	// a method that waits for element visibility
	public WebElement waitForElementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			
			element = wait.until(ExpectedConditions.visibilityOf(element));
//			if (element == null) {
//				logger.info("Element not found on time");
//			}
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return element;
	}
	
	// a method that interacts with hidden element
	public void clickHiddenElement(WebElement element) {
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
}
	
	// a method that gets current time stamp
	public String getCurrentTime() {
		String finalTimeStamp = null;
		try {
			Date date = new Date();
			String tempTime = new Timestamp(date.getTime()).toString();
			finalTimeStamp = tempTime.replace('-', '_').replace(':', '_').replace('.', '_').replace(' ', '_')
					.replaceAll("_", "");
			// log.info("current time: " + tempTime);
			logger.info("timestamp: " + finalTimeStamp);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
		return finalTimeStamp;
	}
	
	// a method that captures screenshot
	public void captureScreenshot(String screenshotFileName, String filePath) {
	    try {
	        // Get the current timestamp
	        String timeStamp = getCurrentTime();
	        
	        // Default location if no path is provided
	        if (filePath.isEmpty()) {
	            filePath = "target/screenshots/";
	        }

	        // Create the directory if it doesn't exist
	        File directory = new File(filePath);
	        if (!directory.exists()) {
	            directory.mkdirs();
	        }

	        // Create the final screenshot path
	        String finalScreenshotPath = filePath + screenshotFileName + "_" + timeStamp + ".png";
	        
	        // Capture the screenshot
	        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        Files.copy(scrFile, new File(finalScreenshotPath));
	        
	        // Log the screenshot path
	        logger.info("Screenshot Location: " + new File(finalScreenshotPath).getAbsolutePath());

	    } catch (Exception e) {
	        logger.error("Error: ", e);
	        assertEquals(true, false);
	    }
	}

}
