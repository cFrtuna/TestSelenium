import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Googlesearchtestcase {

    public static void main (String[] args){
Sel sel =new Sel();

        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
        WebDriver driver = new ChromeDriver(); // launches a new browser session

        //navigating the google
        driver.get("https://www.google.com/");
        //locate the elements
        WebElement inputBox = driver.findElement(By.name("w"));

        //When find the element

        String searchTerm = "Audi R8";
        // Enter the search term  //Hit enter
        inputBox.sendKeys(searchTerm+ Keys.ENTER);

        inputBox.sendKeys("Audi 8");
        driver.findElement(By.name("btnk")).click();

        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(searchTerm));

        driver.quit();
    }
}
