package allovercommerce.tests.us_03;

import allovercommerce.pages.HomePage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TC_01_Signup {
    HomePage homePage = new HomePage();
    Faker faker = new Faker();
    String reg_username = faker.name().username();
    String reg_email = faker.internet().emailAddress();
    String reg_password = faker.internet().password(1,8);


    public void signUp() {
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
    }

    @Test
    public void test01() {
        // Calls for Sign Up method
        ReusableMethods.waitFor(5);
        signUp();

        //   Verify that user is already signed up
        assertTrue(homePage.accountAlreadyExistMessage.isDisplayed());

    }
    @AfterMethod
    public void closeDriver(){
        ReusableMethods.waitFor(5);
        // Close the application
        Driver.closeDriver();
    }

}

