package allovercommerce.tests.us_03;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.security.Key;

import static org.testng.AssertJUnit.assertTrue;

public class TC_05_BillingAddressSaved {
    /*
Given
    User goes to "https://allovercommerce.com/”
And
  User is signed in
When
  Clicks on "Addresses" section
And
  Clicks on "ADD" under "Billing Address"
And
  User types first name
And
  User enters last name
And
  User enters country/region
And
  User enters street address
And
  User enters town/city
And
  User enters state
And
  User enters ZIP Code
And
  User enters Phone
And
   Confirms registered email address is filled in automatically.
And
   User clicks on "Save Address" option
Then
  Verify that Billing Address is successfully saved

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
        ReusableMethods.waitFor(10);  // Hard wait
        homePage.registerOption.click();
        ReusableMethods.waitFor(3);
        homePage.reg_username.sendKeys(reg_username);
        ReusableMethods.waitFor(3);
        homePage.reg_email.sendKeys(reg_email);
        ReusableMethods.waitFor(3);
        homePage.reg_password.sendKeys(reg_password);
        ReusableMethods.waitFor(3);
        homePage.registerPolicy.click();
        ReusableMethods.waitFor(3);
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

        //   User types first name
        ReusableMethods.waitFor(3);
        myAccountPage.billingFirstName.sendKeys(faker.name().firstName());
        assertTrue(myAccountPage.billingFirstName.isDisplayed());
        //   User enters last name
        ReusableMethods.waitFor(3);
        myAccountPage.billingLastName.sendKeys(faker.name().lastName());
        assertTrue(myAccountPage.billingLastName.isDisplayed());
        ReusableMethods.waitFor(5);

        //   User enters country/region
        JSUtils.scrollIntoViewJS(myAccountPage.billingCountryDropdown);
        ReusableMethods.waitFor(5);
        myAccountPage.billingCountryDropdown.click();

        ReusableMethods.waitFor(5);
        JSUtils.scrollIntoViewJS(myAccountPage.countryInputSectionForBilling);
        myAccountPage.countryInputSectionForBilling.sendKeys("United States"+ Keys.ENTER);


        //   User enters street address
        ReusableMethods.waitFor(5);
        myAccountPage.billingStreetAddress.sendKeys(faker.address().streetAddress());

        //   User enters town/city
        ReusableMethods.waitFor(5);
        myAccountPage.billingCity.sendKeys(faker.address().cityName());

        //   User enters state
        ReusableMethods.waitFor(5);
        myAccountPage.billingState.click();
        myAccountPage.stateInputSectionForBilling.sendKeys(faker.address().state() + Keys.ENTER);
        ReusableMethods.waitFor(5);
        // assertTrue(myAccountPage.billingState.isDisplayed());

        //   User enters ZIP Code
        ReusableMethods.waitFor(5);
        myAccountPage.billingZipcode.sendKeys(faker.address().zipCode());
        ReusableMethods.waitFor(5);
        assertTrue(myAccountPage.billingZipcode.isDisplayed());

        // User enters Phone
        ReusableMethods.waitFor(5);
        myAccountPage.billingPhone.sendKeys(faker.phoneNumber().cellPhone());
        ReusableMethods.waitFor(5);
        assertTrue(myAccountPage.billingPhone.isDisplayed());

        //  Confirms that registered email address is filled in automatically.
        ReusableMethods.waitFor(5);
        // assertTrue(myAccountPage.billingEmailConfirmation.getAttribute("value").contains(reg_email));

        // User clicks on "Save Address" option
        ReusableMethods.waitFor(5);
        myAccountPage.saveBillingAddress.click();

        // Verify "Address" is saved successfully
        ReusableMethods.waitFor(5);
        String currentUrl = Driver.getDriver().getCurrentUrl();
        ReusableMethods.waitFor(3);
        Assert.assertEquals(currentUrl,"https://allovercommerce.com/my-account-2/edit-address/");

    }
    @AfterMethod
    public void tearDown(){
        // Close the application
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }

}
