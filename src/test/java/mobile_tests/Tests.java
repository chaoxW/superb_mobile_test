package mobile_tests;

import org.testng.annotations.Test;

public class Tests extends BaseClass {

    @Test
    public void addFoodToCart(){
        // open app and click continue button
        clickStartPageContinueButton();
        // if there is message to alert the old version of app click confirm button to continue
        clickConfirmButton();
        // validate the home page
        homePageValidation();
        // click main menu
        clickMainMenu();
        // click sub menu
        clickSubMenu();
        // the food to add to the cart
        getFoodName();
        // add the food to cart
        addToCart();
        // get the confirmation message
        getConfirmMessage();
    }
}
