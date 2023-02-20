package allovercommerce.tests.us_16;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.pages.StoreManagerPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_16_VendorShouldAddSimpleProduct {
    /*
        Given
            User goes to "https://allovercommerce.com/"
        When
            Click on "Sign In" section
        And
            Vendor types his/her username or email
        And
            Vendor types his/her password
        And
            Click on "Remember Me" button
        And
            Click on "Sign In" button
        And
            Click on "My Account" button
        And
            Click on "Store Manager" section
        And
            Click on "Products" section
        And
            Click on "Add New" section
        And
            Vendor choose "Simple Product" from dropdown
        And
            Vendor choose "Virtual" and "Downloadable" checkboxes
        And
            Vendor types "Product Title"
        And
            Vendor types "Price"
        And
            Vendor types "Sale Price"
        And
            Vendor adds product picture
        And
            Vendor add galery picture
        And
	        Vendor choose "Categories"
        And
	        Vendor choose "Downloadable" section
	    And
	        Vendor types "Name"
	    And
	        Vendor types "File"
	    And
	        Vendor choose "Submit" button
	    Then
	        Verify "Product successfully published"
	*/

    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    Select select;

    @Test
    public void testCase16(){
        // User goes to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        // Click on "Sign In" section
        homePage.signInButton.click();
        ReusableMethods.waitFor(2);

        // Vendor types his/her username or email
        homePage.username.sendKeys("mtkama2010@gmail.com");
        ReusableMethods.waitFor(1);

        // Vendor types his/her password
        homePage.password.sendKeys("km6476458gy");
        ReusableMethods.waitFor(1);

        // Click on "Remember Me" button
        homePage.rememberMe.click();
        ReusableMethods.waitFor(1);

        // Click on "Sign In" button
        homePage.signInSubmitButton.click();
        ReusableMethods.waitFor(1);

        // Click on user icon section
        JSUtils.clickElementByJS(homePage.myAccountSection);
        ReusableMethods.waitFor(1);

        // Click on "Store Manager" section
        myAccountPage.storeManager.click();
        ReusableMethods.waitFor(2);

        // Click on "Products" section
        JSUtils.clickElementByJS(storeManagerPage.productsSection);
        ReusableMethods.waitFor(2);

        // Click on "Add New" section
        storeManagerPage.addNewButton.click();
        ReusableMethods.waitFor(2);

        // Vendor choose "Simple Product" from dropdown
        select = new Select(storeManagerPage.productType);
        select.selectByVisibleText("Simple Product");
        ReusableMethods.waitFor(2);

        // Vendor choose "Virtual" and "Downloadable" checkboxes
        storeManagerPage.virtualCheckBox.click();
        ReusableMethods.waitFor(2);

        storeManagerPage.downloadableCheckBox.click();
        ReusableMethods.waitFor(2);

        // Vendor types "Product Title"
        storeManagerPage.productTitle.sendKeys("Education");
        ReusableMethods.waitFor(2);

        // Vendor types "Price"
        storeManagerPage.price.sendKeys("1000");
        ReusableMethods.waitFor(2);

        // Vendor types "Sale Price"
        storeManagerPage.salePrice.sendKeys("1500");
        ReusableMethods.waitFor(2);

        // Vendor adds product picture
        storeManagerPage.picture.click();
        ReusableMethods.waitFor(2);

        storeManagerPage.mediaLibrary.click();
        ReusableMethods.waitFor(3);

        storeManagerPage.choosePicture.click();
        ReusableMethods.waitFor(3);

        JSUtils.clickElementByJS(storeManagerPage.selectSubmitButton);
        ReusableMethods.waitFor(2);

        // Vendor add galery picture
        storeManagerPage.galeryPicture.click();
        ReusableMethods.waitFor(2);

        storeManagerPage.chooseGalleryPicture.click();
        ReusableMethods.waitFor(2);

        storeManagerPage.addGaleryButton.click();
        ReusableMethods.waitFor(3);

        // Vendor choose "Categories"
        JSUtils.clickElementByJS(storeManagerPage.categories);
        ReusableMethods.waitFor(1);

        // Vendor choose "Downloadable" section
        JSUtils.clickElementByJS(storeManagerPage.downloadableSection);
        ReusableMethods.waitFor(1);

        // Vendor types "Name"
        storeManagerPage.nameInput.sendKeys("marcel");
        ReusableMethods.waitFor(1);

        // Vendor types "File"
        storeManagerPage.fileInput.sendKeys("C:\\Users\\SAMSUNG\\Desktop\\logo.jpeg");
        ReusableMethods.waitFor(3);

        // Vendor choose "Submit" button
        JSUtils.clickElementByJS(storeManagerPage.submitSectionButton);
        ReusableMethods.waitFor(5);

        // Verify "Product successfully published"
        storeManagerPage.productsSection.click();
        ReusableMethods.waitFor(3);

        ReusableMethods.verifyElementDisplayed(storeManagerPage.publishedSection);
    }
}