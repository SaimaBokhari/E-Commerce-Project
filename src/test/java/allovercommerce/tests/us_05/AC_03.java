package allovercommerce.tests.us_05;

import allovercommerce.pages.US_05_AccountDetailsPage;
import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.*;

import static allovercommerce.utilities.ReusableMethods.waitForPageToLoad;

public class AC_03 {
    HomePage homePage;
    MyAccountPage myAccountPage;
    US_05_AccountDetailsPage accountDetailsPage;

    @Test
    public void AC03_VerifyBiographySectionEditible() {
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

//User enters "Hello I am Ali Veli. I love shopping"
        accountDetailsPage=new US_05_AccountDetailsPage();
        Driver.getDriver().switchTo().frame(0);
        accountDetailsPage.biographySection.clear();
        accountDetailsPage.biographySection.sendKeys(ConfigReader.getProperty("EmreUserBiography"));

        waitForPageToLoad(10);
        Driver.getDriver().switchTo().defaultContent();
        accountDetailsPage.saveButton.click();
        waitForPageToLoad(10);

        Driver.getDriver().switchTo().frame(0);
        String biographyActual=accountDetailsPage.biographySection.getText();
        System.out.println("biographyActual = " + biographyActual);

        String biographyExpected=ConfigReader.getProperty("EmreUserBiography");
        System.out.println("biographyExpected = " + biographyExpected);

        Assert.assertTrue(biographyActual.equals(biographyExpected));

        Driver.closeDriver();
    }
}