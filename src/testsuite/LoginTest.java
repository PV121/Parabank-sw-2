package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.util.WeakHashMap;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void openLoginTest() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // to find username element
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("Amrendra");
        //to find password element
        WebElement password = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"));
        password.sendKeys("Bahubali");
        // to find login button element
        WebElement logInBtn = driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        logInBtn.click();

    }

    @Test
    public void verifyTheErrorMessage() {
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Amrendra1");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Bahubali1");
        WebElement logInBtn = driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        logInBtn.click();
        // store an expected message in  string
        String expectedMessage = "The username and password could not be verified.";
        // to get actual message element
        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        // store an actual message in string
        String actualMessage = actualMessageElement.getText();
        // validate actual and expected message
        Assert.assertEquals("Sign in error message: ", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("Amrendra");
        WebElement password = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"));
        password.sendKeys("Bahubali");
        WebElement logInBtn = driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        logInBtn.click();
        WebElement logOutBtn = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        logOutBtn.click();
        // store an expected message in  string
        String expectedMessage= "Customer Login";
        // to get actual message element
        WebElement actualMessageElement= driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        // store an actual message in string
        String actualMessage= actualMessageElement.getText();
        // validate actual and expected message
        Assert.assertEquals("Customer Login",expectedMessage,actualMessage);
    }
}