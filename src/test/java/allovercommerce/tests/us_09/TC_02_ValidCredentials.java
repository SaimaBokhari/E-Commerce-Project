package allovercommerce.tests.us_09;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.pages.VendorPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TC_02_ValidCredentials {
    /*
When
    Registered User goes to "https://allovercommerce.com
And
   User clicks on the Register link
And
   User clicks on "Become a Vendor" option
And
    User enters registered email address
And
    Verify "Verification code sent to your email "abc@abc.com." should be visible.
And
    User enters the code received via email in the verification code text box. (Manually)
And
   User enters Valid password which contains uppercase, lowercase, digit and special char.
And
   User enters password in confirm password input.
And
   User clicks on the Register button.
Then
   Verify the message "This Email already exists. Please login to the site and apply as vendor.

     */
    HomePage homePage= new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    VendorPage vendorPage = new VendorPage();

    @Test
    public void TC_02_ValidCredentials(){
        // User is signed up.(TC_01 steps)

        //    User goes to "https://allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        //    User clicks on the Register link
        homePage.registerOption.click();

        // user clicks on "Become a Vendor"
        homePage.becomeAVendorOption.click();
        //    User enters registered email address
        vendorPage.emailInput.sendKeys(ConfigReader.getProperty("vendor_email"));
        ReusableMethods.waitFor(30);

        //    Verify "Verification code sent to your email "abc@abc.com." should be visible.
        assertTrue(vendorPage.verificationCodeMessage.isDisplayed());

        //    User enters the code received via email in the verification code text box. (Manually)
        ReusableMethods.waitFor(30);
        //vendorPage.codeInput.click();
        //   User enters valid password which contains uppercase, lowercase, digit and special char.
        vendorPage.passwordInput.sendKeys(ConfigReader.getProperty("vendor_password"));

        //   User enters password in confirm password input.
        vendorPage.confirmPasswordInput.sendKeys(ConfigReader.getProperty("vendor_password"));

        //   User clicks on the Register button.
        vendorPage.registerButton.click();

        //   Verify the message "This Email already exists. Please login to the site and apply as vendor."
        assertTrue(vendorPage.emailAlreadyExistMessage.isDisplayed());

    }
    @AfterMethod
    public void closeDriver(){
        ReusableMethods.waitFor(5);
        // Close the application
        Driver.closeDriver();
    }

}
