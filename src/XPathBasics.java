import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class XPathBasics {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();


        driver.get("https://www.duotech.io/");


        List<WebElement> div = driver.findElements(By.xpath("//div")); //retrives all a elements from the page

        System.out.println(div.size());

        String fullXpath = "/html/body/div[2]/div[3]/div/h1";

        System.out.println(driver.findElement(By.xpath(fullXpath)).getText());

        String relativeXpath = "//h1";

        System.out.println(driver.findElement(By.xpath(relativeXpath)).getText());


        String commonXpathWithAttributes = "//p[@class='paragraph-big']";

        //p[@class="paragraph-big"]  you can also use double quotes

        System.out.println(driver.findElement(By.xpath("//p[@class='paragraph-big']")).getText()); // single attribute


        System.out.println(driver.findElement(By.xpath("//a[@class='link-2'][@href='https://duotech.talentlms.com/']")).getText());
        // multiple attributes

        System.out.println(driver.findElement(By.xpath("//a[.='Contacts']")).getText()); // by exact text match

        String containsText = "//p[   contains(    text()  , 'Business Systems Analyst and'    )]"; // by partial text match

        System.out.println(driver.findElement(By.xpath(containsText)).getText());







    }
}