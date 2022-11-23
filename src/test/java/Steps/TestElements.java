import Model.Elements;
import com.google.auto.common.AnnotationMirrors;
import dataProvider.ConfigFileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.fail;

public class TestElements {
    public static WebDriver driver;
    ConfigFileReader configFileReader;
    HomePage homePage;
    public static Elements elementPage; //Mode
    // limizin bulunduğu paket dosyası
    String baseURL = configFileReader.getApplicationUrl();
    String driverPath= configFileReader.getDriverPath();


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
            driver = new ChromeDriver();
        driver.manage().window().maximize();
            String baseUrl = ConfigFileReader.getApplicationUrl();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    configFileReader= new ConfigFileReader();

        homePage.navigateTo_HomePage();	}

    @Test
    public void testMorePage() throws Exception {

            //System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
            driver.get(baseURL);
//Sayfaların beklenmesi için süre aşağıdaki gibi tanınır
            driver.manage().timeouts().pageLoadTimeout(200, SECONDS);
        elementPage.clickMore().click();
        }



        @After
    public void tearDown() throws Exception {
        driver.quit();
            AnnotationMirrors verificationErrors = null;
            String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}