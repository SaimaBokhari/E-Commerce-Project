package allovercommerce.tests.us_05;

import allovercommerce.pages.US_05_AccountDetailsPage;
import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.pages.US_05_MyAccount_2Page;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.*;

import static allovercommerce.utilities.ReusableMethods.waitFor;
import static allovercommerce.utilities.ReusableMethods.waitForPageToLoad;

public class AC_04 {
    HomePage homePage;
    MyAccountPage myAccountPage;
    US_05_AccountDetailsPage accountDetailsPage;
    US_05_MyAccount_2Page US05MyAccount_2Page;


    /*public void goToAccountDetailPage() {
        //  going allovercommerce home page
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        waitForPageToLoad(15);

//  User clicks on the "sign in" button in the upper right corner
        homePage = new HomePage();
        homePage.signInButton.click();
        waitForPageToLoad(15);

//  User enters a valid e-mail adress to the ""Username or email
        homePage.userName.sendKeys(ConfigReader.getProperty("EmresUseremailAdress"));
//User enters a valid password to the "password" text box
        homePage.password.sendKeys(ConfigReader.getProperty("EmresUserPassword"));
//User clicks "Sing In" button
        homePage.signInSubmitButton.click();
        waitForPageToLoad(15);
//User clicks on the human icon in the upper right corner
        homePage.userIcon.click();
        waitForPageToLoad(15);
//User clicks on the "ACCOUNT DETAILS" in the dashboard
        myAccountPage = new MyAccountPage();
        myAccountPage.accountDetails.click();
        waitForPageToLoad(15);
    }*/

    @Test
    public void AC_4VerifyPassword() {
        //  going allovercommerce home page
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        waitForPageToLoad(15);

        //  User clicks on the "sign in" button in the upper right corner
        homePage = new HomePage();
        homePage.signInButton.click();
        waitForPageToLoad(15);

        //  User enters a valid e-mail adress to the ""Username or email
        homePage.userName.sendKeys(ConfigReader.getProperty("EmresUseremailAdress"));
        //User enters a valid password to the "password" text box
        homePage.password.sendKeys(ConfigReader.getProperty("EmresUserPassword"));
        //User clicks "Sing In" button
        homePage.signInSubmitButton.click();
        waitForPageToLoad(15);
        //User clicks on the human icon in the upper right corner
        homePage.userIcon.click();
        waitForPageToLoad(15);
        //User clicks on the "ACCOUNT DETAILS" in the dashboard
        myAccountPage = new MyAccountPage();
        myAccountPage.accountDetails.click();
        waitForPageToLoad(15);
        accountDetailsPage = new US_05_AccountDetailsPage();

        accountDetailsPage.currentPassword.sendKeys(ConfigReader.getProperty("EmresUserPassword"));
        accountDetailsPage.newPassword.sendKeys(ConfigReader.getProperty("EmresUserNewPassword"));
        accountDetailsPage.confirmPassword.sendKeys(ConfigReader.getProperty("EmresUserNewPassword"));

        accountDetailsPage.saveButton.click();
        waitForPageToLoad(10);

        accountDetailsPage.logoutButton.click();
        waitForPageToLoad(10);

        //  User clicks on the "user name" textbox
        US05MyAccount_2Page = new US_05_MyAccount_2Page();
        US05MyAccount_2Page.userName.sendKeys(ConfigReader.getProperty("EmresUseremailAdress"));
        //User enters a valid password to the "password" text box
        US05MyAccount_2Page.password.sendKeys(ConfigReader.getProperty("EmresUserNewPassword"));
        //User clicks "Sing In" button
        US05MyAccount_2Page.loginButton.click();
        waitForPageToLoad(5);

        //Verify you are signed in.
        Boolean signIn = Driver.getDriver().getTitle().contains("My Account");
        System.out.println("signIn = " + signIn);
        Assert.assertTrue(signIn);
        waitForPageToLoad(10);

        //After this part for changing password to beginning value. Soo we can use this test method again and again
        US05MyAccount_2Page = new US_05_MyAccount_2Page();
        US05MyAccount_2Page.accountDetails.click();
        waitForPageToLoad(10);
        accountDetailsPage = new US_05_AccountDetailsPage();

        accountDetailsPage.currentPassword.sendKeys(ConfigReader.getProperty("EmresUserNewPassword"));
        accountDetailsPage.newPassword.sendKeys(ConfigReader.getProperty("EmresUserPassword"));
        accountDetailsPage.confirmPassword.sendKeys(ConfigReader.getProperty("EmresUserPassword"));
        accountDetailsPage.saveButton.click();
        waitForPageToLoad(10);
        Driver.closeDriver();
        waitFor(5);

    }

}
