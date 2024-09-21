import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class FormTest {

    private static WebDriver driver;
    private static final String SUCCESS_MESSAGE = "×Success! The Form has been submitted successfully!.";
    private static final By NAME_FIELD = By.name("name");
    private static final By EMAIL_FIELD = By.name("email");
    private static final By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private static final By CHECKBOX = By.id("exampleCheck1");
    private static final By GENDER_DROPDOWN = By.id("exampleFormControlSelect1");
    private static final By DOB_FIELD = By.name("bday");
    private static final By SUBMIT_BUTTON = By.xpath("//input[@value='Submit']");
    private static final By SUCCESS_ALERT = By.cssSelector("div.alert-dismissible");
    private static final By STUDENT_RADIO = By.id("inlineRadio1");
    private static final By EMPLOYED_RADIO = By.id("inlineRadio2");
    private static final By GENDER_MALE = By.xpath("//select[@id='exampleFormControlSelect1']//option[1]");
    private static final By GENDER_FEMALE = By.xpath("//select[@id='exampleFormControlSelect1']//option[2]");

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://rahulshettyacademy.com/angularpractice/");

            String nameText = "Aradhya";
            String emailText = "abd@gmail.com";
            String passText = "12345";
            String genderValue = "Female";
            String dateOfBirth = "21-04-2000";
            boolean checkIce = true;
            String empStatus = "Employed";

            String output = formfillSubmit(nameText, emailText, passText, genderValue, dateOfBirth, checkIce, empStatus);
            System.out.println(output);

            Assert.assertEquals(output.replaceAll("\\n", "").trim(), SUCCESS_MESSAGE.trim());

        } finally {
            driver.quit();
        }
    }

    public static String formfillSubmit(String nameText, String emailText, String passText, String genderValue, String dateOfBirth, boolean checkIce, String empStatus) {
        fillInputField(NAME_FIELD, nameText);
        fillInputField(EMAIL_FIELD, emailText);
        fillInputField(PASSWORD_FIELD, passText);

        if (checkIce) {
            clickElement(CHECKBOX);
        }

        selectGender(genderValue);
        selectEmploymentStatus(empStatus);
        fillInputField(DOB_FIELD, dateOfBirth);
        clickElement(SUBMIT_BUTTON);

        return getElementText(SUCCESS_ALERT);
    }

    private static void fillInputField(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    private static void selectGender(String genderValue) {
        clickElement(GENDER_DROPDOWN);
        if (genderValue.equals("Male")) {
            clickElement(GENDER_MALE);
        } else {
            clickElement(GENDER_FEMALE);
        }
    }

    private static void selectEmploymentStatus(String empStatus) {
        if (empStatus.equals("Student")) {
            clickElement(STUDENT_RADIO);
        } else {
            clickElement(EMPLOYED_RADIO);
        }
    }

    private static void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private static String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }
}
