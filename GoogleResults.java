package org.denis.wix.test.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleResults {

	@FindBy(css="div.g div.rc h3 > a")
	private List<WebElement> results;
	
	public GoogleResults(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickResult(int num) {
		if (results != null && results.size()>= num) {
			results.get(num).click();
		}
	}
	
	public List<WebElement> getResults(){
		return results;
	}
}
