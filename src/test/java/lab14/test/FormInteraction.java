package lab14.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import lab14.driver.DriverFactory;
import lab14.driver.Platforms;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormInteraction {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = null;
        try {
            //get appium driver
            driver = DriverFactory.getDriver(Platforms.android);

            //find and click on nav login button
            MobileElement btnNavLogin = driver.findElement(MobileBy.AccessibilityId("Login"));
            btnNavLogin.click();

            //fill in form
            MobileElement userNameElem = driver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passElem = driver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement btnLogin = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            userNameElem.sendKeys("a@mail.com");
            passElem.sendKeys("12345678");
            btnLogin.click();

            WebDriverWait wait = new WebDriverWait(driver, 5L);
            MobileElement alertDialogTitleElem = driver.findElement(MobileBy.id("android:id/alertTitle"));
            wait.until(ExpectedConditions.visibilityOf(alertDialogTitleElem));
            System.out.println("Title is " + alertDialogTitleElem.getText());
        }catch (Exception exception) {

        } finally {
            //quit appium session
            driver.quit();
        }
    }
}
