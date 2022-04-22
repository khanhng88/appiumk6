package lab14.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import lab14.driver.DriverFactory;
import lab14.driver.Platforms;
import lab14.utils.Swipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarrowDownSearching {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = null;
        try {
            driver = DriverFactory.getDriver(Platforms.android);

            //swipe down to see notification panel
            Swipe.swipeDown(driver, driver.manage().window().getSize());

            Map<String, String> notifications = new HashMap<>();
            List<MobileElement> notificationElems =
                    driver.findElements(MobileBy.id("android:id/notification_main_column"));

            for (MobileElement notificationElem : notificationElems) {
                String notificationTitle = notificationElem.findElement(MobileBy.id("android:id/title")).getText();
                String notificationContent = notificationElem.findElement(MobileBy.id("android:id/big_text")).getText();
                notifications.put(notificationTitle, notificationContent);
            }

            if(notificationElems.isEmpty()) {
                throw new RuntimeException("The list notification is empty.");
            }else {
                for (String title : notifications.keySet()) {
                    System.out.println(title);
                    System.out.println(notifications.get(title));
                }
            }


        }catch (Exception exception){
            exception.printStackTrace();
        } finally {
            Swipe.swipeUp(driver, driver.manage().window().getSize());
            driver.quit();
        }
    }
}
