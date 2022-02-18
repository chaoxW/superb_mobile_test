package mobile_tests;

import Pages.HomePage;
import Pages.StartPage;
import Pages.SubMenuPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass extends Utils {

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
    Utils utils = new Utils();

    @BeforeTest
    public void setup() {
        utils.setup();
    }

    @AfterTest
    public void teardown() {
        utils.QuitDriver();
    }

    public void clickStartPageContinueButton() {
        try {
            MobileElement continueButton = utils.GetElementById(continueButtonLocator);
            continueButton.click();
            System.out.println("\n click continue button ");
        } catch (Exception exp) {
            System.out.println("start page continue button ERROR " + exp.getCause());
            System.out.println("start page continue button ERROR " + exp.getMessage());
        }
    }

    public void clickConfirmButton() {
        try {
            MobileElement confirmButton = utils.WaitGetElementById(confirmButtonLocator);
            confirmButton.click();
            System.out.println("\n click confirm button ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("click confirm button ERROR " + e.getCause());
            System.out.println("click confirm button button ERROR " + e.getMessage());
        }
    }

    public void homePageValidation() {
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

    public void clickMainMenu() {
        try {
            MobileElement Menu = utils.GetElementByXpath(homePageMainMenuLocator);
            Menu.click();
            System.out.println("\n click main menu ");
        } catch (Exception exp) {
            System.out.println("click main menu button ERROR " + exp.getCause());
            System.out.println("click main menu button ERROR " + exp.getMessage());
        }
    }

    public void clickSubMenu() {
        try {
            MobileElement subMenu = utils.GetElementByXpath(subMenuLocator);
            subMenu.click();
            System.out.println("\n click sub menu ");
        } catch (Exception exp) {
            System.out.println("click sub menu button ERROR " + exp.getCause());
            System.out.println("click sub menu button ERROR " + exp.getMessage());
        }
    }

    public void getFoodName() {
        try {
            MobileElement dishName = utils.GetElementByXpath(subMenuFoodLocator);
            String dishNameText = dishName.getText();
            System.out.println("\n the food to add is " + dishNameText);
        } catch (Exception exp) {
            System.out.println("get food name ERROR " + exp.getCause());
            System.out.println("get food name ERROR " + exp.getMessage());
        }
    }

    public void addToCart() {
        try {
            MobileElement addToCart = utils.GetElementByXpath(addToCartLocator);
            addToCart.click();
            System.out.println("\n add the food to cart ");
        } catch (Exception exp) {
            System.out.println("add to cart ERROR " + exp.getCause());
            System.out.println("add to cart ERROR " + exp.getMessage());
        }
    }

    public void getConfirmMessage() {
        try {
            MobileElement MessageDialog = utils.GetElementById(confirmationMessageLocator);
            String message = MessageDialog.getText();
            System.out.println("\n the message is " + message);
        } catch (Exception exp) {
            System.out.println("add to cart ERROR " + exp.getCause());
            System.out.println("add to cart ERROR " + exp.getMessage());
        }
    }
}
