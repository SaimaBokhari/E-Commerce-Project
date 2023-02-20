package allovercommerce.tests.us_01;

import allovercommerce.pages.HomePage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_01SignUpPositive {

          /*
            When
                User goes to "https://allovercommerce.com
            And
                User clicks on the Register link
            And
               User enters Username into "Username" input
            And
               User enters email address into "Email" input
            And
               User enters password into "Password" input
            And
                User clicks on the "I agree" checkbox
            And
               User clicks on "Sign Up" Option
            Then
               Verify that user is signed up successfully

     */

    @Test
    public void US_01_signUpPositive(){

        //User goes to https://allovercommerce.com/
        ReusableMethods.waitFor(20);
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        HomePage homePage = new HomePage();
        Faker faker = new Faker();

        // User clicks on Register link
        homePage.register.click();

        // Enter username into "Username" input
        homePage.usernameReg.sendKeys(faker.name().firstName());

        // Enter email  into "Email" input
        homePage.emailReg.sendKeys(faker.internet().emailAddress());

        // Enter password into "Password" input
        homePage.passwordReg.sendKeys(faker.internet().password());

        // User clicks on the checkbox
        homePage.checkBox.click();

        // User clicks on Sign Up button
        homePage.signUp.click();

        // Verify that user is signed up
        Assert.assertTrue(homePage.signOut.isDisplayed());
    }

    @AfterMethod
    public void closeDriver1(){
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }
}

