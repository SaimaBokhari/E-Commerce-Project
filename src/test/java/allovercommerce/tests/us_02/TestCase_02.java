package allovercommerce.tests.us_02;

import allovercommerce.pages.HomePage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class TestCase_02 {
    HomePage homePage;

    @Test

    public void US02_TC02UserRegistrationExistingEmail() {

        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        homePage = new HomePage();
        homePage.registerLink.click();
        homePage.usernameField.sendKeys("userfortesting");
        homePage.emailField.sendKeys(ConfigReader.getProperty("email"));
        homePage.passwordField.sendKeys(ConfigReader.getProperty("password"));
        homePage.privacyButton.click();
        homePage.registerButton2.submit();
        Assert.assertTrue(homePage.warningEmailMessage.isDisplayed());


    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
