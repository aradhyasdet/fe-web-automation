package test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.io.File;
import java.time.Duration;

public class Screenshots {

    public static void main(String args[]) {
        try {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://samsung.com");
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("D://Downloads//abcd.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
