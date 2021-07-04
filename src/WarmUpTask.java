import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WarmUpTask {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");

        WebDriver wd = new ChromeDriver(); // launches a new browser session


        wd.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

//        WebElement inputBox1=wd.findElement(By.id("ctl00_MainContent_username"));
//        String username="Tester";
//        inputBox1.sendKeys(username);
//        WebElement inputBox2=wd.findElement(By.id("ctl00_MainContent_password"));
//        String password="test";
//        inputBox2.sendKeys(password + Keys.ENTER);

        wd.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);


        String actualTitle="Web Orders";

        String expectedTitle=wd.getTitle();

        assertTrue(actualTitle.contains(expectedTitle));

        String HTMLCode=wd.getPageSource();


        assertTrue(HTMLCode.contains("Welcome, Tester"));
        assertTrue(HTMLCode.contains("List of All Orders"));

        List<WebElement> links = wd.findElements(By.tagName("a"));

        List<String> expectedList = Arrays.asList("View all orders", "View all products", "Order", "Logout", "Check All", "Uncheck All");

        List<String> actualList = new ArrayList<>();

        for (WebElement link : links) {

            actualList.add(link.getText());
        }

        assertEquals(actualList, expectedList);

        assertEquals(links.size(), 6);

        for (WebElement link : links) {
            System.out.println(link.getText()); }

        wd.findElement(By.id("ctl00_logout")).click();

        assertTrue(wd.getTitle().equals("Web Orders Login"));



    }


}