package browserfactory;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        // to set the driver's property
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        driver= new ChromeDriver();

        driver.get(baseUrl);// TO launch URL

        driver.manage().window().maximize();// to maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// to give implicit time
        }
        public void closeBrowser(){
        driver.quit();
        }
    }
