package allovercommerce.tests.us_02;

import allovercommerce.pages.HomePage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_01 {
    HomePage homePage;

    @Test
    public void US02_TC01UserRegistrationExistingUsername() {

        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        homePage = new HomePage();
        homePage.registerLink.click();
        homePage.usernameField.sendKeys(ConfigReader.getProperty("username"));
        homePage.emailField.sendKeys("userfortesting@gmail.com");
        homePage.passwordField.sendKeys(ConfigReader.getProperty("password"));
        homePage.privacyButton.click();
        homePage.registerButton2.submit();
        Assert.assertTrue(homePage.warningUsernameMessage.isDisplayed());


    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}
