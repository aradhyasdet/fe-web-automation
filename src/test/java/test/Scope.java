package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Scope {

   public static void main(String args[]){
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       List<WebElement> elements = driver.findElements(By.tagName("a"));
       System.out.println("All links->>"+elements.size());
       WebElement footer = driver.findElement(By.xpath("//table[@class='gf-t']//tbody/tr[1]/td[1]"));
       List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
       System.out.println("footer links->>"+footerLinks.size());
       int n = driver.findElements(By.xpath("//table[@class='gf-t']//tbody/tr[1]/td[1]/ul/li[@class='gf-li']/a")).size();
       String[] urlList = {"https://www.restapitutorial.com/","https://www.soapui.org/","https://courses.rahulshettyacademy.com/p/appium-tutorial","https://jmeter.apache.org/"};
       for(int i=0;i<n;i++){
           String links =  Keys.chord(Keys.CONTROL,Keys.ENTER);
           driver.findElements(By.xpath("//table[@class='gf-t']//tbody/tr[1]/td[1]/ul/li[@class='gf-li']/a")).get(i).sendKeys(links);
           Set<String> listOfLinks = driver.getWindowHandles();
           String mainWindow = driver.getWindowHandle();
           for(String s : listOfLinks) {
               if (!s.equals(mainWindow)) {
                   driver.switchTo().window(s);
                   String actualLinkURL = driver.getCurrentUrl();
                   if (actualLinkURL.equals(urlList[i])) System.out.println(i + "link is correct\n");
                   driver.close();
               }
           }
           driver.switchTo().window(mainWindow);
       }
       driver.quit();
   }
}
