package TestSuit03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestCase07 {
    public static void main(String[] args) throws InterruptedException {
        //Test scenario:After login, click order button
        //TestCase01:Testing 'order' button

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

        //Valid username
        driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester");

        //Invalid username
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        //click the login button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();


        //click "View all products"
        driver.findElement((By.xpath("//a[normalize-space()='View all products']"))).click();

       //get current URL
        String act = driver.getCurrentUrl();

        //Checking actual - expected result
        Assert.assertEquals(act, "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Products.aspx");

    }
}