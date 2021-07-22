import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class AutomationProject4<actual> {

    private static int VIEW_TIMEOUT_SECONDS = 15;

    public static void main(String[] args) throws IOException, InterruptedException {
//      . Launch Chrome browser.
        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebDriver driver = new ChromeDriver();
//      1. Navigate to http:http://carmax.com
        driver.navigate().to("http://carmax.com");
        driver.manage().window().maximize();
//       // 2. On the bottom of the page in the appraisal form, choose VIN and fill out the form with
//       //the below info and click get started: VIN: 4T1BE46K67U162207 Zipcode:22182


        scrollDown(driver, 2000);
        scrollUp(driver, 500);
        scrollDown(driver, 800);

//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,2000)");
//        jse.executeScript("window.scrollBy(0,-500)");
//        jse.executeScript("window.scrollBy(0,800)");
//        Thread.sleep(5000);
        waitForElementByXpath(driver, "//button[@id='button-VIN']");
        driver.findElement(By.xpath("//button[@id='button-VIN']")).click();
        driver.findElement(By.id("ico-form-vin")).sendKeys("4T1BE46K67U162207", Keys.TAB, "22182", Keys.ENTER);

// 3. On the next page, choose the following info:
// /      driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        Thread.sleep(13000);
        waitForElementByXpath(driver, "//label[.='LE 4D Sedan 2.4L']");
        WebElement el = driver.findElement(By.xpath("//label[.='LE 4D Sedan 2.4L']"));
        //new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(el));
        el.click();
        new WebDriverWait(driver, 8).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("drive"))));
        Select select = new Select(driver.findElement(By.name("drive")));
        select.selectByValue("4WD/AWD");
// 4. For features, check all options:
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("window.scrollBy(0,2000)");
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
//        Actions action = new Actions(driver);
        for (int i = 0; i < 12; i++) {
//            Thread.sleep(500);
//            action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
            scrollTo(driver, checkboxes.get(i));
//            checkboxes.get(i).isDisplayed();
            checkboxes.get(i).click();
        }

        //               checkboxes.get(0).click();
        WebElement elm = driver.findElement(By.xpath("//button[@id='ico-step-Mileage_and_Condition-btn']"));
        scrollTo(driver, elm);
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].scrollIntoView(true);", elm);

        //      Thread.sleep(2000);
        //      driver.findElement(By.id("ico-features-showStandard")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("ico-step-Mileage_and_Condition-btn")).click();
        new WebDriverWait(driver, 8).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='ico-step-Mileage_and_Condition-btn']")));
        Thread.sleep(2000);
        //      WebElement elm = driver.findElement(By.xpath("//button[@id='ico-step-Mileage_and_Condition-btn']"));
        Thread.sleep(2000);
        //     elm.click();
        Thread.sleep(2000);
        //       JavascriptExecutor executor = (JavascriptExecutor) driver;
        //       executor.executeScript("arguments[0].scrollIntoView(true);", elm);
//        Thread.sleep(2000);
        waitForElementById(driver, "ico-step-Mileage_and_Condition-btn");
        driver.findElement(By.id("ico-step-Mileage_and_Condition-btn")).click();
//        Thread.sleep(2000);
        waitForElementByXpath(driver, "//span[.='Mileage and condition']");
        driver.findElement(By.xpath("//span[.='Mileage and condition']")).click();
//        Thread.sleep(2000);
        driver.findElement(By.className("StepHeader-module__completionIcon--1Ss3u")).click();

    }

    public static void scrollDown(WebDriver driver, int by) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + by + ")");
    }

    public static void scrollUp(WebDriver driver, int by) {
        scrollDown(driver, -by);
    }

    private static void waitForElementByXpath(WebDriver driver, String xPathId) {
        new WebDriverWait(driver, VIEW_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathId)));
    }

    private static void waitForElementById(WebDriver driver, String id) {
        new WebDriverWait(driver, VIEW_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    private static void scrollTo(WebDriver driver, WebElement element) {
//        WebElement elm = driver.findElement(By.xpath("//button[@id='ico-step-Mileage_and_Condition-btn']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}