package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

 
public class BasePage {

    
    protected WebDriver driver;

    //Constructor for BasePage
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Clicks on a given WebElement.
    public void click(WebElement element) {
        element.click();
    }

    //Types text into a given input field.
    protected void typeText(WebElement element, String text) {
        element.sendKeys(text);
    }
}
