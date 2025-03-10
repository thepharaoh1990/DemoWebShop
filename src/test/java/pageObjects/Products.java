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

public class Products  extends TestPrep{
	public static final Logger logger = LogManager.getLogger(Products.class);
	
	public Products(WebDriver driver) {
		Products.driver = driver;
		PageFactory.initElements(driver,this);
		creds = new CredentialsInfo();
	}
	
	
	public void navigateBooks() {
		try {
			ml.locateElement("books").click();
			ml.delay(5);
			ml.waitForElementVisibility(ml.locateElement("sortBy")).click();
			ml.waitForElementVisibility(ml.locateElement("priceLowToHigh")).click();
			
//			// Locate all books found
//			List<WebElement> books = ml.locateElements("books");
//			
//			// Loop through each link
//			for (int i =0; i<books.size(); i++) {
//				WebElement book = books.get(i);
//			String bookPrice = book.getText();
//				logger.info("Book details " + book);
//				}
//		
			
		}catch (Exception e) {
			logger.error("Error: ", e );
			assertEquals(true, false);
		}
	}

}
