package allovercommerce.tests.us_05;

import allovercommerce.pages.US_05_AccountDetailsPage;
import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.*;

import static allovercommerce.utilities.ReusableMethods.waitForPageToLoad;
public class AC_02 {
    HomePage homePage;
    MyAccountPage myAccountPage;
    US_05_AccountDetailsPage accountDetailsPage;

    @BeforeClass
    public void goToAccountDetailPage() {
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
    }

    @Test
    public void AC02_1_VerifyFirstNameEditible() {
        accountDetailsPage = new US_05_AccountDetailsPage();
        accountDetailsPage.firstName.clear();
        accountDetailsPage.firstName.sendKeys(ConfigReader.getProperty("EmresUserFirstName"));
        waitForPageToLoad(10);

        accountDetailsPage.saveButton.click();
        waitForPageToLoad(10);

        String firstNameActual = accountDetailsPage.firstName.getAttribute("value");
        System.out.println("firstNameActual = " + firstNameActual);
        String firsNameExpected = ConfigReader.getProperty("EmresUserFirstName");
        System.out.println("firsNameExpected = " + firsNameExpected);
        Assert.assertTrue(firstNameActual.equals(firsNameExpected));
    }

    @Test
    public void AC02_2_VerifyLastNameEditible() {
        accountDetailsPage = new US_05_AccountDetailsPage();
        accountDetailsPage.lastName.clear();
        accountDetailsPage.lastName.sendKeys(ConfigReader.getProperty("EmresUserLastName"));
        waitForPageToLoad(10);

        accountDetailsPage.saveButton.click();
        waitForPageToLoad(10);

        String lastNameActual = accountDetailsPage.lastName.getAttribute("value");
        System.out.println("lastNameActual = " + lastNameActual);
        String lastNameExpected = ConfigReader.getProperty("EmresUserLastName");
        System.out.println("lastNameExpected = " + lastNameExpected);
        Assert.assertTrue(lastNameActual.equals(lastNameExpected));
    }
    @Test
    public void AC02_3_VerifyDisplayNameEditible() {
        accountDetailsPage = new US_05_AccountDetailsPage();
        accountDetailsPage.displayName.clear();
        accountDetailsPage.displayName.sendKeys(ConfigReader.getProperty("EmresUserDisplayName"));
        waitForPageToLoad(10);

        accountDetailsPage.saveButton.click();
        waitForPageToLoad(10);

        String displayNameActual = accountDetailsPage.displayName.getAttribute("value");
        System.out.println("displayNameActual = " + displayNameActual);
        String displayNameExpected = ConfigReader.getProperty("EmresUserDisplayName");
        System.out.println("displayNameExpected = " + displayNameExpected);
        Assert.assertTrue(displayNameActual.equals(displayNameExpected));
    }


    @Test
    public void AC02_4_VerifyEmailEditible() {
        accountDetailsPage = new US_05_AccountDetailsPage();
        accountDetailsPage.email.clear();
        accountDetailsPage.email.sendKeys(ConfigReader.getProperty("EmresUseremailAdress"));
        waitForPageToLoad(10);

        accountDetailsPage.saveButton.click();
        waitForPageToLoad(10);

        String emailActual = accountDetailsPage.email.getAttribute("value");
        System.out.println("emailActual = " + emailActual);
        String emailExpected = ConfigReader.getProperty("EmresUseremailAdress");
        System.out.println("emailExpected = " + emailExpected);
        Assert.assertTrue(emailActual.equals(emailExpected));
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }

}
