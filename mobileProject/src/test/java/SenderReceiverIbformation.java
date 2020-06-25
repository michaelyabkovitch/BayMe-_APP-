import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SenderReceiverIbformation {

    //this function will enter receiver name
    protected static void enterReceiverName(AndroidDriver<MobileElement> driver){
       MobileElement element =  Constant.findAndReturnElement(Constant.RECEIVER_ID, driver);
       element.sendKeys("Bruce Wayne");
    }
    //this function will enter a blessing
    protected static void enterBlessing(AndroidDriver<MobileElement> driver){
        MobileElement element =  Constant.findAndReturnElement(Constant.BLESSING_ID, driver);
        element.sendKeys("Hope the corona didn't completely ruin your sense of taste");

    }
    //this function will enter sender name
    protected static void enterSenderName(AndroidDriver<MobileElement> driver){
        MobileElement element =  Constant.findAndReturnElement(Constant.SENDER_ID, driver);
        element.sendKeys("Michael");

    }
    //this function will roll to the "next" button and press it
    protected static void presNextButton(AndroidDriver<MobileElement> driver){
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/goNextButton\"))")).click();



    }



}
