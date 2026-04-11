package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args)
            throws IOException, URISyntaxException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Get all footer links
        List<WebElement> links =
                driver.findElements(By.cssSelector("li.gf-li a"));

        SoftAssert softAssert = new SoftAssert();

        for (WebElement link : links) {

            String url = link.getAttribute("href");

            // Skip invalid links
            if (url == null || url.isEmpty() || url.startsWith("javascript")) {
                continue;
            }

            // Create connection
            HttpURLConnection connection =
                    (HttpURLConnection) new URI(url).toURL().openConnection();

            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000); // avoid hanging
            connection.connect();

            int responseCode = connection.getResponseCode();

            System.out.println(url + " --> " + responseCode);

            // Assertion
            softAssert.assertTrue(
                    responseCode < 400,
                    "Broken link: " + link.getText() +
                            " | Code: " + responseCode
            );
        }

        // Assert all results
        softAssert.assertAll();

        driver.quit();
    }
}