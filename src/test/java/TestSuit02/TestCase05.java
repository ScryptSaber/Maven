package TestSuit02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase05 {
    public static void main(String[] args) throws InterruptedException {

        //TestCase05:Testing Check First and Second button if it is selectable at the same time

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

        //Valid username
        driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester");

        //Invalid username
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        //click the login button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();

        //click the first checkbox
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();

        //click the second checkbox
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector")).click();

        //close the browser
        driver.quit();

    }
}
