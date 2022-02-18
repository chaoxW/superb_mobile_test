package mobile_tests;

import Pages.HomePage;
import Pages.StartPage;
import Pages.SubMenuPage;
import config.AppData;
import config.MobileData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass extends Utils {

    static AppiumDriver<MobileElement> driver;

    StartPage startPage = new StartPage();
    String continueButtonLocator = startPage.continueButton_Id;
    String confirmButtonLocator = startPage.confirmButton_Id;
    HomePage homePage = new HomePage();
    String homePageLogoLocator = homePage.HomePageLogo_Id;
    String homePageValidation = homePage.HomePageValidation;
    String homePageMainMenuLocator = homePage.MainMenu_Xpath;
    SubMenuPage subMenuPage = new SubMenuPage();
    String subMenuLocator = subMenuPage.SubMenu_Xpath;
    String subMenuFoodLocator = subMenuPage.SubMenuFood_Xpath;
    String addToCartLocator = subMenuPage.AddToCart_Xpath;
    String confirmationMessageLocator = subMenuPage.ConfirmationMessage_Id;
    MobileData mobileData = new MobileData();
    String mobileUuid = mobileData.Mobile_UUID;
    String mobileDeviceName = mobileData.Mobile_DeviceName;
    String mobilePlatformName = mobileData.Mobile_PlatformName;
    String mobilePlatformVersion = mobileData.Mobile_PlatformVersion;
    AppData appData = new AppData();
    String appPackage = appData.AppPackage;
    String appActivity = appData.AppActivity;
    String baseUrl = appData.Url;
    Utils utils = new Utils();

    @BeforeTest
    public void setup() {
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability(MobileCapabilityType.UDID, mobileUuid);
//        cap.setCapability(MobileCapabilityType.DEVICE_NAME, mobileDeviceName);
//        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, mobilePlatformName);
//        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobilePlatformVersion);
//        cap.setCapability("appPackage", appPackage);
//        cap.setCapability("appActivity", appActivity);
//
//        URL url = null;
//        try {
//            url = new URL(baseUrl);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        driver = new AndroidDriver<MobileElement>(url, cap);
//        System.out.println("Application started.........");
        utils.setup();
    }

    @AfterTest
    public void teardown() {
//        driver.quit();
        utils.QuitDriver();
    }

    public void clickStartPageContinueButton() {
        // click continue button
        try {
//                MobileElement continueButton = driver.findElement(By.id(continueButtonLocator));
                MobileElement continueButton = utils.GetElementById(continueButtonLocator);
                continueButton.click();
                System.out.println("\n click continue button ");
        } catch (Exception exp) {
            System.out.println("start page continue button ERROR " + exp.getCause());
            System.out.println("start page continue button ERROR " + exp.getMessage());
        }
    }

    public void clickConfirmButton() {
        // click confirm button
//        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            MobileElement confirmButton = utils.WaitGetElementById(confirmButtonLocator);
            confirmButton.click();
            System.out.println("\n click confirm button ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("click confirm button ERROR " + e.getCause());
            System.out.println("click confirm button button ERROR " + e.getMessage());
        }
//        try{
//            boolean confirmButtonIsVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(confirmButtonLocator)));
//            if (Boolean.TRUE.equals(confirmButtonIsVisible)) {
//                driver.findElement(By.id(confirmButtonLocator)).click();
//                MobileElement confirmButton = utils.GetElementById(confirmButtonLocator);
//                confirmButton.click();
//                System.out.println("\n click confirm button ");
//            }
//        }catch (Exception exp) {
//            System.out.println("click confirm button ERROR " + exp.getCause());
//            System.out.println("click confirm button button ERROR " + exp.getMessage());
//        }
    }

    public void homePageValidation() {
        // validate the home page
//        String homePageTitle = driver.findElement(By.id(homePageLogoLocator)).getText();
        String homePageTitle = null;
        try {
            MobileElement homePageTitleLogo = utils.GetElementById(homePageLogoLocator);
            homePageTitle = homePageTitleLogo.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (homePageTitle.equals(homePageValidation)) {
            System.out.println("\n Homepage title is " + homePageTitle);
        } else {
            System.out.println("\n It is not home page it is " + homePageTitle);
        }

    }

    public void clickMainMenu(){
        try{
//            MobileElement Menu = driver.findElement(By.xpath(homePageMainMenuLocator));
            MobileElement Menu = utils.GetElementByXpath(homePageMainMenuLocator);
            Menu.click();
            System.out.println("\n click main menu ");
        }
        catch (Exception exp){
            System.out.println("click main menu button ERROR " + exp.getCause());
            System.out.println("click main menu button ERROR " + exp.getMessage());
        }
    }

    public void clickSubMenu(){
        try{
//            MobileElement subMenu = driver.findElement(By.xpath(subMenuLocator));
            MobileElement subMenu = utils.GetElementByXpath(subMenuLocator);
            subMenu.click();
            System.out.println("\n click sub menu ");
        }
        catch (Exception exp){
            System.out.println("click sub menu button ERROR " + exp.getCause());
            System.out.println("click sub menu button ERROR " + exp.getMessage());
        }
    }

    public void getFoodName(){
        try{
//            MobileElement dishName = driver.findElementByXPath(subMenuFoodLocator);
            MobileElement dishName = utils.GetElementByXpath(subMenuFoodLocator);
            String dishNameText = dishName.getText();
            System.out.println("\n the food to add is " + dishNameText);
        }catch (Exception exp){
            System.out.println("get food name ERROR " + exp.getCause());
            System.out.println("get food name ERROR " + exp.getMessage());
        }
    }

    public void addToCart(){
        try{
//            MobileElement addToCart = driver.findElement(By.xpath(addToCartLocator));
            MobileElement addToCart = utils.GetElementByXpath(addToCartLocator);
            addToCart.click();
            System.out.println("\n add the food to cart ");
        }catch (Exception exp){
            System.out.println("add to cart ERROR " + exp.getCause());
            System.out.println("add to cart ERROR " + exp.getMessage());
        }
    }

    public void getConfirmMessage(){
        try{
            // the confirmation message
            MobileElement MessageDialog = utils.GetElementById(confirmationMessageLocator);
            String message = MessageDialog.getText();
//            String message = driver.findElement(By.id(confirmationMessageLocator)).getText();
            System.out.println("\n the message is " + message);
        }catch (Exception exp){
            System.out.println("add to cart ERROR " + exp.getCause());
            System.out.println("add to cart ERROR " + exp.getMessage());
        }
    }
}
