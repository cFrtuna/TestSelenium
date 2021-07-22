package Sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SignUpTest {

    private static int wait;public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // Open website
        driver.get("http://testsite.usetrace.com");

        // Find the link to registration form
        WebElement link = driver.findElement(By.cssSelector("[data-name='Register']"));

        // Click the link
        link.click();

        // Generate a random email
        final String randomEmail = randomEmail();

        // Find the email form field
        WebElement email = driver.findElement(By.id("register-email"));

        // Type the random email to the form
        email.sendKeys(randomEmail);

        // Find the password form field
        WebElement password = driver.findElement(By.id("register-password"));

        // Type a password to the form. This needs not be unique.
        password.sendKeys("John123");

        // Submit the sign up form
        password.submit();

        // Check the sign up succeeded by checking that the randomized
        // email appears in the website's header bar.
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                WebElement header = d.findElement(By.id("header-login"));
                return header.getText().contains(randomEmail);
            }
        });

        //Close the browser
//        driver.quit();
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }
}