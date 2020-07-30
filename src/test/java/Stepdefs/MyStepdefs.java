package Stepdefs;

import config.BrowserConfig;
import config.UtilitiesBaseClass;
import config.pageobjects.PageObjects;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.Keys;

public class MyStepdefs{

	private final UtilitiesBaseClass utilitiesBaseClass = new UtilitiesBaseClass();

	private final PageObjects pageObjects = new PageObjects();

	@Given("I am on AUT login page")
	public void iAmOnAUTLoginPage() {
		BrowserConfig.initiateChromeBrowser();
	}

	@When("I enter {string} and {string}")
	public void iEnterAnd(String userName, String password) {

		try {
			if (utilitiesBaseClass.waitUntilObjExist(pageObjects.userNameTextBox,5000)){

				System.out.println("Login page displayed successfully");
				utilitiesBaseClass.enterText(pageObjects.userNameTextBox, userName);
				utilitiesBaseClass.enterText(pageObjects.passwordTextBox, password);
			}
			else {
				System.out.println("Login page is not displayed");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("I hit Login button")
	public void iHitLoginButton() throws InterruptedException {
		if(BrowserConfig.driver.findElement(pageObjects.loginBtn).isEnabled()){
			//used sendkeys with TAB and RETURN, since click is not working
			BrowserConfig.driver.findElement(pageObjects.passwordTextBox).sendKeys(Keys.TAB);
			BrowserConfig.driver.findElement(pageObjects.loginBtn).sendKeys(Keys.RETURN);
		}
		else
		{
			System.out.println("Login button not enabled.");
			//Truncate execution
			safeCloseDriver();
		}

	}

	@Then("I see successfully login to the application")
	public void iSeeSuccessfullyLoginToTheApplication() throws Exception {

		if (utilitiesBaseClass.waitUntilObjExist(pageObjects.loginSuccessMsg))
		{
			String actLoginMsg = BrowserConfig.driver.findElement(pageObjects.loginSuccessMsg).getText();
			String expLoginMsg = "Successfully logged in!";
			if (utilitiesBaseClass.checkStringEquals(actLoginMsg,expLoginMsg))
				System.out.println("Login successful");
			else
				System.out.println("Login failed");
		}
		else
		{
			System.out.println("Post Login page fail");
			//Truncate execution
			safeCloseDriver();
		}
	}

	@After
	 public void safeCloseDriver()
	{
		BrowserConfig.closeDriver();
	}
}
