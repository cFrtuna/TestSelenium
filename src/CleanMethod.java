import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CleanMethod {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(System.getProperty("os.name"));
        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.get("https://www.hoteltonight.com/");

        //If this element is a text entry element, this will clear the value. Has no effect on other elements.
        // Text entry elements are INPUT and TEXTAREA elements.
        // Note that the events fired by this event may not be as you'd expect.

        //  driver.findElement(By.name("searchfield")).clear();  //didn't work

        String text = driver.findElement(By.name("searchfield")).getAttribute("value");

        for (int i = 0; i < text.length(); i++) {
            driver.findElement(By.name("searchfield")).sendKeys(Keys.BACK_SPACE);
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.findElement(By.name("searchfield")).sendKeys("Washington DC" + Keys.ENTER);
    }
}