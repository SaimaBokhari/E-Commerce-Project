package allovercommerce.tests.us_04;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.utilities.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_04_UserShouldAddShippingAddress {

    /*
        Given
            User goes to "https://allovercommerce.com/"
        When
            Click Sign In section
        And
            Registered User types username or email address
        And
            Registered User types password
        And
            Registered User click on "Remember Me" button
        And
            Click on "Sign In" button
        And
            Click on man icon
        And
            Click on "Addresses" section
        And
            Click on "ADD" under "Shipping Address"
        And
            Registered Users types first name
        And
            Registered Users types last name
        And
            Registered Users types country/region
        And
            Registered Users types street address
        And
            Registered Users types town/city
        And
            Registered Users types state
        And
            Registered Users types ZIP Code
        And
            Click on "Save Address" button
        Then
            Verify that you added Address
        And
            Close the application
      */

    HomePage homePage;
    MyAccountPage myAccountPage;
    Faker faker;

    @Test
    public void testCase04(){

        // User goes to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        ReusableMethods.waitForPageToLoad(10);

        // Click Sign In section
        homePage = new HomePage();
        homePage.signInButton.click();
        ReusableMethods.waitFor(1);

        // Registered User types username or email address
        homePage.username.sendKeys("vitoandolini");
        ReusableMethods.waitFor(1);

        // Registered User types password
        homePage.password.sendKeys("13265915248");
        ReusableMethods.waitFor(1);

        // Registered User click on "Remember Me" button
        homePage.rememberMe.click();
        ReusableMethods.waitFor(1);

        //  Click on "Sign In" button
        homePage.signInSubmitButton.click();
        ReusableMethods.waitFor(2);

        // Click on man icon
        JSUtils.clickElementByJS(homePage.myAccountSection);
        ReusableMethods.waitFor(2);

        // Click on "Addresses" section
        myAccountPage = new MyAccountPage();
        JSUtils.clickElementByJS(myAccountPage.addressSection);
        ReusableMethods.waitFor(3);

        // Click on "ADD" under "Shipping Address"
        JSUtils.clickElementByJS(myAccountPage.addButtonUnderShipping);
        ReusableMethods.waitFor(3);

        // Registered Users types first name
        faker = new Faker();
        myAccountPage.shippingFirstName.sendKeys(faker.name().firstName());
        ReusableMethods.waitFor(1);

        // Registered Users types last name
        myAccountPage.shippingLastName.sendKeys(faker.name().lastName());
        ReusableMethods.waitFor(1);

        // Registered Users types country/region
        myAccountPage.shippingCountry.click();
        myAccountPage.inputSection.sendKeys("turkey" + Keys.ENTER);
        ReusableMethods.waitFor(2);

        // Registered Users types street address
        myAccountPage.shippingStreetAddress.sendKeys(faker.address().streetAddress());
        ReusableMethods.waitFor(1);

        // Registered Users types ZIP Code
        myAccountPage.shippingPostCode.sendKeys(faker.address().zipCode());
        ReusableMethods.waitFor(1);

        // Registered Users types town/city
        myAccountPage.shippingCity.sendKeys(faker.address().cityName());
        ReusableMethods.waitFor(1);

        // Registered Users types state
        myAccountPage.shippingProvince.click();
        myAccountPage.inputSection2.sendKeys("Ankara" + Keys.ENTER);
        ReusableMethods.waitFor(6);

        // Click on "Save Address" button
        myAccountPage.saveAddressButton.click();
        ReusableMethods.waitFor(6);

        // Verify "Address changed successfully
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://allovercommerce.com/my-account-2/edit-address/");
    }

    @AfterMethod
    public void tearDown(){
        // Close the application
        Driver.closeDriver();
    }
}

