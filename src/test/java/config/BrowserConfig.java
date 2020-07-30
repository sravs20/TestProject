package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BrowserConfig {

	public static WebDriver driver = null;

	public static void initiateChromeBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.navigate().to("https://login.dev.qa-experience.com/");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	public static void closeDriver()
	{
		driver.close();
	}

}
