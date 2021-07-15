import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropDowns {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","/Users/cristianfortuna/Documents/drivers/chromedriver ");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.kbb.com/");

        driver.findElement(By.xpath("//span[.='Price New/Used']")).click();

        WebElement selectBox = driver.findElement(By.xpath("//select[@placeholder='Year']"));

        Select dropdownBoxYear = new Select(selectBox);  // We need to create a Select object that represents the dropdownbox
        //  Select dropdownBoxYear = new Select(WebElement);

        //  Select dropdownBoxYear = new Select(driver.findElement(By.xpath("//select[@placeholder='Year']")));

        dropdownBoxYear.selectByVisibleText("2021");
        //   dropdownBoxYear.deselectByVisibleText("2021"); //You may only deselect options of a multi-select dropdownbox

        Thread.sleep(2000);

        new Select(driver.findElement(By.xpath("//select[@placeholder='Make']"))).selectByValue("Audi");

        Thread.sleep(2000);


        new Select(driver.findElement(By.xpath("//select[@placeholder='Model']"))).selectByIndex(15);


        driver.findElement(By.xpath("//button[@type='submit']")).click();



    }
}