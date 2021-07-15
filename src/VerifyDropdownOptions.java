import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifyDropdownOptions {

    public static void main(String[] args) throws InterruptedException {

        // Choose Tesla and verify that it has these models Model X, Model 3, Model S, Model Y.

        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
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

        WebElement firstSelectedOption = new Select(driver.findElement(By.xpath("//select[@placeholder='Make']"))).getFirstSelectedOption();

        Assert.assertEquals(firstSelectedOption.getText(), "Make"); // Verify the default selected option

        new Select(driver.findElement(By.xpath("//select[@placeholder='Make']"))).selectByValue("Tesla");

        Thread.sleep(2000);

        List<String> expected = Arrays.asList("Model", "Model X", "Model 3", "Model S", "Model Y");

        List<WebElement> options = new Select(driver.findElement(By.xpath("//select[@placeholder='Model']"))).getOptions();

        List<String> actual = new ArrayList<>();

        for (WebElement s : options) {

            actual.add( s.getText());
        }

        Collections.sort(actual );
        Collections.sort(expected );

        Assert.assertEquals(actual, expected);





    }
}