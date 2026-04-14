package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortingCheck {

    public static void main(String args[]){

        WebDriver  driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        WebElement sortIcon = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sort-descending"))
        );
        //sortIcon.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//tbody//tr//td[1]")
        ));
        List<String> priceOfProduct;
        do {
            //sortIcon.click(); //in order to check the failure
           List<WebElement> products = driver.findElements(By.xpath("//tbody//tr//td[1]"));
            //List<String> productList = products.stream().map(WebElement::getText).collect(Collectors.toList());
            priceOfProduct = products.stream().filter(s -> s.getText().trim().equalsIgnoreCase("Goku")).map(SortingCheck::getPrice).toList();
        /*for(WebElement e : products){
            productList.add(e.getText());
        }*/
        /*List<String> actualResult = productList.stream().sorted().toList();
        Assert.assertEquals(productList,actualResult);*/
            if(!priceOfProduct.isEmpty()){
                priceOfProduct.forEach(System.out::println);
                break;
            }
            if(priceOfProduct.isEmpty()){
                boolean isPresent = !driver.findElements(
                        By.xpath("//a[@aria-label='Next' and @aria-disabled='true']")
                ).isEmpty();

                if (isPresent) {
                    System.out.println("ElementNotFound");
                    break;
                } else {
                    driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
                }
            }
        }
        while(priceOfProduct.isEmpty());
        driver.quit();
    }

    public static String getPrice(WebElement s){
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }


}
