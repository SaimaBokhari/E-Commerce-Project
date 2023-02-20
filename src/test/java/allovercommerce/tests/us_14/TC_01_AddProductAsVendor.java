package allovercommerce.tests.us_14;

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

import java.util.List;

public class TC_01_AddProductAsVendor {
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    VendorPage vendorPage = new VendorPage();
    HomePage homePage = new HomePage();

    @Test
    public void addProductAsVendorTest(){
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

        storeManagerPage.addNewProduct.click();

        //*************************************************************************
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


        //*************************************************************************

        //There should be Simple Product, Variable Product, Grouped Product, External - Affiliate Product options.


        Select select3 = new Select(storeManagerPage.productsDropdown);
        List<WebElement> listOfProducts = select3.getOptions();
        String products="";
        for (WebElement w : listOfProducts){
            products = products + w.getText();
        }
        Assert.assertEquals("Simple ProductVariable ProductGrouped ProductExternal/Affiliate Product",products);


        //*************************************************************************

        //        Categories should be selectable.
        ReusableMethods.waitFor(2);
        for (WebElement w : storeManagerPage.categoriesCheckboxList){
            if (!w.isSelected()){
                JSUtils.clickElementByJS(w);
                Assert.assertTrue(w.isSelected());
            }

        }

        JSUtils.clickElementByJS(storeManagerPage.addNewCategoryButton);
        storeManagerPage.newCategoryInput.sendKeys("mamamaetaam");
        Select select1 = new Select(storeManagerPage.categoryDropdown);
        select1.selectByIndex(2);
        JSUtils.clickElementByJS(storeManagerPage.categoryFinalAddButton);


        //*************************************************************************


        //Product brands should be selectable.
        for (WebElement w : storeManagerPage.productBrandsList){
            if (!w.isSelected()){
                JSUtils.clickElementByJS(w);
                Assert.assertTrue(w.isSelected());
            }

        }





        //*************************************************************************


        //Vendor should be able to write a Product Title, Short Description and Description
        storeManagerPage.productTitleInput.sendKeys("Chess");


        Driver.getDriver().switchTo().frame(storeManagerPage.firstIframe);
        storeManagerPage.descriptionInput.sendKeys("Usable");
        Driver.getDriver().switchTo().parentFrame();

        Driver.getDriver().switchTo().frame(storeManagerPage.secondIFrame);
        storeManagerPage.secondDescription.sendKeys("Much Usable");
        Driver.getDriver().switchTo().parentFrame();

        storeManagerPage.priceInput.sendKeys("123");

        storeManagerPage.priceInput2.sendKeys("1213");



        JSUtils.clickElementByJS(storeManagerPage.finishButton);
//Assert the product added to products page

        JSUtils.clickElementByJS(storeManagerPage.productPageButton);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(storeManagerPage.chessProduct.isDisplayed());











    }
    @AfterClass
    public void tearDown() {
        Driver.getDriver().quit();
    }


}

