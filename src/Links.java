import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

    public static void main(String[] args) {



        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.get("https://www.duotech.io/");
        driver.findElement(By.linkText("About")).click();
        driver.findElement(By.partialLinkText("Con")).click();
    }
}
