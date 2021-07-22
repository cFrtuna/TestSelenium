import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class AutomatisationProj4Optim {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");

        WebDriver driver = new ChromeDriver();
        AutomatisationProj4Optim proj = new AutomatisationProj4Optim();
        proj.start(driver);

        WebDriver drive2r = new FirefoxDriver();
        AutomatisationProj4Optim proj2 = new AutomatisationProj4Optim();
        proj2.start(drive2r);
    }

    private static final int VIEW_TIMEOUT_SECONDS = 15;
    public static final int INITIAL_SCROLL_DOWN_AMMOUNT = 2000;
    public static final int INITIAL_SCROLL_UP_AMMOUNT = 500;
    public static final int LAST_SCROLL_DOWN_AMMOUNT = 800;
    public static final int VISIBLE_FATURES_AMMOUNT = 12;

    public static final String VIN_XPATH_ID = "//button[@id='button-VIN']";
    public static final String VIN_INPUT_FORM_ID = "ico-form-vin";
    public static final String FEATURES_ID = "//input[@type='checkbox']";

    public static final String INPUT_VIN_NUMBER = "4T1BE46K67U162207";
    public static final String ZIP_CODE = "22182";

    private WebDriver driver;// = new ChromeDriver();

    private void setup() {
        //      . Launch Chrome browser.
//      1. Navigate to http:http://carmax.com
        driver.navigate().to("http://carmax.com");
        driver.manage().window().maximize();
    }

    public void start(WebDriver driver) {
        this.driver = driver;
        setup();

//       // 2. On the bottom of the page in the appraisal form, choose VIN and fill out the form with
//       //the below info and click get started: VIN: 4T1BE46K67U162207 Zipcode:22182

        scrollDown(INITIAL_SCROLL_DOWN_AMMOUNT);
        scrollUp(INITIAL_SCROLL_UP_AMMOUNT);
        scrollDown(LAST_SCROLL_DOWN_AMMOUNT);

        waitForElementByXpath(VIN_XPATH_ID);
        driver.findElement(By.xpath(VIN_XPATH_ID)).click();
        driver.findElement(By.id(VIN_INPUT_FORM_ID)).sendKeys(INPUT_VIN_NUMBER, Keys.TAB, ZIP_CODE, Keys.ENTER);

// 3. On the next page, choose the following info:
        waitForElementByXpath("//label[.='LE 4D Sedan 2.4L']");
        WebElement el = driver.findElement(By.xpath("//label[.='LE 4D Sedan 2.4L']"));
        el.click();
        new WebDriverWait(driver, 8).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("drive"))));
        Select select = new Select(driver.findElement(By.name("drive")));
        select.selectByValue("4WD/AWD");
// 4. For features, check all options:
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("window.scrollBy(0,2000)");
        checkAllVisibleFeatures();
        WebElement elm = driver.findElement(By.xpath("//button[@id='ico-step-Mileage_and_Condition-btn']"));
        scrollTo(elm);
        driver.findElement(By.id("ico-step-Mileage_and_Condition-btn")).click();

    }

    private void checkAllVisibleFeatures() {
        List<WebElement> checkboxes = driver.findElements(By.xpath(FEATURES_ID));
        for (int i = 0; i < VISIBLE_FATURES_AMMOUNT; i++) {
            scrollTo(checkboxes.get(i));
            checkboxes.get(i).click();
        }
    }

    /**
     * this is a helper method that scroll down the page by
     * the given amount
     *
     * @param by the amount to scroll he page
     */
    public void scrollDown(int by) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + by + ")");
    }

    public void scrollUp(int by) {
        scrollDown(-by);
    }

    private void waitForElementByXpath(String xPathId) {
        new WebDriverWait(driver, VIEW_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathId)));
    }

    private void waitForElementById(String id) {
        new WebDriverWait(driver, VIEW_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    private void scrollTo(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
