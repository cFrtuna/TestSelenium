import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
public class WarmUp2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/cristianfortuna/Documents/drivers/chromedriver ");


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();



        driver.get("https://www.dice.com/");
        driver.manage().deleteAllCookies();
        driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");
        driver.findElement(By.id("google-location-search")).clear();
        driver.findElement(By.id("google-location-search")).sendKeys("Washington, DC, USA", Keys.TAB, Keys.ENTER);
//        driver.findElement(By.id("043881b1fcbf56dc12203ba27b887a56")).click();

//        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='card-title-link bold']")));

        List<WebElement> links = driver.findElements(By.xpath("//a[@class='card-title-link bold']"));

        Map<String, Integer> map = new TreeMap<>();


        for (int i = 0; i < links.size() ; i++) {

            links = driver.findElements(By.xpath("//a[@class='card-title-link bold']"));

            if(links.size()==0){
                break;
            }

            links.get(i).click();


            String text = driver.findElement(By.xpath("//div[@id='jobdescSec' and @class='highlight-black'] ")).getText();


            String[] split = text.split("[ .,()=-]");



            for (String s: split) {
                if (!map.containsKey(s)){
                    map.put(s, 1);
                }else{
                    int value = map.get(s);
                    value++;
                    map.put(s, value);
                }
            }

            driver.navigate().back();
            driver.navigate().refresh();
            i--;
        }

        //   StaleElementReferenceException: stale element reference: element is not attached to the page document

        // The most common case is when you store a webelement on one page, and navigate to another page and come back to the same page again and try to use
        // the element

        //The most frequent cause of this is that page that the element was part of has been refreshed, or the user has
        //navigated away to another page.

        System.out.println(map);


    }
}