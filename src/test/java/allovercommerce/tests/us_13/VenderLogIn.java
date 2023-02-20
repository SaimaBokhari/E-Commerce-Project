package allovercommerce.tests.us_13;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VenderLogIn {
 /*
    Given
         https://allovercommerce.com/
    When
         User Sign in as vendor
    And
        User clicks on sig out button to back to My Account page
    And
        user verify its on My Account page
*/

    HomePage homePage= new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    @Test
    public void testCase1_Us13(){

        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        // choose Sign In button
        homePage.signIn.click();

        //   User enters email address

        homePage.userName.sendKeys(ConfigReader.getProperty("vendor_username"));

        //   User enters password
        homePage.password.sendKeys(ConfigReader.getProperty("vendor_password"));
        ReusableMethods.waitFor(1);

        // clicks on rememberMe box
        homePage.rememberMeCheckbox.click();

        // Logins into Vender account
        homePage.logIn.click();

        //user click on signout button to back to My Account page

        homePage.signOutButton.click();

        // user vefiry is on My Account page
        Assert.assertTrue(myAccountPage.myAccountPageExist.isDisplayed());


    }

}
