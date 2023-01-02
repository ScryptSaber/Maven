package rahulshettyacademy.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HomeWork07 {
    public static void main(String[] args) {
        //WebDriver configs..
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Row number
        WebElement table = driver.findElement(By.id("product"));
        System.out.println("Number of row in the table: " + table.findElements(By.tagName("tr")).size());

        //Column number
        System.out.println("Number of column in the table: " + table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

        //second row content
        List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
        System.out.println(secondRow.get(0).getText());
        System.out.println(secondRow.get(1).getText());
        System.out.println(secondRow.get(2).getText());


    }
}
