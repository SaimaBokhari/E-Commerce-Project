package allovercommerce.tests.us_10;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.US_10_VendorRegisterPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.*;

import static allovercommerce.utilities.ReusableMethods.waitFor;
import static allovercommerce.utilities.ReusableMethods.waitForPageToLoad;

public class US10 {
    US_10_VendorRegisterPage US10VendorRegisterPage =new US_10_VendorRegisterPage();
    HomePage homePage;

    @BeforeClass
    public void goToVendorRegisterPage(){

        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        waitForPageToLoad(30);
        //User clicks on the "sign in" button in the upper right corner
        homePage=new HomePage();
        homePage.registerButton.click();
        waitForPageToLoad(15);
        //User clicks on the "Signup as a vendor?" button
        homePage.signUpAsAVendor.click();
        waitForPageToLoad(15);

    }

    @Test
    public void AC1_shortPassword(){

        //User enters a short password to the "Password" textbox
        US10VendorRegisterPage.password.clear();
        US10VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("EmreShortPassword"));
        waitFor(3);
        //Verify to there is "Too short"  under "Password" textbox
        String tooShort= US10VendorRegisterPage.passwordQuality.getText();
        System.out.println("tooShort = " + tooShort);
        Assert.assertTrue(tooShort.equals("Too short"));
        waitFor(3);
    }

    @Test
    public void AC2_weakPassword(){
        //User enters a short password to the "Password" textbox
        US10VendorRegisterPage.password.clear();
        US10VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("EmreWeakPassword"));
        waitFor(3);
        //Verify to there is "Weak"  under "Password" textbox
        String weakPassword= US10VendorRegisterPage.passwordQuality.getText();
        System.out.println("WeakPassword = " + weakPassword);
        Assert.assertTrue(weakPassword.equals("Weak"));
        waitFor(3);

    }
    @Test
    public void AC3_goodPassword(){
        //User enters a short password to the "Password" textbox
        US10VendorRegisterPage.password.clear();
        US10VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("EmreGoodPassword"));
        waitFor(3);
        //Verify to there is "Good"  under "Password" textbox
        String good= US10VendorRegisterPage.passwordQuality.getText();
        System.out.println("good = " + good);
        Assert.assertTrue(good.equals("Good"));
        waitFor(3);

    }
    @Test
    public void AC4_strongPassword(){
        //User enters a short password to the "Password" textbox
        US10VendorRegisterPage.password.clear();
        US10VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("EmreStrongPassword"));
        waitFor(3);
        //Verify to there is "Strong"  under "Password" textbox
        String strong= US10VendorRegisterPage.passwordQuality.getText();
        System.out.println("strong = " + strong);
        Assert.assertTrue(strong.equals("Strong"));
        waitFor(3);
    }

    @AfterClass
    public void tearDown(){
        //close the driver
        Driver.closeDriver();
        waitFor(10);
    }

}
