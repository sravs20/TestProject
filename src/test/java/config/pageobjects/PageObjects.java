package config.pageobjects;

import config.BrowserConfig;
import org.openqa.selenium.By;


public class PageObjects extends BrowserConfig {

	//Home Page
	public By userNameTextBox = By.name("loginUsername");
	public By passwordTextBox = By.name("loginPassword");
	public By loginBtn = By.xpath("//button[contains(text(),'Login')]");
	public By loginSuccessMsg = By.xpath("//*[contains(@class,'logged-in__success')]");
	//"Successfully logged in!"




}
