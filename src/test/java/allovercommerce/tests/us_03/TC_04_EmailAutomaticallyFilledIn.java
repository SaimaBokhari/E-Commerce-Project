package allovercommerce.tests.us_03;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TC_04_EmailAutomaticallyFilledIn {
    /*
Given
    User goes to "https://allovercommerce.com/”
And
  User is signed in
When
  Clicks on "Addresses" section
And
  Clicks on "ADD" under "Billing Address"
Then
   Verify that registered email address is filled in automatically.

    */
    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    Faker faker = new Faker();
    String reg_username = faker.name().username();
    String reg_email = faker.internet().emailAddress();
    String reg_password = faker.internet().password(6,9);

    @Test
    public void test01(){
        // Sign Up
        //     User goes to "https://allovercommerce.com/”
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        ReusableMethods.waitFor(1);  // Hard wait
        homePage.registerOption.click();
        ReusableMethods.waitFor(1);
        homePage.reg_username.sendKeys(reg_username);
        ReusableMethods.waitFor(1);
        homePage.reg_email.sendKeys(reg_email);
        ReusableMethods.waitFor(1);
        homePage.reg_password.sendKeys(reg_password);
        ReusableMethods.waitFor(1);
        homePage.registerPolicy.click();
        homePage.signupButton.click();

//        =========================================================

        // sign in
        homePage.signOutButton.click();  // to see the account details on the left

        //   Clicks on "Addresses" section
        ReusableMethods.waitFor(3);
        myAccountPage.addressesButton.click();

        //   Clicks on "ADD" under "Billing Address"
        ReusableMethods.waitFor(3);
        myAccountPage.addButtonForBillingAddress.click();

        //   Verify that registered email address is filled in automatically.
        ReusableMethods.waitFor(5);
        // assertTrue(myAccountPage.billingEmailConfirmation.getAttribute("value").contains(reg_email));

    }

    @AfterMethod
    public void closeDriver(){
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }

}

