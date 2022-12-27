package TestSuit02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase04 {
    public static void main(String[] args) throws InterruptedException {
        //Test scenario:After login and after select prosess test if delete selected
        //TestCase04:Testing 'Delete Selected' button

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

        //click delete selected button
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        //close the browser
        driver.quit();

    }
}
