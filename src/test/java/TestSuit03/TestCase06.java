package TestSuit03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase06 {
    public static void main(String[] args) throws InterruptedException {
        //Test scenario:After login, click order button
        //TestCase06:Testing All inputs

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

        //Valid username
        driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester");

        //Invalid username
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        //click the login button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();

        //Click order button
        driver.findElement((By.xpath("//a[normalize-space()='Order']"))).click();


        driver.findElement((By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"))).clear();


        driver.findElement((By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"))).sendKeys("50");
        driver.findElement((By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"))).sendKeys("Erdem Kamis");
        driver.findElement((By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"))).sendKeys("Celebi");
        driver.findElement((By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"))).sendKeys("Karaman");
        driver.findElement((By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"))).sendKeys("Turkey");
        driver.findElement((By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"))).sendKeys("70000");
        driver.findElement((By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"))).click();
        driver.findElement((By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"))).sendKeys("012345678999");
        driver.findElement((By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"))).sendKeys("01/29");
        driver.findElement((By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"))).click();

        //Check "reset" button
        driver.findElement((By.xpath("//input[@value='Reset']]"))).click();





    }
}