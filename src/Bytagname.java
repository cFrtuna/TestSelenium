import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Bytagname {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.get("https://www.duotech.io/");
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link:links) {
            System.out.println(link.getText());
        }

        List<WebElement>elems = driver.findElements(By.tagName("w"));
        System.out.println(elems.size());
        }
    }

