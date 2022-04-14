package lab14;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestLaunchApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver<MobileElement> driver = null;
        //desire caps
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("automationName","uiautomator2");
        desiredCapabilities.setCapability("udid","emulator-5554");
        desiredCapabilities.setCapability("appPackage","com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");

        //init appium session
        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(appiumServerURL,desiredCapabilities);
        Thread.sleep(3000);
        if(driver==null) {
            throw new RuntimeException("appium driver is null");
        }
        driver.quit();
    }
}
