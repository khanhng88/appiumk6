package lesson17;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import lab14.driver.DriverFactory;
import lab14.driver.Platforms;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;

import java.io.File;

public class TakingScreenShot {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            MobileElement btnNavLogin = driver.findElement(MobileBy.AccessibilityId("Login"));
            btnNavLogin.click();

            //whole screen
            File base64ScreenShotData = driver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("HomeScreen.png");
            FileUtils.copyFile(base64ScreenShotData, new File(fileLocation));

            //an area
            MobileElement loginScreenElem = driver.findElement(MobileBy.AccessibilityId("Login-screen"));
            File base64LoginFormScreenShot = loginScreenElem.getScreenshotAs(OutputType.FILE);
            String loginFormFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginForm.png");
            FileUtils.copyFile(base64LoginFormScreenShot, new File(loginFormFileLocation));

            //an element
            MobileElement loginBtn = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File base64BtnLoginScreenShot = loginBtn.getScreenshotAs(OutputType.FILE);
            String btnLoginFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("btnLogin.png");
            FileUtils.copyFile(base64BtnLoginScreenShot, new File(btnLoginFileLocation));

        }catch (Exception exception) {

        }finally {
            driver.quit();
        }
    }
}
