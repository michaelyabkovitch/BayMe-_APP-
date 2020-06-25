import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class HowToSendScreen {
//this function will click on the "Button immediately after payment"
    protected static void presRadioButton (AndroidDriver<MobileElement> driver){
        Constant.findElementAndClick(Constant.NOW_RADIO_BUTTON_ID, driver);

    }
    //this function find the email check box and click it
    protected static void emailCheckBox (AndroidDriver<MobileElement> driver){
        List <MobileElement> elments = Constant.findAndReturnElements(Constant.CHECK_BOX_ID,driver);
        MobileElement emailCheckBox = elments.get(2) ;
        emailCheckBox.click();

    }
    //this will fill the email and click  Continued
    protected static void enterEmail(AndroidDriver<MobileElement> driver){
        MobileElement email = Constant.findAndReturnElement(Constant.ENTER_EMAIL_ID,driver);
        email.sendKeys("sdfsdf@sdfsdf.com");
        Constant.findElementAndClick(Constant.CONTINUED_BUTTON_ID, driver);


    }
}
