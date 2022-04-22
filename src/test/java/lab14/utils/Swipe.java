package lab14.utils;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class Swipe {
    final static int DEFAULT_PERCENTAGE = 50;
    /**
     * Swipe down with default percentage 50%
     * @param driver
     * @param windowSize
     */
    public static void swipeDown(WebDriver driver, Dimension windowSize) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = DEFAULT_PERCENTAGE * screenWidth / 100;
        int xEndPoint = DEFAULT_PERCENTAGE * screenWidth / 100;

        int yStartPoint = 0;
        int yEndPoint = DEFAULT_PERCENTAGE * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.longPress(startPoint);
        touchAction.moveTo(endPoint);
        touchAction.release();
        touchAction.perform();

    }

    /**
     * Swipe down with percentage
     * @param driver
     * @param windowSize
     * @param percentage
     */
    public static void swipeDown(WebDriver driver, Dimension windowSize, int percentage) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = percentage * screenWidth / 100;
        int xEndPoint = percentage * screenWidth / 100;

        int yStartPoint = 0;
        int yEndPoint = percentage * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.longPress(startPoint);
        touchAction.moveTo(endPoint);
        touchAction.release();
        touchAction.perform();

    }

    /**
     * Swipe up with default percentage 50%
     * @param driver
     * @param windowSize
     */
    public static void swipeUp(WebDriver driver, Dimension windowSize) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = DEFAULT_PERCENTAGE * screenWidth / 100;
        int xEndPoint = DEFAULT_PERCENTAGE * screenWidth / 100;

        int yStartPoint = DEFAULT_PERCENTAGE * screenHeight / 100;
        int yEndPoint = 0;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.longPress(startPoint);
        touchAction.moveTo(endPoint);
        touchAction.release();
        touchAction.perform();
    }

    /**
     * Swipe up with percentage
     * @param driver
     * @param windowSize
     * @param percentage
     */
    public static void swipeUp(WebDriver driver, Dimension windowSize, int percentage) {
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartPoint = percentage * screenWidth / 100;
        int xEndPoint = percentage * screenWidth / 100;

        int yStartPoint = percentage * screenHeight / 100;
        int yEndPoint = 0;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.longPress(startPoint);
        touchAction.moveTo(endPoint);
        touchAction.release();
        touchAction.perform();
    }
}
