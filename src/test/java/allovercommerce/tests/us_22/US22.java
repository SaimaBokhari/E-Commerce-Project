package allovercommerce.tests.us_22;


import allovercommerce.pages.US_22_LoginPage;
import allovercommerce.pages.US_22_SelectingAndShop;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US22 {

    Faker faker=new Faker();
    US_22_LoginPage us_22_loginPage;
    US_22_SelectingAndShop us_22_selectingAndShop;

    @Test
    public void AC_01(){

//        Go to url https://www.allovercommerce.com/
        //Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        Driver.getDriver().get("https://allovercommerce.com/");

//          Click on Sign In Button
        us_22_loginPage=new US_22_LoginPage();
        us_22_loginPage.signInIcon.click();


        //enter email as username in username input
        us_22_loginPage.usernameInput.sendKeys(ConfigReader.getProperty("UC_19email"));


        //enter password in password input
        us_22_loginPage.passwordInput.sendKeys(ConfigReader.getProperty("UC-19password"));


        //click on Sign In submit button
        us_22_loginPage.signInSubmitButton.click();
        ReusableMethods.waitFor(5);


//        Vendor goes to a discountable product page
        Driver.getDriver().get(ConfigReader.getProperty("EmresDiscountableProductUrl"));
        ReusableMethods.waitFor(3);

//        Vendor clicks on ADD TO CART button to add the selected item
        us_22_selectingAndShop=new US_22_SelectingAndShop();
        us_22_selectingAndShop.couponAddToCart.click();
        ReusableMethods.waitFor(5);

//        Vendor clicks on CART button to see the added item
        us_22_selectingAndShop.CartButton.click();

//        Vendor clicks on CHECKOUT button to checkout
        us_22_selectingAndShop.couponCheckout.click();
        ReusableMethods.waitForPageToLoad(10);

//      Coupon Text is display before apply
        Boolean couponTextBeforeCoupon=us_22_selectingAndShop.couponText.isDisplayed();
        System.out.println("couponTextBeforeCoupon = " + couponTextBeforeCoupon);


//        Vendor clicks to "Enter your code" button
        us_22_selectingAndShop.enterYourCode.click();
        ReusableMethods.waitFor(2);

//       Vendor enters coupon code to the textbox
        us_22_selectingAndShop.typeCode.sendKeys(ConfigReader.getProperty("EmreCouponCode"));

//        Vendor clicks "Apply Coupon" button
        us_22_selectingAndShop.applyCoupon.click();
        ReusableMethods.waitFor(5);

//      Coupon Text is display before apply
        Boolean couponTextAfterCoupon=us_22_selectingAndShop.couponText.isDisplayed();
        System.out.println("couponTextAfterCoupon = " + couponTextAfterCoupon);

//       Verify if coupon get used
        Assert.assertTrue(couponTextAfterCoupon);


//      this code is for removing coupon. soo we can use this test again and again
        us_22_selectingAndShop.removeCoupon.click();
        ReusableMethods.waitForPageToLoad(10);

//       close the driver
        Driver.closeDriver();




    }
}