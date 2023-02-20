package allovercommerce.tests.us_18;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.StoreManagerPage;
import allovercommerce.pages.VendorPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TC_01_Add_ExternalAffiliate_Product {
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    VendorPage vendorPage = new VendorPage();
    HomePage homePage = new HomePage();
    @Test
    public void addExternalAffiliateProductAsVendorTest() {

// Vendor goes to "https://allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        // Vendor enters Credential
        vendorPage.signInOptions.click();
        vendorPage.usernameInput.sendKeys(ConfigReader.getProperty("vendor_username"));
        vendorPage.passwordInput.sendKeys(ConfigReader.getProperty("vendor_password"));
        vendorPage.signInButton.click();


        //Vendor go to my account
        homePage.signOutButton.click();

        vendorPage.storeManager.click();

        storeManagerPage.productPageButton.click();

        // Vendor takes the URL from existing product
        JSUtils.clickElementByJS(storeManagerPage.chessProduct);
        ReusableMethods.waitFor(2);

        String productUrl= Driver.getDriver().getCurrentUrl();

        System.out.println(productUrl);

        // Vendor goes to add a new external affiliate product
        Driver.getDriver().navigate().back();

        WebElement addProduct= ReusableMethods.waitForClickablility(storeManagerPage.addNewProduct,5);

        JSUtils.clickElementByJS(addProduct);

        // Choose the external affiliate

        Select select1 = new Select(storeManagerPage.productsDropdown);
        select1.selectByIndex(3);

        storeManagerPage.productURLInput.sendKeys(productUrl);

        storeManagerPage.productTitleInput.sendKeys("This is CHESS B");

        storeManagerPage.buttonTextInput.sendKeys("This is button text");

        Driver.getDriver().switchTo().frame(storeManagerPage.firstIframe);
        storeManagerPage.descriptionInput.sendKeys("Usable");
        Driver.getDriver().switchTo().parentFrame();

        Driver.getDriver().switchTo().frame(storeManagerPage.secondIFrame);
        storeManagerPage.secondDescription.sendKeys("Much Usable");
        Driver.getDriver().switchTo().parentFrame();

        storeManagerPage.priceInput.sendKeys("123");

        storeManagerPage.priceInput2.sendKeys("1213");


        //Vendor uploads a big photo.
        storeManagerPage.bigFuture.click();
        String userHome = System.getProperty("user.home");
        String pathOfFile = userHome +"\\Downloads\\chess_image.png";

        storeManagerPage.bigFutureUpload.sendKeys(pathOfFile);

        WebElement select = ReusableMethods.waitForClickablility(storeManagerPage.selectUpload,10);
        select.click();

        //Vendor uploads a small photo
        JSUtils.clickElementByJS(storeManagerPage.littlePicture);

        JSUtils.clickElementByJS(storeManagerPage.uploadFilePageButton);

        JSUtils.clickElementByJS(storeManagerPage.firstProduct);


        JSUtils.clickElementByJS(storeManagerPage.addToGallery);


        //Vendor press the submit button
        JSUtils.clickElementByJS(storeManagerPage.finishButton);

        JSUtils.clickElementByJS(storeManagerPage.productPageButton);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(storeManagerPage.chessProduct.isDisplayed());

    }
    @AfterClass
    public void tearDown() {
        Driver.getDriver().quit();
    }


}
