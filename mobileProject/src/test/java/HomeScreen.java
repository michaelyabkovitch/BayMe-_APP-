import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreen {



//this function will pick a category
    protected static void pickCategory(AndroidDriver<MobileElement> driver){
        Constant.findElementAndClick(Constant.CATEGORY_ID,driver);

    }
    //this function will pick a Buisness
    protected static void pickBuisness(AndroidDriver<MobileElement> driver){
        Constant.findElementAndClick(Constant.BUISNES_ID,driver);

    }

//this function will set the budget and preess on the next button
    protected static void giftBudget(AndroidDriver<MobileElement> driver){
         MobileElement element = Constant.findAndReturnElement(Constant.GIFT_BUDGET_ID,driver);
         element.click();
         Constant.tryHideKeyborde(driver);
         element.sendKeys("500");
         Constant.findElementAndClick(Constant.PRESS_CHOICE_ID,driver);



    }


}
