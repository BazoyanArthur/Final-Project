package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.Page;

import static utils.FieldNames.*;

public class HomePage extends Page {

    public HomePage(WebDriver driver){
        super(driver);
    }

    @Override
    protected void setupElementLocators() {
        elementLocators.put(LOGIN, By.className("login"));
        elementLocators.put(WOMEN, By.className("sf-with-ul"));
    }
}
