package allovercommerce.tests.us_05;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static allovercommerce.utilities.ReusableMethods.*;

public class AC_01 {
    /*
 AC_01 User should be able to see Account Details.

   */
    HomePage homePage;
    MyAccountPage myAccountPage;

    @Test
    public void AC01_VerifyAccountDetailPageIsExist() {
//  going allovercommerce home page
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        waitForPageToLoad(15);

//  User clicks on the "sign in" button in the upper right corner
        homePage=new HomePage();
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
        Driver.getDriver().findElement(By.xpath("//a[@href='https://allovercommerce.com/my-account-2/edit-account/']")).click();
        //myAccountPage.accountDetails.click();//-->it doesnt work. why?
        waitForPageToLoad(15);
//User verify the url contains "edit-account"
        verifyElementDisplayed(By.xpath("//h4[@class='icon-box-title text-normal']"));

        Driver.closeDriver();

    }
}
