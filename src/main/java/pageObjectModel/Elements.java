package Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {
    public static WebDriver driver;

    public Elements(WebDriver webDriver) {
        driver = webDriver;

    }

    public WebElement clickMore() {
        return driver.findElement(By.xpath("//*[@id=\"mega-menu-1\"]/span"));
    }

    public WebElement selectCareers() {
        return driver.findElement(By.cssSelector("#navbarNavDropdown > ul.navbar-nav.overflow-y > li.nav-item.dropdown.mega-menu.layout2.menu-item.menu-item-type-custom.menu-item-object-custom.menu-item-has-children.show > div > div:nth-child(1) > div:nth-child(3) > div > a > h5"));
    }
    public WebElement btnUyeOl() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }}