package lab14.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {

    public static AppiumDriver<MobileElement> getDriver(Platforms platform) {
        if(platform==null) {
            throw new IllegalArgumentException("Platform is null");
        }
        AppiumDriver<MobileElement> appiumDriver = null;
        //desire caps
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(UDID, "emulator-5554");
            desiredCapabilities.setCapability(APP_PACKAGE, "com.wdiodemoapp");
            desiredCapabilities.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");

            //init appium session
            URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
            switch (platform){
                case android:
                    appiumDriver = new AndroidDriver<MobileElement>(appiumServerURL, desiredCapabilities);
                    break;
                case ios:
                    appiumDriver = new IOSDriver<MobileElement>(appiumServerURL, desiredCapabilities);


            }

        } catch (Exception exception) {

        }
        if (appiumDriver == null) {
            throw new RuntimeException("appium driver is null");
        }

        //add implicit waits
        //default timeout = 500ms
        appiumDriver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
        return appiumDriver;
    }

}
