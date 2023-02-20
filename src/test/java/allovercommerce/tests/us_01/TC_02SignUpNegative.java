package allovercommerce.tests.us_01;

import allovercommerce.pages.HomePage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_02SignUpNegative {

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
               User clicks on "Sign Up" Option
            Then
               Verify that user is NOT signed up

     */

    @Test
    public void US_01_signUpNegative(){ // without clicking on checkbox

        //User goes to https://allovercommerce.com/
        ReusableMethods.waitFor(10);
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        HomePage homePage = new HomePage();
        Faker faker = new Faker();

        // User clicks on Register link
        ReusableMethods.waitFor(2);
        homePage.register.click();

        // Enter username into "Username" input
        ReusableMethods.waitFor(2);
        homePage.usernameReg.sendKeys(faker.name().firstName());


        // Enter email  into "Email" input
        homePage.emailReg.sendKeys(faker.internet().emailAddress());
        ReusableMethods.waitFor(2);

        // Enter password into "Password" input
        homePage.passwordReg.sendKeys(faker.internet().password());
        ReusableMethods.waitFor(2);


        // User clicks on Sign Up button
        homePage.signUp.click();
        ReusableMethods.waitFor(2);

        // Verify that user is NOT signed up
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementNotDisplayed(homePage.signOut);
    }

    @AfterMethod
    public void closeDriver(){
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }
}
