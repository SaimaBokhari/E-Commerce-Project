package allovercommerce.tests.us_20;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.pages.StoreManagerPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_20_VendorShouldAddCoupon {

    /*
        Given
            User goes to "https://allovercommerce.com/"
        When
            Click on "Sign In" section
        And
            Vendor types his/her username or email
        And
            Vendor types his/her password
        And
            Click on "Remember Me" button
        And
            Click on "Sign In" button
        And
            Click on "My Account Section" and go to My Account section
        And
            Click on "Store Manager" section
        And
            Click on "Coupon" section
        And
            Click on "Add New" section
        And
            Vendor types code
        And
            Vendor types description
        And
            Vendor choose discount type
        And
            Vendor types coupon amount
        And
            Vendor determines expiry date
        And
            Vendor choose allow free shipping
        And
            Vendor choose show on store
        And
            Click on "Submit" button
        Then
	        Verify that coupon was created
        And
            Close the application
      */

    HomePage homePage;
    MyAccountPage myAccountPage;
    StoreManagerPage storeManagerPage;

    @Test
    public void testCase20(){
        // User goes to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        // Click on "Sign In" section
        homePage = new HomePage();
        homePage.signInButton.click();
        ReusableMethods.waitFor(2);

        // Vendor types his/her username or email
        homePage.username.sendKeys("mtkama2010@gmail.com");
        ReusableMethods.waitFor(1);

        // Vendor types his/her password
        homePage.password.sendKeys("km6476458gy");
        ReusableMethods.waitFor(1);

        // Click on "Remember Me" button
        homePage.rememberMe.click();
        ReusableMethods.waitFor(1);

        // Click on "Sign In" button
        homePage.signInSubmitButton.click();
        ReusableMethods.waitFor(2);

        // Click on small man icon and go to My Account section
        JSUtils.clickElementByJS(homePage.myAccountSection);
        ReusableMethods.waitFor(2);

        // Click on "Store Manager" section
        myAccountPage = new MyAccountPage();
        myAccountPage.storeManager.click();
        ReusableMethods.waitFor(2);

        // Click on "Coupon" section
        storeManagerPage = new StoreManagerPage();
        JSUtils.clickElementByJS(storeManagerPage.coupon);
        ReusableMethods.waitFor(2);

        // Click on "Add New" section
        JSUtils.clickElementByJS(storeManagerPage.addNewButton);
        ReusableMethods.waitFor(2);

        // Vendor types code
        storeManagerPage.codeInput.sendKeys("xyz123");
        ReusableMethods.waitFor(1);

        // Vendor types description
        storeManagerPage.descriptionInput.sendKeys("first coupon");
        ReusableMethods.waitFor(1);

        // Vendor choose discount type
        Select select = new Select(storeManagerPage.discountType);
        select.selectByIndex(1);
        ReusableMethods.waitFor(1);

        // Vendor types coupon amount
        storeManagerPage.couponAmount.sendKeys("5");
        ReusableMethods.waitFor(2);

        // Vendor determines expiry date
        storeManagerPage.expiryDate.sendKeys("2023-01-31");
        ReusableMethods.waitFor(2);

        // Vendor choose allow free shipping
        storeManagerPage.checkBox1.click();
        ReusableMethods.waitFor(2);

        // Vendor choose show on store
        storeManagerPage.checkBox2.click();
        ReusableMethods.waitFor(2);

        // Click on "Submit" button
        JSUtils.clickElementByJS(storeManagerPage.submitButton);
        ReusableMethods.waitFor(6);

        // Verify that coupon was created
        JSUtils.clickElementByJS(storeManagerPage.coupon);
        ReusableMethods.waitFor(10);
        ReusableMethods.verifyElementDisplayed(storeManagerPage.xyzCoupon);

    }

    // Close the application
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
