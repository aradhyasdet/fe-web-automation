package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Calender {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            // Open URL
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Expected date
            String day = "21";
            String month = "02";  // Always safer to use 2-digit format
            String year = "2027";

            // Click clear/reset button
            driver.findElement(By.xpath("//button[contains(@class,'clear-button')]")).click();

            // Locate inputs
            WebElement monthInput = driver.findElement(By.xpath("//input[@max='12']"));
            WebElement dayInput = driver.findElement(By.xpath("//input[@max='31']"));
            WebElement yearInput = driver.findElement(By.xpath("//input[@max='275760']"));

            // Clear existing values (important for React inputs)
            monthInput.clear();
            dayInput.clear();
            yearInput.clear();

            // Enter values
            monthInput.sendKeys(month);
            dayInput.sendKeys(day);
            yearInput.sendKeys(year);

            // Get actual values
            String actualMonth = monthInput.getAttribute("value");
            String actualDay = dayInput.getAttribute("value");
            String actualYear = yearInput.getAttribute("value");

            // Validation
            if (Integer.parseInt(actualMonth) == Integer.parseInt(month) &&
                    Integer.parseInt(actualDay) == Integer.parseInt(day) &&
                    Integer.parseInt(actualYear) == Integer.parseInt(year)) {

                System.out.println("✅ PASS - Date selected correctly");

            } else {
                System.out.println("❌ FAIL");
                System.out.println("Expected: " + month + "-" + day + "-" + year);
                System.out.println("Actual  : " + actualMonth + "-" + actualDay + "-" + actualYear);
            }

        } catch (Exception e) {
            System.out.println("❌ Exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}