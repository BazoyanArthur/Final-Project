package pages.global;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.Page;
import pages.partiallyGlobal.QuickViewPage;
import utils.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends Page {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void setupElementLocators() {

    }

    public List<WebElement> getProductContainerList(){
        driver.findElement(By.id("list")).click();
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        List<WebElement> listElements = driver.findElements(By.xpath(".//ul[@class='product_list row list']/li"));
        List<WebElement> listContainers = new ArrayList<>();
        for(WebElement webElement : listElements){
            listContainers.add(webElement.findElement(By.xpath("./div[@class='product-container']")));
        }
        return listContainers;
    }

    public List<Product> getProductList(){
        List<WebElement> listElements = getProductContainerList();
        List<Product> products = new ArrayList<>();

        for(WebElement element : listElements){
            products.add(getProductInfo(element));
        }
        return products;
    }

    /**
     * Receives the @WebDriver and the @WebElement(Product Container) from which it has to
     * find the corresponding values from the webpage and fill in the fields
     * and then return an instance of a product.
     **/

    public Product getProductInfo(WebElement webElement){
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        WebElement row = webElement.findElement(By.xpath("./div[@class='row']"));
        String productName = webElement.findElement(By.xpath("./div[@class='row']//a[@class='product-name']")).getText();
        String productDescription = webElement.findElement(By.xpath("./div[@class='row']//p[@class='product-desc']")).getText();
        String inStock = webElement.findElement(By.xpath("./div[@class='row']//span[@class='available-now']")).getText();
        boolean isInStock = false;
        if(inStock.contains("In stock")){
            isInStock = true;
        }
        String price = webElement.findElement(By.xpath("./div[@class='row']//span[@itemprop='price']")).getAttribute("textContent");
        price = price.replace("\t", "");
        price = price.replace("\n", "");
        Double productPrice = Double.parseDouble(price.substring(1));

        return new Product(productName, productDescription, productPrice, isInStock);
    }

    public QuickViewPage clickQuickView(){
        //driver.findElement(By.id("list")).click();
        Actions builder = new Actions(driver);
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        builder.moveToElement(findElementBy(By.xpath("//img[@title='Printed Summer Dress']"))).perform();
        findElementBy(By.className("quick-view")).click();
        //new Actions(driver).moveToElement(driver.findElement(By.xpath("//img[@title='Printed Summer Dress']"))).perform();
        //driver.findElement(By.className("quick-view")).click();
        return new QuickViewPage(driver);
    }



}
