package testframe.common.webdrivermanager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

import testframe.common.utilities.PropertyReader;

public class BrowserFactory {
	
	private WebDriver driver;
	private static final String CHROME_DRIVE_PROPERTY = "webdriver.chrome.driver";
	
	public WebDriver getDriver(String browserToUse) throws IOException{
		
		switch(browserToUse){
		
		case "chrome":
			System.setProperty(CHROME_DRIVE_PROPERTY, "lib/chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			String downloadFolderPath = System.getProperty("user.dir")+File.separator+"testreport"+File.separator+"downloads";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			//chromePrefs.put("profile.default_content_settings.popups", 1);
			chromePrefs.put("download.default_directory", downloadFolderPath);
			chromePrefs.put("safebrowsing.enabled", "true"); 
			option.addArguments("--start-maximized");
			option.addArguments("--ignore-ssl-errors=yes");
			option.addArguments("--ignore-certificate-errors");
			option.setExperimentalOption("prefs", chromePrefs);
			option.addArguments("disable-popup-blocking");
			option.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			option.setCapability(CapabilityType.VERSION, "ANY");
			option.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			option.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
			option.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, false);
			option.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		

			driver = new ChromeDriver(option);
			break;
		}
		
		driver.manage().window().maximize();
		String implicitWait =new PropertyReader().getParamfromConfigProperties("implicitlyWaitInSecond");
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(implicitWait), TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	

}
