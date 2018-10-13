package org.denis.wix.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePageObject {

	@FindBy(id="lst-ib")
	private WebElement searchBox;
	
	private WebDriver driver;
	
	public GooglePageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void enterSearchTerm(String txt) {
		searchBox.sendKeys(txt);
	}
	
	public void search() {
		searchBox.submit();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.g div.rc h3 > a")));
	}
}
