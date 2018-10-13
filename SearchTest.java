package org.denis.wix.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.denis.wix.test.pageobject.GooglePageObject;
import org.denis.wix.test.pageobject.GoogleResults;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchTest {

	public static WebDriver driver;

	@Test
	public void searchWix() throws InterruptedException {
		driver.get("https://www.google.com/");
		GooglePageObject googlePageObject = new GooglePageObject(driver);
        googlePageObject.enterSearchTerm("wix");
        googlePageObject.search();
        GoogleResults googleResults = new GoogleResults(driver);
        assertNotNull(googleResults.getResults());
        assertTrue(googleResults.getResults().size() > 0);
        googleResults.clickResult(0);
        Thread.sleep(3000);
	}

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\denis\\Downloads\\geckodriver.exe\");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Before
	public void maximizeBrowser() {
		driver.manage().window().fullscreen();
	}

	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
}
