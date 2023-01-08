package com.automationexexercise;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase13 {
    WebDriver driver;
    String quantity = "4";
    ExtentReports extent;

    @BeforeTest
    public void config() {
        String path = System.getProperty("user.dir") + "\\reports\\index1.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Erdem");


    }

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://automationexercise.com");
    }

    @Test
    public void verifyHomePageVisible() {
        // Verify that the homepage is visible
        ExtentTest test = extent.createTest("Initial Demo");

        WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        String txt = element.getText();
        Assert.assertEquals(txt, "Home");
        extent.flush();
    }

    @Test
    public void verifyProductisDisplayedInCartTrue() {
        ExtentTest test2 = extent.createTest("Initial Demo22");
        //Scroll down right place
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");


        //Click 'View Product' for any product on home page
        WebElement viewProduct = driver.findElement(By.xpath("//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]"));
        viewProduct.click();


        //Verify view
        WebElement element2 = driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']"));
        Assert.assertEquals(element2.getText(), "Rs. 500");


        //Increase quantity to 4
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//input[@id='quantity']"))).build().perform();

        driver.findElement(By.xpath("//input[@id='quantity']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys(quantity);


        //Click 'Add to cart' button
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();


        //Click 'View Cart' button
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();


        //Verify that product is displayed in cart page with exact quantity
        String actual = driver.findElement(By.xpath("//button[normalize-space()='4']")).getText();
        Assert.assertEquals(actual, quantity);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}


