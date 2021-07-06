import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutomationProject21 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
        WebDriver driver = new ChromeDriver();

        // 2. Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        // 3. Login using username Tester and password test!"
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        // 4. Click on Order link
        driver.findElement(By.linkText("Order")).click();

        // 5. Enter a random product quantity between 1 and 100
        String text = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).getAttribute("value");

        for (int i = 0; i < text.length(); i++) {
            driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Keys.BACK_SPACE);
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String randomProductQuantity = "" + (int) (Math.random() * 100);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Keys.BACK_SPACE, randomProductQuantity, Keys.ENTER);


        //String RandomNum = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).getAttribute("(int)(Math.random()*100)");
        //driver.findElement(By.name("ctal00$MainContent$fmwOrder$txtQuantity")).sendKeys("(int)(Math.random()*100)");

        // 6. Click on Calculate and verify that the Total value is correct.
        driver.findElement(By.className("btn_dark")).click();


        // 7.Generate and enter random first name and last name.

      }
    }
