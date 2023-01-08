package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("form-field-travel_comp_date")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");


        while (!driver.findElement(By.xpath("//span[@class='cur-month']")).getText().contains("May")) {
            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']//*[name()='svg']")).click();
        }


        List<WebElement> dates = driver.findElements(By.className("day"));
        //Grab common attribute//Put into list and iterate
        int count = driver.findElements(By.className("day")).size();

        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.className("day")).get(i).getText();
            if (text.equalsIgnoreCase("21")) {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }
    }

}

