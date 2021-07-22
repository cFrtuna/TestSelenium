import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DMVApointmentBot {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get(" https://calendly.com/springfielddmv/select?month=2021-07");

        // To continuously check if there are available dates

//        while(driver.getPageSource().contains("No times in July")){
//             driver.navigate().refresh();
//             Thread.sleep(5000);
//        }

        //When the loop is finished, it means there is an availability

        // In this case, we are manually navigating to a month with available dates to test the rest of the script

        driver.findElement(By.xpath("//button[@aria-label='Go to next month']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@aria-label='Go to next month']")).click();
        WebElement firstAvailableDateButton = driver.findElement(By.xpath("//button[@class='ltzTYwddsj _2womJctmqT _1Qg-rkOB2V _2zIir_wMTE']"));
        Thread.sleep(2000);

        //Click on the first available date
        firstAvailableDateButton.click();


        //Click on the first available time
        driver.findElement(By.xpath("//button[@class='_2IrBWuPQTq _4rcXoQPLhG _1Qg-rkOB2V _2zIir_wMTE']")).click();

        // Click confirm
        driver.findElement(By.xpath("//button[@class='_2OQqVeh6S4 _1Es3W-g9AL _4rcXoQPLhG _1Qg-rkOB2V _2zIir_wMTE confirm-button-enter-done']")).click();

        driver.findElement(By.name("first_name")).sendKeys("Frank");
        driver.findElement(By.name("last_name")).sendKeys("Shepherd");
        driver.findElement(By.name("email")).sendKeys("f.shepherd@mail.ru");
        driver.findElement(By.name("question_0")).sendKeys("123-234-3456");
        driver.findElement(By.name("question_1")).sendKeys("Just checking in here...");




    }
}