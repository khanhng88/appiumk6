package lab14.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import lab14.driver.DriverFactory;
import lab14.driver.Platforms;
import lab14.utils.Swipe;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.util.List;

public class HomeWork {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = null;
        try{
            driver = DriverFactory.getDriver(Platforms.android);

            //click btn Nav Forms
            MobileElement btnFormsNav =
                    driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc=\"Forms\"]"));
            btnFormsNav.click();

            //fill form
            MobileElement inputFieldElem = driver.findElement(MobileBy.AccessibilityId("text-input"));
            MobileElement inputTextResultElem = driver.findElement(MobileBy.AccessibilityId("input-text-result"));
            MobileElement switchElem = driver.findElement(MobileBy.AccessibilityId("switch"));
            MobileElement dropDownElem = driver.findElement(MobileBy.AccessibilityId("Dropdown"));

            inputFieldElem.sendKeys("Khanh");
            System.out.println("You have typed : " + inputTextResultElem.getText());

            if(switchElem.getText().contains("OFF")) {
                switchElem.click();
                System.out.println("You have turned switch ON");
            }else {
                switchElem.click();
                System.out.println("You have turned switch OFF");
            }

            dropDownElem.click();
            List<MobileElement> dropDownValueElems = driver.findElements(MobileBy.id("android:id/text1"));
            dropDownValueElems.get(new SecureRandom().nextInt(1,3)).click();
            System.out.println("You have selected dropdown value: " +
                    dropDownElem.findElement(MobileBy.className("android.widget.EditText")).getText());

            //swipe down
            Dimension screenSize = driver.manage().window().getSize();
            Swipe.swipeUp(driver, screenSize);

            MobileElement btnActive = driver.findElement(MobileBy.AccessibilityId("button-Active"));
            MobileElement btnInActive = driver.findElement(MobileBy.AccessibilityId("button-Inactive"));

            //click button Active
            btnActive.click();
            MobileElement btnAskMeLater = driver.findElement(MobileBy.id("android:id/button3"));


            System.out.println("You just clicked button " + btnAskMeLater.getText());
            btnAskMeLater.click();

            btnActive = driver.findElement(MobileBy.AccessibilityId("button-Active"));
            btnActive.click();
            MobileElement btnCancel = driver.findElement(MobileBy.id("android:id/button2"));
            System.out.println("You just clicked button " + btnCancel.getText());
            btnCancel.click();

            btnActive = driver.findElement(MobileBy.AccessibilityId("button-Active"));
            btnActive.click();
            MobileElement btnOK = driver.findElement(MobileBy.id("android:id/button1"));
            System.out.println("You just clicked button " + btnOK.getText());
            btnOK.click();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
