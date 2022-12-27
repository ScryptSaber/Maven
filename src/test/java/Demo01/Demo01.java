package Demo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement selectDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(selectDropDown);
        dropdown.selectByIndex(3);

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        List<WebElement> options = driver.findElements(By.cssSelector("li[class ='ui-menu-item'] a"));
        for (WebElement opt : options) {
            if (opt.getText().equalsIgnoreCase("India")) {
                opt.click();
                break;
            }
        }

    }
}
