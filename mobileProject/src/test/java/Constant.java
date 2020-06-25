import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class Constant {

//this function will find element by constant id and click on it
    public static  void findElementAndClick(String string, AndroidDriver<MobileElement> driver ){
        driver.findElementByAndroidUIAutomator(string).click();


    }



//this function will find and return element
    public static MobileElement findAndReturnElement (String string, AndroidDriver<MobileElement> driver){
        return driver.findElementByAndroidUIAutomator(string);

    }
    //this function will find and return elements
    public static List<MobileElement> findAndReturnElements (String string, AndroidDriver<MobileElement> driver){
        return driver.findElementsByAndroidUIAutomator(string);

    }
    //this function will hide the keyborde
    public static void tryHideKeyborde(AndroidDriver<MobileElement> driver){
        try {
            driver.hideKeyboard();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    //home screen
    public static final String CATEGORY_ID = "new UiSelector().className(android.widget.RelativeLayout).index(15)";
    public static final String BUISNES_ID = "new UiSelector().className(android.widget.RelativeLayout).index(3)";
    public static final String GIFT_BUDGET_ID = "new UiSelector().resourceId(\"il.co.mintapp.buyme:id/priceEditText\")";
    public static final String PRESS_CHOICE_ID = "new UiSelector().resourceId(\"il.co.mintapp.buyme:id/purchaseButton\")";


    //sender & Receiver screen
    public static final String RECEIVER_ID = "new UiSelector().resourceId(\"il.co.mintapp.buyme:id/toEditText\")";
    public static final String BLESSING_ID = "new UiSelector().resourceId(\"il.co.mintapp.buyme:id/blessEditText\")";
    public static final String SENDER_ID = "new UiSelector().className(android.widget.EditText).resourceId(\"il.co.mintapp.buyme:id/userFrom\")";



    //how to send screen
    public static final String NOW_RADIO_BUTTON_ID = "new UiSelector().resourceId(\"il.co.mintapp.buyme:id/nowRadioButton\")";
    public static final String CHECK_BOX_ID = "new UiSelector().className(android.widget.CheckBox)";
    public static final String ENTER_EMAIL_ID = "new UiSelector().className(android.widget.EditText)";
    public static final String CONTINUED_BUTTON_ID = "new UiSelector().resourceId(\"il.co.mintapp.buyme:id/goNextButton\")";
}
