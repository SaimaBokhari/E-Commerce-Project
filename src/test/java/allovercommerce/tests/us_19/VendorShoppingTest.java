package allovercommerce.tests.us_19;

import allovercommerce.pages.LoginPage;
import allovercommerce.pages.ShoppingPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class VendorShoppingTest {

    Faker faker=new Faker();
    LoginPage loginPage=new LoginPage();
    ShoppingPage shoppingPage=new ShoppingPage();

    @Test
    public void vendorShoppingTest(){

        //Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        Driver.getDriver().get("https://allovercommerce.com/");
        ReusableMethods.waitFor(4);

//          Click on Sign In Button
        loginPage.signInIcon.click();


        //enter email as username in username input
        loginPage.usernameInput.sendKeys(ConfigReader.getProperty("username_"));


        //enter password in password input
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("password_"));


        //click on Sign In submit button
        loginPage.signInSubmitButton.click();
        ReusableMethods.waitFor(4);

        //click on Cart Button to go to Order Option
        shoppingPage.accountButton.click();
        ReusableMethods.waitFor(2);

        //Vendor clicks on Order button
        shoppingPage.orderButton.click();

        //vendor click on Browse Product
        //JSUtils.clickElementByJS(shoppingPage.browseProductButton);
        JSUtils.clickElementByJS(shoppingPage.goShopButton);

//        Vendor clicks on an item to add to cart
        shoppingPage.selectItemToBuy.click();
        ReusableMethods.waitFor(5);



//        Vendor clicks on ADD TO CART button to add the selected item
        JSUtils.clickElementByJS(shoppingPage.addToCartButton);
        ReusableMethods.waitFor(5);


//        Vendor clicks on CART button to see the added item
        JSUtils.clickElementByJS(shoppingPage.CartButton);
        ReusableMethods.waitFor(3);

//        Vendor clicks on CHECKOUT button to checkout
        JSUtils.clickElementByJS(shoppingPage.checkoutButton);

//        Vendor enters firstname in firstname input
        shoppingPage.billingFirstname.sendKeys(faker.name().firstName());

//        Vendor enters lastname in lastname input
        shoppingPage.billingLastname.sendKeys(faker.name().lastName());

//        Vendor selects COUNTRY/Region from country dropdown
        JSUtils.clickElementByJS(shoppingPage.billingCountryDropdown);


//        Vendor fills Street address field
        shoppingPage.billingStreetAddress.sendKeys(faker.address().streetAddress());

//        Vendor fills Town/City field
        shoppingPage.billingCity.sendKeys(faker.address().city());

//        Vendor selects State/Country
        JSUtils.clickElementByJS(shoppingPage.billingState);

//        Vendor fills ZipCode  field
        shoppingPage.billingZipcode.sendKeys("93945");

//        Vendor fills Phone  field
        shoppingPage.billingPhone.sendKeys("12244502030");

//        Vendor fills email  field if it is blank
//        shoppingPage.billing_email.sendKeys(faker.internet().emailAddress());

//        Vendor selects payment method (Pay at the door or Wire transfer/EFT)
        JSUtils.clickElementByJS(shoppingPage.payAtTheDoor);

//        Vendor clicks on PLACE ORDER button
        JSUtils.clickElementByJS(shoppingPage.placeOrder);

//        Verify the order is succesfully placed.  The message "Thank you. Your order has been received." must be seen.
        assertTrue(shoppingPage.orderReceivedMessage.isDisplayed());

    }
}
