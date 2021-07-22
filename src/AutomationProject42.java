import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;import java.util.concurrent.TimeUnit;
public class AutomationProject42 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // 1. Navigate to carmax.com
        driver.get("https://www.carmax.com/");
        //driver.manage().deleteAllCookies();
        // 2. On the bottom of the page in the appraisal form, choose VIN and fill out the form with
        //the below info and click get started: VIN: 4T1BE46K67U162207 Zipcode:22182
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2000)");
        jse.executeScript("window.scrollBy(0,-800)");
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//button[@id='button-VIN']")).click();
        driver.findElement(By.id("ico-form-vin")).sendKeys("4T1BE46K67U162207", Keys.TAB, "22182", Keys.ENTER);
        // 3. On the next page, choose the following info:
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[.='LE 4D Sedan 2.4L']"))).click();
        new WebDriverWait(driver, 8).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("drive"))));
        new Select(driver.findElement(By.name("drive"))).selectByValue("4WD/AWD");
        // 4. For features, check all options:
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 0; i < 12; i++) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", checkboxes.get(i));
            checkboxes.get(i).click();
        }
        driver.findElement(By.xpath("//span[.='Mileage and condition']")).click();
        // 5. Enter the following mileage and the choose the following
        driver.findElement(By.name("currentMileage")).sendKeys("60000");
        //driver.findElement(By.cssSelector("#question-100 > div:nth-child(2) > div:nth-child(1) > label")).click();
        List<WebElement> checkboxes2 = driver.findElements(By.xpath("//label[.='No']"));
        for (int i = 0; i <= 21; i++) {
            JavascriptExecutor executor2 = (JavascriptExecutor) driver;
            executor2.executeScript("arguments[0].scrollIntoView(true);", checkboxes2.get(i));
            if (i % 2 != 0)
                checkboxes2.get(i).click();

        }
        driver.findElement(By.xpath("//input[@id='radio-ico-r-600-1']")).click();
        driver.findElement(By.id("ico-continue-button")).click();

        // 6. Verify that Vehicle Information table contains the following expected data for the below 2 columns:
        driver.findElement(By.id("ico-step-Vehicle_Profile-btn")).click();

        List<WebElement> carInfo = driver.findElements(By.xpath("//td//p[contains (@id, 'vehicleInfo')]"));
        List<String> actualCarInfo = new ArrayList<>();
        for (int i = 4; i < carInfo.size(); i++) {
            actualCarInfo.add(carInfo.get(i).getText());
        }
        List<String> expectedCarInfo = Arrays.asList("2007 Toyota Camry", "4WD/AWD", "Automatic", "4T1BE46K67U162207", "60,000");
        Assert.assertEquals(actualCarInfo, expectedCarInfo);

        // 7.Click continue //
        // 8. On the next page, verify that the appraisal amount is 6600.
        String actualOffer = driver.findElement(By.xpath("//div[@class='kmx-ico-offer-offerinfo Offer-module__offerInfo--26dFt']")).getText();
        Assert.assertTrue(actualOffer.contains("6,400"));

        // 9. Click continue
        driver.findElement(By.id("ico-set-my-appointment")).click();

 //      10. On the next page which opens in new window, write a code that chooses one of the locations

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
//
//            for (org.openqa.selenium.WebElement location : locations) {
//                location.click();
//            location.click();
        List<WebElement> productElems = driver.findElements(By.xpath("//select/option[@value]"));
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

        com.github.javafaker.Faker faker = new com.github.javafaker.Faker();
        driver.findElement(By.id("fname")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("lname")).sendKeys(faker.name().lastName());

        WebElement emailAddressTextbox=driver.findElement(By.id("email"));
        String email= faker.internet().emailAddress();
        emailAddressTextbox.sendKeys(email);

        WebElement phoneNumberTextbox=driver.findElement(By.id("phone"));
        String phoneNumber= faker.phoneNumber().phoneNumber();
        phoneNumberTextbox.sendKeys(phoneNumber);

        com.github.javafaker.Faker fakeData= new com.github.javafaker.Faker();
        System.out.println(fakeData.phoneNumber().cellPhone());

//      15. Click on Privacy policy link which opens the new tab and verify that the title is
//     “Privacy Policy | CarMax”

        driver.findElement(By.linkText("Privacy Policy")).click();

        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("CarMax"));

//      16. Go back to previous window with the offer amount and click on Save this offer
        Thread.sleep(2000);

        java.util.Set<String> windowHandles2 = driver.getWindowHandles();
        for (String windowHandleBefore : windowHandles2) {
            driver.switchTo().window(windowHandleBefore);
            if(driver.getTitle().equals("CarMax - Browse used cars and new cars online")){
                break;
            }
        }
        driver.findElement(By.xpath("//button[.='Save this offer']")).click();

//      17. On the pop-up window add random email and click send my offer

        driver.findElement(By.name("kmx-text-field__input mdc-text-field__input")).sendKeys("cristian.fortuna01@gmail.com" + Keys.ENTER);
        driver.findElement(By.xpath("//button[.='SEND MY OFFER']")).click();

//       18. End the session by closing down all the windows

        driver.quit();


    }
}




