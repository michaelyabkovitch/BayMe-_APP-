import atu.testrecorder.ATUTestRecorder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.TimeUnit;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MainTestRun  {

    private static AndroidDriver<MobileElement> driver;
    private static final ExtentReports extent = new ExtentReports();
    private static ExtentTest test;
    private static ATUTestRecorder recorder;

    @BeforeClass
    public static void setUp() throws IOException, ParserConfigurationException, SAXException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability("appPackage", ReadFromXML.getData("PECKAGE"));
        capabilities.setCapability("appActivity", ReadFromXML.getData("ACTIVITY"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ReadFromXML.getData("REPORT"));
        extent.attachReporter(htmlReporter);
        test=extent.createTest("Buyme","ff");


        extent.setSystemInfo("Envirmant","production");
        test.log(Status.INFO,"connecting driver");
        ((CanRecordScreen)driver).startRecordingScreen();






    }


    @AfterClass

    public static void afterClass() throws IOException {
        String base64String = ((CanRecordScreen)driver).stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath="C:\\Users\\micha\\IdeaProjects\\mobileProject\\VideoRecord\\"+ new Random() + ".avi";
        Path path = Paths.get(destinationPath);
        Files.write(path, data);

        extent.flush();
        driver.close();

    }

    @Test

    public void Test01_HomeScreen () throws IOException {

       HomeScreen.pickCategory(driver);
        test.info("pickCategory", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\mobileProject\\ScreenShot\\"+ new Random() )).build());
       HomeScreen.pickBuisness(driver);
        test.info("pickBuisness", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\mobileProject\\ScreenShot\\"+ new Random() )).build());
       HomeScreen.giftBudget(driver);
        test.info("giftBudget", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\mobileProject\\ScreenShot\\"+ new Random() )).build());
    }
    @Test
    public void Test02_SenderReceiverScreen() throws IOException {
        SenderReceiverIbformation.enterReceiverName(driver);
        test.info("enterReceiverName", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\mobileProject\\ScreenShot\\"+ new Random() )).build());
        SenderReceiverIbformation.enterBlessing(driver);
        test.info("enterBlessing", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\mobileProject\\ScreenShot\\"+ new Random() )).build());
        SenderReceiverIbformation.enterSenderName(driver);
        test.info("enterSenderName", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\mobileProject\\ScreenShot\\"+ new Random() )).build());
        SenderReceiverIbformation.presNextButton(driver );

    }
    @Test
    public void Test03_HowToSendScreen() throws IOException {
        HowToSendScreen.presRadioButton(driver);
        test.info("presRadioButton", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\mobileProject\\ScreenShot\\" + new Random())).build());
        HowToSendScreen.emailCheckBox(driver);
        test.info("emailCheckBox", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\mobileProject\\ScreenShot\\"+ new Random() )).build());
        HowToSendScreen.enterEmail(driver);
        test.info("enterEmail", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\mobileProject\\ScreenShot\\"+ new Random() )).build());

    }
/*
    @Test
    public void Test0401_Extras () throws IOException {
        Extras.Extra_SwipingGesture(driver);
    }
    @Test
    public void Test0402_Extras (){
        Extras.Extra_GetMostExpensiveGift(driver);
    }
    @Test
    public void Test0403_Extras () throws IOException {
        Extras.Extra_SettingScreen(driver);
    }
  */







    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
}
