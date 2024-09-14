import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Functions {

    public static String getPassword(WebDriver driver) {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        WebElement element = driver.findElement(By.linkText("Forgot your password?"));
        element.click();
        try {
            Thread.sleep(1000);//
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception (e.g., log it)
        }
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String password = driver.findElement(By.cssSelector("form p")).getText();
        String[] passArray = password.split("'");
        return passArray[1].split("'")[0];
    }


}