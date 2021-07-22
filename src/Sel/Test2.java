package Sel;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class Test2 {
    private static int wait;public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
// 1. Navigate to carmax.com
        driver.get("https://www.carmax.com/activity/appointment/instant-cash-offer?storeId=7132&appraisalCode=MDBUD2SA&originPage=HP_ICO_NewOffer");

// 10. On the next page which opens in new window, write a code that chooses one of the locations
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals("Appraisal Appointment | CarMax")){
                break;
            }
        }

        Select selcSelect = new Select(driver.findElement(By.className("mdc-select__native-control")));
        Thread.sleep(2000);
        new Select(driver.findElement(By.xpath("//select[@class='mdc-select__native-control']")));
        Thread.sleep(2000);

//            java.util.List<org.openqa.selenium.WebElement> locations = driver.findElements(By.xpath("//option"));
//            for (org.openqa.selenium.WebElement location : locations) {
//                location.click();
//            location.click();
        java.util.List<org.openqa.selenium.WebElement> productElems = driver.findElements(By.xpath("//select/option[@value]"));
        // get the lenght of productElems
        int maxProducts = productElems.size();
        // get random number
        java.util.Random random = new java.util.Random();
        int randomProduct = random.nextInt(maxProducts);
//         Select the list item
        productElems.get(randomProduct).click();

//        11. Choose the first available date:
        driver.findElement(By.className("date-container")).click();
        org.openqa.selenium.JavascriptExecutor jse2 = (org.openqa.selenium.JavascriptExecutor) driver;
        jse2.executeScript("window.scrollBy(0,300)");

//        org.openqa.selenium.WebElement dateWidgetFrom = untilwait.until(
//                org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar"))).get(0);

        Thread.sleep(2000);
  //      driver.findElement(By.xpath("//div[@aria-disabled='false']")).click();
        WebElement firstAvailableDateButton = driver.findElement(By.xpath("//div[@aria-disabled='false']"));

        //Click on the first available date
        firstAvailableDateButton.click();
        Thread.sleep(2000);

//       12.Click on the first available time
        driver.findElement(By.id("react-timepicker")).click();
        driver.findElement(By.xpath("//li[@class='react-datepicker__time-list-item ']")).click();
        Thread.sleep(2000);

//      13.Click on Next
        driver.findElement(By.xpath("//button[@class='kmx-button--primary kmx-button']")).click();
 //       driver.findElement(By.className("kmx-button--primary kmx-button")).click();

//        14. On the next page, fill out the form with random info. You can use Faker library or
//       external data file from Mockaroo. DO NOT click on next afterwards since clicking it will
//        create an actual appraisal appointment and will occupy the actual time slot.

        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='radio']"));

        for (WebElement element : elements) {
            if (element.getAttribute("value").equals("Loan") && !element.isSelected()) {
                element.click();
            }
        }

        Faker faker = new Faker();
        driver.findElement(By.id("fname")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("lname")).sendKeys(faker.name().lastName());

        WebElement emailAddressTextbox=driver.findElement(By.id("email"));
        String email= faker.internet().emailAddress();
        emailAddressTextbox.sendKeys(email);

        WebElement phoneNumberTextbox=driver.findElement(By.id("phone"));
        String phoneNumber= faker.phoneNumber().phoneNumber();
        phoneNumberTextbox.sendKeys(phoneNumber);

        Faker fakeData= new Faker();
        System.out.println(fakeData.phoneNumber().cellPhone());

//      15. Click on Privacy policy link which opens the new tab and verify that the title is
//     “Privacy Policy | CarMax”

        driver.findElement(By.linkText("Privacy Policy")).click();

        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains("CarMax"));

//      16. Go back to previous window with the offer amount and click on Save this offer

        Thread.sleep(2000);
        Set<String> windowHandles2 = driver.getWindowHandles();
        for (String windowHandle : windowHandles2) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals("CarMax - Browse used cars and new cars online")){
                break;
            }
        }


    }
}
