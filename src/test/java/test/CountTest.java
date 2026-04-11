package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CountTest {

    public static void main(String args[]) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("xyz");
        //click on any button to logout to verify the ams token

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        /*List<WebElement> rows = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//tr"));

        String givenText = "Engineer";

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < rows.size(); i++) {

            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

            for (int j = 0; j < cols.size(); j++) {

                String currentText = cols.get(j).getText();

                if (givenText.equals(currentText)) {

                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i + 1); // row index (1-based)
                    temp.add(j + 1); // col index (1-based)

                    answer.add(temp);
                }
            }
        }

        System.out.println(answer);*/
        List<WebElement> rows = driver.findElements(By.xpath("(//table[@id='product'])[2]//tbody//tr"));
        int n = rows.size();
        int sum = 0;
        for(int i=0;i<n;i++){
            String num = rows.get(i).findElement(By.xpath(".//td[4]")).getText();
            sum= sum+Integer.parseInt(num);
        }
        String expectedSum = driver.findElement(By.className("totalAmount")).getText();
        String [] str = expectedSum.split(":");
        String sum1 = str[1].trim();
        Assert.assertEquals(sum,Integer.parseInt(sum1));
        driver.quit();
    }
}