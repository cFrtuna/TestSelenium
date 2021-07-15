import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UsingXpathAxis {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.duotech.io/");


        driver.findElement(By.xpath(" //div[@data-w-id='6ece7d70-83a5-6ab9-85ca-d3b52d1df6a5']//div[@class='service-simple-info']"));
        //div[@data-w-id='6ece7d70-83a5-6ab9-85ca-d3b52d1df6a5']//div[@class='service-simple-info']

        // Locating a unique parent and from there locate a non-unique child


        driver.findElement(By.xpath(" //h6[.='Solid Income']//ancestor::div[@class='service-simple-info']"));
        // Locate a unique child h6 that has a text 'Solid Income', and from there locate it s ancestor div with a class 'service-simple-info'

        driver.findElement(By.xpath(" //h6[.='Solid Income']//parent::div"));
        // Locate a unique child h6 that has a text 'Solid Income', and from there locate its parent div


        driver.findElement(By.xpath("//div[@data-w-id='c339b283-03ea-c60c-bb22-0601a49dde47']//preceding-sibling::div[1]"));
        // locate a unique sibling first, then find its first preceding non-unique sibling

        driver.findElement(By.xpath("//div[@data-w-id='6ece7d70-83a5-6ab9-85ca-d3b52d1df6a5']/following-sibling::div[1]"));
        // locate a unique sibling first, then find its first following non-unique sibling





    }
}