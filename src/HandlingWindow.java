import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandlingWindow {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://www.toyota.com/");

        String parentaWindowHAndle = driver.getWindowHandle(); // gets the window handle of the current active window

        System.out.println("The parent window handle: " + parentaWindowHAndle);



        driver.findElement(By.xpath("//a[@href='https://privacy.toyota.com/']")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles.getClass());

        System.out.println("All window handles: " + windowHandles);

        for (String windowHandle : windowHandles) {

            if(!windowHandle.equals(parentaWindowHAndle)){
                driver.switchTo().window(windowHandle);
            }
        }


        String childWindowHandle = driver.getWindowHandle();

        System.out.println("The child window handle: " + childWindowHandle);
//

        System.out.println(driver.getTitle());

        //  ElementClickInterceptedException: element click intercepted: Element <span class="btn-text" aria-hidden="true">...</span> is not clickable at point (1267, 915). Other element would receive the click: <a class="button  9 block   " href="https://privacy.toyota.com/"

        // Click on link to open the 3rd window

        driver.findElement(By.xpath("//a[@href='https://www.toyota.com/support/california-privacy']")).click();

        Set<String> windowHandles2 = driver.getWindowHandles();

        System.out.println("All window handles after 3rd window: " + windowHandles2);


        for (String windowHandle : windowHandles2) {

            if(!windowHandle.equals(parentaWindowHAndle) && !windowHandle.equals(childWindowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }


        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());



    }
}