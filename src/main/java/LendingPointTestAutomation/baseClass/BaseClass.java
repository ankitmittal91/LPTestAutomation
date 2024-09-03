package LendingPointTestAutomation.baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

public static Properties prop;
//public static WebDriver driver;
public static HashMap<String, String> requestParam = new HashMap<String, String>();

private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//protected static ThreadLocal<ExtentReports> extent = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite (groups = {"Sanity","Smoke","APISmokeSuite"})
	public static void loadConfig() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		ExtentManager.setExtent();
		try {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configurationFile.properties");
		prop = new Properties();
		prop.load(file);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchBrowser(String url, String browserType) {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().browserInDocker().setup();
			if(browserType.equalsIgnoreCase("Headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920,1200");
				//driver = new ChromeDriver(options);
				driver.set(new ChromeDriver(options));
			} else {
				//driver = new ChromeDriver();
				//driver.manage().window().maximize();
				driver.set(new ChromeDriver());
				getDriver().manage().window().maximize();
			}	
		}
		if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().browserInDocker().setup();
			if(browserType.equalsIgnoreCase("Headless")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920,1200");
				//driver = new FirefoxDriver(options);
				driver.set(new FirefoxDriver(options));
			}else {
				//driver = new FirefoxDriver();
				//driver.manage().window().maximize();
				driver.set(new FirefoxDriver());
				getDriver().manage().window().maximize();
			}
			
		}
		if(browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().browserInDocker().setup();
			//driver = new InternetExplorerDriver();
			//driver.manage().window().maximize();
			driver.set(new InternetExplorerDriver());
			getDriver().manage().window().maximize();
		}
		System.out.print(getDriver() + " ............................");
		Action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(url);
		Action.pageLoadTimeOut(getDriver(), 30);
	}
	
	@AfterSuite (groups = {"Sanity","Smoke","APISmokeSuite"})
	public void afterSuite() {
		ExtentManager.endReport();	
	}
}