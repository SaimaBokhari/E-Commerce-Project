package allovercommerce.tests.us_08;

import allovercommerce.pages.HomePage;
import allovercommerce.pages.PurchasePage;
import allovercommerce.pages.VendorPage;
import allovercommerce.pages.WishPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TC_01_AddItemsWishlist {
    HomePage homePage = new HomePage();
    VendorPage vendorPage = new VendorPage();
    WishPage wishPage = new WishPage();
    PurchasePage purchasePage= new PurchasePage();
    @Test
    public void testCase_08() {

        //    User goes to "https://allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        // User enters Credential
        vendorPage.signInOptions.click();
        vendorPage.usernameInput.sendKeys(ConfigReader.getProperty("username"));
        vendorPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));
        vendorPage.signInButton.click();

        //User goes product
        WebElement search =ReusableMethods.waitForClickablility(vendorPage.searchInput,10);
        ReusableMethods.waitFor(2);
        search.sendKeys("laptop",Keys.ENTER);

        //User add product to wishlist
        WebElement addWish =ReusableMethods.waitForVisibility(vendorPage.addWishList,10);
        JSUtils.clickElementByJS(addWish);

        //User goes to wishlist page
        vendorPage.wishlistLink.click();

        //User should see the item on the wishlist
        Assert.assertTrue(wishPage.itemOnWishList.isDisplayed());

        //The user should be able to view  the attributes of the items on their Wishlist.(QUICK VIEW)

        JSUtils.clickElementByJS(wishPage.quickViewButton);
        WebElement attributeOfProduct= ReusableMethods.waitForVisibility(wishPage.attributeOfProduct,10);
        Assert.assertTrue(attributeOfProduct.isDisplayed());
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(wishPage.exitButton);



        //The user should be able to add the items on their Wishlist to their cart and purchase.
        JSUtils.clickElementByJS(wishPage.addToCartButton);

        ReusableMethods.waitFor(1);
        wishPage.cartButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveByOffset(150,100).build().perform();

        JSUtils.clickElementByJS(wishPage.checkOutButton);
        purchasePage.firstNameInput.sendKeys("aslan");
        purchasePage.lastNameInput.sendKeys("aslan");

        purchasePage.streetAddressInput.sendKeys("bambam street");
        purchasePage.cityInput.sendKeys("bambam city");

        purchasePage.postCodeInput.sendKeys("123");
        purchasePage.phoneInput.sendKeys("123345");
        purchasePage.email.clear();
        purchasePage.email.sendKeys(ConfigReader.getProperty("email"));
        JSUtils.clickElementByJS(purchasePage.placeOrderButton);


    }
    @AfterClass
    public void tearDown() {
        Driver.getDriver().quit();
    }
}
