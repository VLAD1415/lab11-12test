package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemsListPage extends AbstractPage{
    private final By showResultOfSearch = By.xpath("/html/body/div[3]/div[2]/div[1]/div/a");
    private final By carharttButtonLocator = By.xpath("/html/body/div[3]/div/div[3]/div[2]/div[3]/a");

    private final By setHighPriceLocator = By.xpath("/html/body/div[3]/div[2]/div/div[3]/div/div[3]/label");

    private final By selectFirstLocator = By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div[1]/form/div[1]/a/img");


    protected ItemsListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public ItemsListPage showResultOfSearch(){
        WebElement resulfOsSearch = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(showResultOfSearch));
        resulfOsSearch.click();
        logger.info("get result of search");
        return this;
    }

    public ItemsListPage setPriceFilter(){
        WebElement lowerPriceButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(setHighPriceLocator));
        lowerPriceButton.click();
        logger.info("Filter price");
        return this;
    }



    public ItemsListPage selectCarhartt(){
        WebElement selected = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(carharttButtonLocator));
        selected.click();
        logger.info("select carhartt");
        return this;
    }

    public ItemPage selectFirstItem(){
        WebElement selected = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectFirstLocator));
        selected.click();
        logger.info("select First");
        return new ItemPage(driver);
    }

}
