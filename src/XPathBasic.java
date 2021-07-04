import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import java.util.concurrent.TimeUnit;

public class XPathBasic {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        // Get the value of a given CSS property. Color values should be returned as rgba strings,
        // so, for example if the "background-color" property is set as "green" in the HTML source,
        // the returned value will be "rgba(0, 255, 0, 1)".

        driver.get("//https:www.duotech.io");
        List<WebElement> div=driver.findElements(By.xpath("//div"));
        System.out.println(div.size());
        String fullXPath="/htlm/body/div[2]/div[3]/div/h1";
        System.out.println(driver.findElement(By.xpath(fullXPath)).getText());
        String relativeXPath="//h1";



    }
}