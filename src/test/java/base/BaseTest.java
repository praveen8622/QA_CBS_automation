package base;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import helper.LoginHelper;
//import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	protected Properties prop;

	@BeforeMethod
	public void setUp() {
		prop = ConfigReader.getProperties();

		String browser = prop.getProperty("browser");
		String baseUrl = prop.getProperty("baseUrl");

		if (browser.equalsIgnoreCase("chrome")) {
//    	  ChromeOptions options = new ChromeOptions();
//
//    	    // Disable password manager & breach warnings
//    	    options.addArguments("--disable-notifications");
//    	    options.addArguments("--disable-infobars");
//
//    	    options.setExperimentalOption("prefs", Map.of(
//    	            "credentials_enable_service", false,
//    	            "profile.password_manager_enabled", false,
//    	            "profile.password_manager_leak_detection", false
//    	    ));
//          WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

//        WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser name: " + browser);

		}

		driver.manage().window().maximize();

		driver.get(baseUrl);
		LoginHelper.login(driver);

	}

	@AfterMethod
	public void tearDown() {
      if (driver != null) {
    	  
          driver.quit();
      }
	}

}
