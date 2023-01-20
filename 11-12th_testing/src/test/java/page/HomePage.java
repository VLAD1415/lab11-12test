package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://clans.by/";
    private final By BrandButtonLocator = By.xpath("/html/body/div[2]/div[1]/div[3]/a[4]");
    private final By tshirtButtonLocator = By.xpath("//*[text()='Men']");

    private final By searchButtonLocator = By.xpath("/html/body/header/div/div/div[3]/div[1]");
    private final By searchInputLocator = By.xpath("//input[@name='search']");

    private final By mailingButtonLocator = By.xpath("/html/body/footer/div/div[2]/div[3]/div/div/form/button");
    private final By mailingInputLocator = By.xpath("//input[@name='email']");


    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemsListPage openBrandPage(){
        WebElement BrandButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(BrandButtonLocator));
        BrandButton.click();
                logger.info("Open clothing page");
        return new ItemsListPage(driver);
    }

    public HomePage formailing(String query){

        WebElement mailingInput= new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(mailingInputLocator));
        mailingInput.sendKeys(query);
        WebElement mailingButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(mailingButtonLocator));
        mailingButton.click();
        logger.info("Search query");
        return this;
    }
    public ItemsListPage searchQuery(String query){
        WebElement searchButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
        WebElement searchInput= new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchInputLocator));
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);
        logger.info("Search query");
        return new ItemsListPage(driver);
    }
    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

}
