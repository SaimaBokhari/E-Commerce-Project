package allovercommerce.tests.us_11;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.VendorPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_03VisibilityOfSideElements {


        /*
    Given
         User goes to "https://allovercommerce.com
     When
         User clicks on Sign In link
      And
         User enters email address into "email" input
      And
         User enters password into "email" input
      And
         User clicks on "Sign In" Button
      And
         User click on "Sing Out" link
      Then
          Verify that Store Manager, Orders, Downloads,Addresses, Account Details, Whishlist,
          Support Tickets,Followings and Logout should be visible on Dashboard

     */


    @Test
    public void visibilityOfSideElements() {

        //    User goes to "https://allovercommerce.com
        ReusableMethods.waitFor(3);
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        //    User clicks on Sign In link
        HomePage homePage = new HomePage();
        homePage.signInSection.click();

        //   User enters email address into "email" input
        homePage.username.sendKeys(ConfigReader.getProperty("vendor_email"));
        ReusableMethods.waitFor(1);

        //   User enters password into "email" input
        homePage.password.sendKeys(ConfigReader.getProperty("vendor_password"));
        ReusableMethods.waitFor(1);


        //   User clicks on "Sign In" Button
        homePage.signInButton.click();
        ReusableMethods.waitFor(5);


        // User click on "Sing Out" link
        homePage.signOut.click();
        ReusableMethods.waitFor(5);

        //   Verify that Store Manager, Orders, Downloads,Addresses, Account Details, Whishlist,
        //   Support Tickets,Followings and Logout should be visible on Dashboard


        VendorPage vendorPage = new VendorPage();
        ReusableMethods.waitFor(10);

        ReusableMethods.verifyElementDisplayed(vendorPage.storeManagerLink);
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(vendorPage.ordersLink);
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(vendorPage.downloadsLink);
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(vendorPage.addressesLink);
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(vendorPage.accountDetailsLink);
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(vendorPage.whishlistDashboardLink);
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(vendorPage.supportTicketsLink);
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(vendorPage.followingsLink);
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(vendorPage.logoutLink);
        ReusableMethods.waitFor(2);

    }
    @AfterMethod
    public void closeDriver2(){
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }

}



