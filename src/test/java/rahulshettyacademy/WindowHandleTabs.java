package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandleTabs {
    public static void main(String[] args) throws InterruptedException {
        //Configs..
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");

        //1. Give me the count of links on the page.
        System.out.println("The count of links on the page: " + driver.findElements(By.tagName("a")).size());

        //2. Count of footer section.
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope
        System.out.println("Count of footer section: " + footerdriver.findElements(By.tagName("a")).size());

        //3-Count of first column in footer section
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println("Count of first column in footer section: " + columndriver.findElements(By.tagName("a")).size());

        //4- click on each link in the coloumn and check if the pages are opening-
        for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {

            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000L);

        }
        // opens all the tabs
        Set<String> abc = driver.getWindowHandles();//4
        Iterator<String> it = abc.iterator();

        while (it.hasNext()) {

            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());

        }

        /** Second way of iteration.

        for(String winHandle:driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
         */
    }
}
