import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class AutomationProject3<actual> {
    public static void main(String[] args) throws IOException, InterruptedException {
//      . Launch Chrome browser.
        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

//      1. Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.navigate().to("http://carfax.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);


//     2. Click on Find a Used Car
        driver.findElement(By.linkText("Find a Used Car")).click();

 //     3. Verify the page tittle contains the word "Used Cars"

        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains("Used Cars"));

//      4.	Choose “Tesla” for  Make.

        new Select(driver.findElement(By.xpath("//select[@name='make']"))).selectByIndex(31);
//
//      5.Verify that the Select Model dropdown box contains 4 current Tesla models (Model 3, Model S, Model X, Model Y).
        List<String> actualModels = new ArrayList<>();
        List<String> expectedModels = Arrays.asList("Model 3", "Model S", "Model X", "Model Y");
        List<WebElement> elements = new Select(driver.findElement(By.xpath("//select[@name='model']"))).getOptions();
        for (int i = 1; i < elements.size() - 1; i++) {
            actualModels.add(elements.get(i).getText().trim());
        }
        Assert.assertEquals(actualModels, expectedModels);

//      6.	Choose “Model S” for Model.

        new Select(driver.findElement(By.xpath("//select[@name='model']"))).selectByIndex(2);

 //    7.	Enter the zip code 22182 and click Next

        driver.findElement(By.xpath("//select[@placeholder='Zip Code ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@placeholder='Zip Code ']")).sendKeys("22182");
        Thread.sleep(2000);
        driver.findElement(By.id("make-model-form-submit")).click();



    }

    }

