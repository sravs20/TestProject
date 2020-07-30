package config;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import config.BrowserConfig;

import javax.sql.rowset.BaseRowSet;

public class UtilitiesBaseClass extends BrowserConfig{

//	protected static WebDriver driver;
//	BrowserConfig browserConfig = new BrowserConfig();

	public boolean waitUntilClickable(By locator, int timeoutSeconds) {
		boolean clickable = false;
		WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		clickable = true;
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return clickable;
	}
	public boolean waitUntilObjExist(By locator, int timeOut) throws Exception {

		boolean displayed = driver.findElement(locator).isDisplayed();

		boolean enabled = driver.findElement(locator).isEnabled();
		Integer dispWait = 0;
		Integer enabWait = 0;
		while (!displayed) {
			Thread.sleep(1000);
			displayed = driver.findElement(locator).isDisplayed();
			dispWait++;
			if (dispWait * 1000 > timeOut)
				throw new Exception("Waited too long for displayed " + timeOut);
			while (!enabled) {
				Thread.sleep(1000);
				enabled = driver.findElement(locator).isEnabled();
				enabWait++;
				if (enabWait * 1000 > timeOut)
					throw new Exception("Waited too long for enable " + timeOut);
				return false;
			}
		}
		return true;
	}
	public boolean waitUntilObjExist(By locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(BrowserConfig.driver, 15);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return true;
	}

		public boolean enterText(By locator, String value) throws InterruptedException {
		boolean result = false;
		int count = 0;
		int maxTries = 6;
		while (count < maxTries) {
			try {
				driver.findElement(locator).sendKeys(value);
				result = true;
				break;
			} catch (Exception e) {
				count++;
				Thread.sleep(5000);
			}
		}
		return result;
	}
	public boolean clickButton(By locator) throws InterruptedException {
		boolean result = false;
		int count = 0;
		int maxTries = 6;
		while (count < maxTries) {
			try {
				driver.findElement(locator);
				result = true;
				break;
			} catch (Exception e) {
				count++;
				Thread.sleep(5000);
			}
		}
		return result;
	}

	public boolean checkStringEquals(String actualText, String expectedText)
	{
		if (actualText.equals(expectedText))
			return true;
		else
			return false;
	}
}
