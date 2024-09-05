package LendingPointTestAutomation.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserFactory {
	
	WebDriver driver = null;
	
	public WebDriver createBrowserInstance(String browserName, String browserType) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().browserInDocker().setup();
			if(browserType.equalsIgnoreCase("Headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920,1200");
				driver = new ChromeDriver(options);
				//driver.set(new ChromeDriver(options));
			} else {
				driver = new ChromeDriver();
				//driver.manage().window().maximize();
				//driver.set(new ChromeDriver());
				//driver.manage().window().maximize();
			}	
		}
		if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().browserInDocker().setup();
			if(browserType.equalsIgnoreCase("Headless")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920,1200");
				driver = new FirefoxDriver(options);
				//driver.set(new FirefoxDriver(options));
			}else {
				driver = new FirefoxDriver();
				//driver.manage().window().maximize();
				//driver.set(new FirefoxDriver());
				//driver.manage().window().maximize();
			}
			
		}
		if(browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().browserInDocker().setup();
			driver = new InternetExplorerDriver();
			//driver.manage().window().maximize();
			//driver.set(new InternetExplorerDriver());
			//driver.manage().window().maximize();
		}
		return driver;
	}

}
