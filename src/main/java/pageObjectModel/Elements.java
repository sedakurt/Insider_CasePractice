package pageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
public class Elements {
    public static WebDriver driver;

    public Elements(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public WebElement clickMore() {
        Actions a = new Actions(driver);
        WebElement moreMenu = driver.findElement(By.xpath("//span[contains(text(), 'More')]"));
        a.moveToElement(moreMenu).build().perform();
        return moreMenu;
    }

    public WebElement selectCareers() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        Actions element = new Actions(driver);
        WebElement selectCareers = driver.findElement(By.xpath("//h5[contains(text(), 'Careers')]"));
        element.moveToElement(selectCareers).build().perform();
        return selectCareers;
    }

    public WebElement getLocationError() {
        return driver.findElement(By.xpath("//h3[contains(text(),'Our Locations')]"));
    }

    public WebElement getLifeError() {
        return driver.findElement(By.xpath("//h2[contains(text(),'Life at Insider')]"));
    }

    public WebElement getTeamsError() {
        return driver.findElement(By.xpath("//h3[contains(text(),'Find your calling')]"));
    }

    public WebElement clickSeeAllTeams() throws InterruptedException {
        Actions element = new Actions(driver);
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,2500)", "");
        Thread.sleep(2000);
        WebElement selectSeeAllTeams = driver.findElement(By.xpath("//div/a[contains(text(), 'See all teams')]"));
        element.moveToElement(selectSeeAllTeams).build().perform();
        return selectSeeAllTeams;
    }

    public WebElement selectQA() throws InterruptedException {
        Actions element = new Actions(driver);
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,1600)", "");
        Thread.sleep(2000);
        WebElement selectQA = driver.findElement(By.xpath("//h3[contains(text(),'Quality Assurance')]"));
        element.moveToElement(selectQA).build().perform();
        return selectQA;
    }

    public WebElement selectAllQAJobs() {
        return driver.findElement(By.xpath("//a[contains(text(),'See all QA jobs')]"));
    }

    public WebElement selectLocation() throws InterruptedException {
        Actions element = new Actions(driver);
        Thread.sleep(1000);
        WebElement countryDropdown = driver.findElement(By.xpath("//*[@id='filter-by-location']"));
        Select country = new Select(countryDropdown);
        country.selectByVisibleText("Istanbul, Turkey");
        element.moveToElement(countryDropdown).click().build().perform();
        return countryDropdown;
    }

    public WebElement selectPosition() throws InterruptedException {
        Actions element = new Actions(driver);
        Thread.sleep(1000);
        WebElement countryDropdown = driver.findElement(By.cssSelector("#filter-by-department"));
        Select country = new Select(countryDropdown);
        country.selectByVisibleText("Quality Assurance");
        element.moveToElement(countryDropdown).click().build().perform();
        return countryDropdown;
    }

    public WebElement checkJobList() {
        return driver.findElement(By.xpath("//*[@id='jobs-list']/div[@class='position-list-item col-12 col-lg-4 qualityassurance istanbul-turkey full-timeremote']"));
    }

    public WebElement applyButton() throws InterruptedException {
        Actions builder = new Actions(driver);
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(2000);
        WebElement locator = driver.findElement(By.xpath("//*[@id='jobs-list']/div[3]/div/a"));
        builder.moveToElement(locator).build().perform();
        return locator;
    }
}
