package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    static String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void openBrowserRegTest(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        WebElement register =  driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a"));
        register.click();
        String expectedSignInMessage = "Signing up is easy!";

        WebElement actualSignInMessageElement = driver.findElement(By.xpath("//div[@id='rightPanel']/h1"));
        String actualSignInMessage = actualSignInMessageElement.getText();

        Assert.assertEquals("Easy signing Message: ",expectedSignInMessage,actualSignInMessage);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully(){
        WebElement register =  driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a"));
        register.click();
        WebElement firstName =  driver.findElement(By.name("customer.firstName"));
        firstName.sendKeys("AmrendraBhai");
        WebElement lastName =  driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Bahubali");
        WebElement address =  driver.findElement(By.xpath("//input[@id='customer.address.street']"));
        address.sendKeys("LionKing Street");
        WebElement city =  driver.findElement(By.xpath("//*[@id='customer.address.city']"));
        city.sendKeys("Krukshetra");
        WebElement state =  driver.findElement(By.xpath("//input[@id='customer.address.state']"));
        state.sendKeys("Cambridge");
        WebElement zipCode =  driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
        zipCode.sendKeys("389532");
        WebElement phone =  driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
        phone.sendKeys("123456789");
        WebElement ssn =  driver.findElement(By.xpath("//input[@id='customer.ssn']"));
        ssn.sendKeys("987654321");
        WebElement userName =  driver.findElement(By.xpath("//input[@id='customer.username']"));
        userName.sendKeys("Amrendra");
        WebElement password =  driver.findElement(By.xpath("//input[@id='customer.password']"));
        password.sendKeys("Bahubali");
        WebElement confpassword =  driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
        confpassword.sendKeys("Bahubali");
        WebElement registerBtn= driver.findElement(By.xpath("//td[@colspan='2']/input"));
        registerBtn.click();

        String expectedMessage= "Your account was created successfully. You are now logged in.";

        WebElement actualMessageElement= driver.findElement(By.xpath("//div[@id='bodyPanel']/div[2]/p"));
        String actualMessge= actualMessageElement.getText();

        Assert.assertEquals("Login Successfully Message:",expectedMessage,actualMessge);

    }
    @After
    public void closeBrowserRegTest(){
        closeBrowser();
    }
}
