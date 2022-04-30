package lesson17;

import context.Contexts;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import lab14.driver.DriverFactory;
import lab14.driver.Platforms;
import custom_explicit_wait.WaitMoreThanOneContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HybridContext {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
        try {

            MobileElement webViewNavBtn = driver.findElement(MobileBy.AccessibilityId("Webview"));
            webViewNavBtn.click();

            WebDriverWait wait = new WebDriverWait(driver, 5L);
            wait.until(new WaitMoreThanOneContext(driver));

            //get all context handles
            driver.getContextHandles().forEach(context -> {
                System.out.println(context);
            });

            //switch to webview context
            driver.context(Contexts.WEB_VIEW);

            //interact web elements
            WebElement toggleNavBtn = driver.findElementByCssSelector(".navbar__toggle");
            toggleNavBtn.click();
            List<MobileElement> menuItemElems = driver.findElementsByCssSelector(".menu__list li a");
            List<MenuItemData> menuItemDataList = new ArrayList<>();
            Map<String, String> menuItemDataMap = new HashMap<>();
            if(menuItemElems.isEmpty()) {
                throw new RuntimeException("The list is empty");
            }

            for (MobileElement menuItemElem : menuItemElems) {
                String menuItemName = menuItemElem.getText();
                String menuItemHref = menuItemElem.getAttribute("href");
                if (menuItemName.isEmpty()) {
                    menuItemDataList.add(new MenuItemData("Github", menuItemHref));
                    menuItemDataMap.put("Github", menuItemHref);
                } else {
                    menuItemDataList.add(new MenuItemData(menuItemName, menuItemHref));
                    menuItemDataMap.put(menuItemName, menuItemHref);
                }
            }

            menuItemDataList.forEach(menuItemData -> {
                System.out.println(menuItemData.getName());
                System.out.println(menuItemData.getHref());
            });
            System.out.println("=================================");
            menuItemDataMap.keySet().forEach(key -> {
                System.out.println(key);
                System.out.println(menuItemDataMap.get(key));
            });


        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            driver.quit();
        }
    }

    public static class MenuItemData {
        private String name;
        private String href;

        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }
    }
}
