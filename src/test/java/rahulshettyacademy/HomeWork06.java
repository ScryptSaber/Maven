package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HomeWork06 {
    public static void main(String[] args) throws InterruptedException {
        //WebDriver configs..
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Click checkbox option
        driver.findElement(By.id("checkBoxOption2")).click();
        String opt =driver.findElement(By.xpath("//label[normalize-space()='Option2']")).getText();

        //Select dropdown process
        Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropdown.selectByVisibleText(opt);

        //fill alert section
        WebElement alertSection = driver.findElement(By.id("name"));
        alertSection.sendKeys(opt);

        //click alert button
        WebElement alertButton = driver.findElement(By.id("alertbtn"));
        alertButton.click();

        //Check message
        String text =driver.switchTo().alert().getText();
        if(text.contains(opt)){
            System.out.println("Succesfully taken alert message..");
        }else{
            System.out.println("Failed :(( Smt is wrong !!");
        }

    }
}
