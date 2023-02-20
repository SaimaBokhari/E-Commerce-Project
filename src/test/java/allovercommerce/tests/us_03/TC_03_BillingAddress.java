package allovercommerce.tests.us_03;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TC_03_BillingAddress {
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
  Clicks on "Save Address" button
Then
  Verify that you added Address
And
  Close the browser
    */
    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    Faker faker = new Faker();

    String reg_username = faker.name().username();
    String reg_email = faker.internet().emailAddress();
    String reg_password = faker.internet().password(1,8);

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

        homePage.signOutButton.click();
        ReusableMethods.waitFor(3);
        homePage.confirmLogOutButton.click();
        ReusableMethods.waitFor(3);

        //    User enters username or email address
        homePage.userName.sendKeys(reg_username);
        ReusableMethods.waitFor(3);

        //    User enters password
        homePage.password.sendKeys(reg_password);
        ReusableMethods.waitFor(1);

        //   User clicks on "Remember Me" button
        JSUtils.clickElementByJS(homePage.rememberMeCheckbox);

        //   Clicks on "Sign In" button
        JSUtils.clickElementByJS(homePage.signInSubmitButton);
        ReusableMethods.waitFor(1);

//        =========================================================

        // Go to My Account page
        //   Clicks on User icon
        ReusableMethods.waitFor(3);
        //homePage.userIcon.click();

        //   Clicks on "Addresses" section
        myAccountPage.addressesButton.click();

        //   Clicks on "ADD" under "Billing Address"
        myAccountPage.addButtonForBillingAddress.click();

        //   User types first name
        myAccountPage.billingFirstName.sendKeys(faker.name().firstName());
        //   User enters last name
        myAccountPage.billingLastName.sendKeys(faker.name().lastName());

        //   User enters country/region
        ReusableMethods.waitFor(3);
        myAccountPage.billingCountryDropdown.click();
        myAccountPage.countryInputSection.sendKeys("turkey"+ Keys.ENTER);

        //   User enters street address
        myAccountPage.billingStreetAddress.sendKeys(faker.address().streetAddress());

        //   User enters town/city
        myAccountPage.billingCity.sendKeys(faker.address().cityName());

        //   User enters state
        myAccountPage.billingState.click();
        myAccountPage.billingState.sendKeys(faker.address().state());

        //   User enters ZIP Code
        myAccountPage.billingZipcode.sendKeys(faker.address().zipCode());

        // User enters Phone
        myAccountPage.billingPhone.sendKeys(faker.phoneNumber().cellPhone());

        //   Clicks on "Save Address" button
        myAccountPage.saveBillingAddress.click();
        //   Verify that you added Address
        assertTrue(myAccountPage.successMessage.isDisplayed());

    }
//    @AfterMethod
//    public void closeDriver(){
//        ReusableMethods.waitFor(5);
//        // Close the application
//        Driver.closeDriver();
//    }

}
