import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UsingAttributes {
    public static void main(String[] args) throws IOException, InterruptedException {
//      1. Launch Chrome browser.
        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
        WebDriver wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.get("https://www.duotech.io/");
        //List<WebElement> = wd.findElement(By.xpath("(//input[@id]"));
        wd.findElement(By.xpath("(//input[not(@id)]"));
        wd.findElement(By.xpath("//*[@*='email']"));
        //sendKeys("Hello");


    }
}
