import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.logging.Logger;


public class Locators {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
        String errorMessage= driver.findElement(By.cssSelector("p.error")).getText();
        boolean result = errorMessage.equals("* Incorrect username or password");
        System.out.println("Verified--->"+result);
        driver.findElement(By.linkText("Forgot your password?")).click();
        System.out.println("Link is Clicked");
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception (e.g., log it)
        }
        driver.findElement(By.xpath("//input[@placeholder='Name']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Aradhya");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("aradhya.jain2882@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("7891456369");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        //input[@type*='pass'] regular expression css
        //input[contains(@class,'submit')] regular expression xpath



        //driver.quit();

        //css = tagname.classname OR tagname#id OR Tagname[attribute='value']

        //driver.close();
    }

}
