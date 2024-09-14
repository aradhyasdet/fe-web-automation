import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.testng.Assert;

public class HappyPath {
    public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            String password = Functions.getPassword(driver);
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.findElement(By.id("inputUsername")).sendKeys("rahul");
            driver.findElement(By.name("inputPassword")).sendKeys(password);
            driver.findElement(By.className("signInBtn")).click();
            Thread.sleep(2000);
            System.out.println(driver.findElement(By.tagName("p")).getText());
        try{
            Assert.assertEquals((driver.findElement(By.tagName("p")).getText()),"You are successfully logged in.");
            driver.findElement(By.xpath("//button[text()='Log Out']"));
            driver.close();
        }
       finally {
           // driver.close();
            driver.quit();
        }

    }


}
