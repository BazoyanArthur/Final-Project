package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.global.SearchResultPage;
import utils.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.FieldNames.SEARCH;

public abstract class Page {
    protected Map<String, By> elementLocators = new HashMap<>();

    protected final WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
        setupElementLocators();
    }

    abstract protected void setupElementLocators();

    public WebElement findElementBy( By by ){
        if(by == null){
            throw new IllegalArgumentException("'By' cannot be null!");
        }
        return driver.findElement(by);
    }

    public SearchResultPage searchItem(String itemToSearch){
        WebElement searchBar = findElementBy(By.id("search_query_top"));
        searchBar.sendKeys(itemToSearch + Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public List<Product> findItem(String itemName){
        SearchResultPage searchResult = searchItem(itemName);
        return searchResult.getProductList();
    }
}
