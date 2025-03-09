package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.TestPrep;

public class TC002 extends TestPrep{
	
	public static final Logger logger = LogManager.getLogger(TC002.class);
	@Test
	public void tc002() {
		HomePage hp = new HomePage(driver);
		hp.navigateThroughHeaderLinks();
	}

}
