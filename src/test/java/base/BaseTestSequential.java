package base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import helper.LoginHelper;
import utilities.ConfigReader;

public class BaseTestSequential {
    protected WebDriver driver;
    protected Properties prop;

    @BeforeClass
    public void setUp() {
        prop = ConfigReader.getProperties();

        String browser = prop.getProperty("browser");
        String baseUrl = prop.getProperty("baseUrl");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(baseUrl);
        LoginHelper.login(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
