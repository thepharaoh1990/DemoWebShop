package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import projectLibrary.CredentialsInfo;
import testBase.TestPrep;

public class HomePage extends TestPrep {

	public static final Logger logger = LogManager.getLogger(HomePage.class);
	private CredentialsInfo creds; // Declare CredentialsInfo variable

	public HomePage(WebDriver driver) {
		TestPrep.driver = driver;
		PageFactory.initElements(driver, this);
		creds = new CredentialsInfo();
	}

	public void homePageVisibility() {
		try {

		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void verifyTitle() {
		try {
			String actualTitle = ml.getWebsiteTitle();
			assertEquals(actualTitle, "Demo Web Shop", "Title Assertion Failed");

		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false, "Exception occured while getting title");
		}
	}

	public void navigateThroughHeaderLinks() {
		try {
			// Locate all header links once at the start
			List<WebElement> headerLinks = ml.locateElements("headerLinks");

			// Loop through each link
			for (int i = 0; i < headerLinks.size(); i++) {
				WebElement link = headerLinks.get(i);
				String linkText = link.getText();

				// Click the link if it's not empty, navigate back, and continue
				if (!linkText.isEmpty()) {
					logger.info("Link isn't empty, will click: " + linkText);
					link.click();
					ml.delay(2); // Optionally wait for page load

					// Navigate back to the main page
					driver.navigate().back();
					ml.delay(2); // Wait for the page to load again

					// Re-fetch the header links to avoid stale references after navigation
					headerLinks = ml.locateElements("headerLinks"); // Re-fetch after each back
				}
			}
		} catch (Exception e) {
			logger.error("Error While Navigating header links: ", e);
			assertEquals(true, false, "Exception occurred while navigating header links.");
		}
	}
	
	public void searchProduct() {
		try {
			
			 ml.locateElement("searchBar").sendKeys(creds.getValue("productName"));
			 ml.locateElement("searchClick").click();

		} catch (Exception e) {
			logger.error("Error: ", e);
			assertEquals(true, false);
		}
	}

}
