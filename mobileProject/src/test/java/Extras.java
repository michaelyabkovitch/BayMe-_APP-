import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.io.IOException;
import java.time.Duration;

public class Extras {
    //this function will do a swipe to category

    protected static void Extra_SwipingGesture(AndroidDriver<MobileElement> driver) throws IOException {

        Runtime.getRuntime().exec("adb shell input touchscreen swipe 530 1820 530 1120");




    }
//this function will get the most expansive gifts
    protected static void Extra_GetMostExpensiveGift(AndroidDriver<MobileElement> driver){
        HomeScreen.pickCategory(driver);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"סינון תוצאות\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"300–₪499\")");

        swipe(26,860,820,860,2000,driver);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"מעל ₪1500\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"תמצאו לי מתנה\")").click();



    }
    //this function will go in to setting screen and  press on the by my button and then print the text
    protected static void Extra_SettingScreen(AndroidDriver<MobileElement> driver) throws IOException {
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/profileTab\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().className(android.widget.RelativeLayout).index(3).clickable(true)").click();

        MobileElement element =driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/titleText\").index(1)");
        String elementText = element.getText();
        System.out.println(elementText);
        element = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/contentText\").index(2)");
        String elementText2 = element.getText();
        System.out.println(elementText2);

    }

    private static  void swipe (int xFrom, int yFrom, int xTo, int yTo, int durationInMillis, AndroidDriver<MobileElement> driver) {
        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(xFrom, yFrom))
                .moveTo(PointOption.point(xTo, yTo))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationInMillis)))
                .release()
                .perform();
    }

}
