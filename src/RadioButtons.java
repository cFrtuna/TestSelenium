import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtons {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        // Get the value of a given CSS property. Color values should be returned as rgba strings,
        // so, for example if the "background-color" property is set as "green" in the HTML source,
        // the returned value will be "rgba(0, 255, 0, 1)".

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.xpath("//a[.='Order']")).click();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='radio']"));

        for (WebElement element : elements) {
            if(element.getAttribute("value").equals("American Express")  && !element.isSelected()){
                element.click();
            }
        }
    }
}