package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import projectLibrary.CredentialsInfo;
import projectLibrary.MinaLibrary;

public class TestPrep {
	public static final Logger logger = LogManager.getLogger(TestPrep.class);

	public static WebDriver driver;
	public static MinaLibrary ml;
	public CredentialsInfo creds;

	public Properties p;
	private String configFileLocation = "src/test/resources/config.properties";
	private String browserType;
	private String siteURL;

	@BeforeMethod
	public void beforeTest() {
		logger.info("Before Test Starts");
		if (browserType.toLowerCase().contains("chrome")) {
			driver = ml.beginChrome();
			ml.gotoWebsite(siteURL);

		} else if (browserType.toLowerCase().contains("firefox")) {
			driver = ml.beginFirefox();

		} else if (browserType.toLowerCase().contains("edge")) {
			driver = ml.beginEdge();

		} else if (browserType.toLowerCase().contains("safari")) {
			driver = ml.beginSafari();
		} else {
			logger.info("The Deault browse is Chrome");
			driver = ml.beginChrome();
		}
	}

	@AfterMethod
	public void afterEachTest(ITestResult result) {
		logger.info("After each test...");
		// check if test is failed
		if (ITestResult.FAILURE == result.getStatus()) {
			// test failed, call capture screenshot method
			ml.captureScreenshot(result.getName(), "");
		}
		ml.tearDown();
	}

	@BeforeClass(groups = {"smoke","regression"})
	public void setup() {
		logger.info("Loading confiugration File and setting up the test");
		ml = new MinaLibrary();
		

		// load the config file
		// Load properties from config file
		p = new Properties();
		try (FileInputStream file = new FileInputStream(configFileLocation)) {
			p.load(file);
			browserType = p.getProperty("browserType", "chrome"); // Default to Chrome if not specified
			siteURL = p.getProperty("siteURL", "https://automationexercise.com/");
			logger.info("Browser type from config: " + browserType);
		} catch (IOException e) {
			logger.error("Could not load config file", e);
			browserType = "chrome"; // Fallback to Chrome if loading fails
		}
	}

	// this method will run only time after all tests
	@AfterClass(groups = {"smoke","regression"})
	public void afterClass() {
		logger.info("After class...");
	}
}