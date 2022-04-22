package lab14.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import lab14.driver.DriverFactory;
import lab14.driver.Platforms;

import java.util.List;

public class XpathLearning {

    public static void main(String[] args) {
        //get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            //find and click on nav login button
            MobileElement btnNavLogin = driver.findElement(MobileBy.AccessibilityId("Login"));
            btnNavLogin.click();

            //enter credentials
            List<MobileElement> credInputElems =
                    driver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int USER_NAME_INDEX = 0;
            final int PASS_INDEX = 1;
            MobileElement btnLogin = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            credInputElems.get(USER_NAME_INDEX).sendKeys("a@mail.com");
            credInputElems.get(PASS_INDEX).sendKeys("12345678");

            MobileElement loginInstructionElem =
                    driver.findElement
                            (MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"When the device\")"));
            System.out.println(loginInstructionElem.getText());
//            btnLogin.click();

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
