package Class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    WebDriver driver;
//go to syntax login
//    enter wrong credentials
//    verify the message is "invalid Credentials

    @BeforeMethod
    public void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test
    public void VerifyCredentials() {
        SoftAssert soft=new SoftAssert();
        String expectedText = "Invalid credential";//"Invalid credential 12345"
        WebElement username = driver.findElement(By.id("txtUsername"));
        // boolean displayed= Username.isDisplayed(); i can write this here also to remove th error
        username.sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        //assertion to make sure that the massage is correct
        soft.assertEquals(text,expectedText);
        //the below is the first way
        WebElement Username = driver.findElement(By.id("txtUsername"));
        boolean displayed= Username.isDisplayed();
        //validate the displayed is true or not
        System.out.println("hello world");
        soft.assertTrue(displayed);//this line will check the condition if false will show the difference and also the cause of fail
        //check all assertion
        soft.assertAll();

    }

    @AfterMethod
    public  void  CloseBrowser(){
        driver.quit();
    }
}
