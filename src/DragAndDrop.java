import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();



        driver.get("https://javascript.info/mouse-drag-and-drop");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://en.js.cx/article/mouse-drag-and-drop/ball/']")));

        WebElement source = driver.findElement(By.id("ball"));




        new Actions(driver).clickAndHold(source).moveByOffset(250,100).release(source).build().perform();  // click and hold drag and drop

        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/article/mouse-drag-and-drop/ball4/']")));


        WebElement source1 = driver.findElement(By.id("ball"));

        WebElement target = driver.findElement(By.id("gate"));

        new Actions(driver).dragAndDrop(source1, target).build().perform();


 //       driver.get("https://www.amazon.com/");

 //       WebElement link = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

  //      new Actions(driver).moveToElement(link).build().perform();  // hover over


    }
}