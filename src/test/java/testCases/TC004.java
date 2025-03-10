package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Products;
import testBase.TestPrep;

public class TC004 extends TestPrep{
	
	public static final Logger logger = LogManager.getLogger(TC004.class);
	@Test
	public void tc004() {
		HomePage hp = new HomePage(driver);
		Products p = new Products(driver);
		
		hp.verifyTitle();
		p.navigateBooks();
	}

}
