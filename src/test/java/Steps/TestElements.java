package Steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import pageObjectModel.Elements;
import dataProvider.ConfigFileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Log4j;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestElements {
    public WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();
    String baseURL = ConfigFileReader.getApplicationUrl();
    String targetURL = ConfigFileReader.getDriverTargetPath();
    String driverPath= ConfigFileReader.getDriverPath();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), SECONDS);
        driver.get(baseURL);
        String urlEquals = "https://useinsider.com/";
        assertEquals(baseURL, urlEquals);}

    @Test
    public void testMorePage() throws InterruptedException {
        Log4j.startLog("Test is Starting...");
        driver.manage().timeouts().pageLoadTimeout(200, SECONDS);
        Log4j.startLog("Page is opened, "+baseURL);
        Elements elementPage = new Elements(driver);
        Log4j.info("Closing Cookies pop-up menu: 'Apply Necessary' option is selected.");
        driver.findElement(By.xpath("//a[contains(text(), 'Only Necessary')]")).click();

        elementPage.clickMore().click(); Log4j.info("Selected “More” menu in navigation bar.");
        elementPage.selectCareers().click();  Log4j.info("Selected “Careers”.");

        String isVisibleLocation = elementPage.getLocationError().getText();
        Assert.assertTrue(isVisibleLocation.contains("Location"));
        Log4j.info("Location block opened.");

        String isVisibleLife = elementPage.getLifeError().getText();
        Assert.assertTrue(isVisibleLife.contains("Life"));
        Log4j.info("Life block opened.");

        String isVisibleTeams = elementPage.getTeamsError().getText();
        Assert.assertTrue(isVisibleTeams.contains("calling"));
        Log4j.info("Teams block opened.");

        elementPage.clickSeeAllTeams().click(); Log4j.info("Clicked 'See All Teams'.");
        elementPage.selectQA().click(); Log4j.info("Clicked 'Quality Assurance'.");
        elementPage.selectAllQAJobs().click(); Log4j.info("Clicked 'See all QA jobs'.");
        elementPage.selectLocation().isSelected(); Log4j.info("Selected Location: Istanbul, Turkey.");
        elementPage.selectPosition().isSelected(); Log4j.info("Selected Department: Quality Assurance.");

        Assert.assertTrue(elementPage.checkJobList().isDisplayed());Log4j.info("Jobs are listed.");

        elementPage.applyButton().click(); Log4j.info(" Clicked “Apply Now” button.");

        driver.get(targetURL);
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), SECONDS);
        Log4j.info("Opened the target URL.");

        }

        @After
    public void tearDown(){
        Log4j.endLog("Test is Ending...");
        driver.quit();

    }
}
