package allovercommerce.tests.us_15;

import allovercommerce.pages.*;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class US_15_tests {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    OrderPage orderPage = new OrderPage();
    MyAccountVendorPage accountPage = new MyAccountVendorPage();
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    MyStorePage myStorePage = new MyStorePage();
    ProductsManagePage productsManagePage = new ProductsManagePage();
    Faker faker = new Faker();


    @Test
    public void tc_01() throws AWTException {
//        go my account page
        Driver.getDriver().get(ConfigReader.getProperty("my_account_url"));

//    enter username and password
        homePage.userName.sendKeys(ConfigReader.getProperty("yasin_username"));
        homePage.password.sendKeys(ConfigReader.getProperty("yasin_password"));

//    click sign in button
        JSUtils.clickElementByJS(accountPage.signInButton);

//    click store manager
        accountPage.storeManager.click();

//    clicks products
        ReusableMethods.waitFor(2);
        try {
            JSUtils.clickElementByJS(storeManagerPage.products);
        } catch (Exception e) {
        }

//      click add new
        myStorePage.addNewProduct.click();

//    test to Inventory, Shipping, Attributes, Linked, Seo, Wholesale product display settings, Advanced menus visibility
        assertTrue(productsManagePage.inventoryHead.isDisplayed());
        assertTrue(productsManagePage.shippingHead.isDisplayed());
        assertTrue(productsManagePage.attributeHead.isDisplayed());
        assertTrue(productsManagePage.linkedHead.isDisplayed());
        assertTrue(productsManagePage.seoHead.isDisplayed());
        assertTrue(productsManagePage.wholesaleHead.isDisplayed());
        assertTrue(productsManagePage.advanceHead.isDisplayed());
    }

    @Test
    public void tc_02() {
//    test to visibility of SKU
        assertTrue(productsManagePage.sku.isDisplayed());
        productsManagePage.sku.sendKeys("deneme");

//    click to Manage stock
        JSUtils.scrollIntoViewJS(productsManagePage.manageStock);
        JSUtils.clickElementByJS(productsManagePage.manageStock);

//    test to clickability Manage Stock
        assertTrue(productsManagePage.manageStock.isSelected());

//    select out of stock in stock status
        JSUtils.clickElementByJS(productsManagePage.stockStatus);

        Select select = new Select(productsManagePage.stockStatus);
        select.selectByIndex(2);

//    click to Sold Individually
        JSUtils.clickElementByJS(productsManagePage.soldIndividually);

//    test to clickability Sold Individually
        assertTrue(productsManagePage.soldIndividually.isSelected());
    }

    @Test
    public void tc_03() {
//    click to shipping
        JSUtils.clickElementByJS(productsManagePage.shippingHead);

//    test to Weight (kg) box visibilty
        assertTrue(productsManagePage.weight.isDisplayed());
        productsManagePage.weight.sendKeys("12");

//    test to lenght visibility
        assertTrue(productsManagePage.length.isDisplayed());
        productsManagePage.length.sendKeys("12");

//    test to width visibility
        assertTrue(productsManagePage.width.isDisplayed());
        productsManagePage.width.sendKeys("12");

//    test to height visibility
        assertTrue(productsManagePage.height.isDisplayed());
        productsManagePage.height.sendKeys("12");

//    test to shipping class visibility
        assertTrue(productsManagePage.shippingClass.isDisplayed());

//    select 1-2 weeks in Processing Time
        Select select = new Select(productsManagePage.processingTime);
        select.selectByIndex(2);

//    test to Processing Time
        assertTrue(productsManagePage.processingTime.isDisplayed());
    }

    @Test
    public void tc_04() {
//    click to Attributes
        JSUtils.clickElementByJS(productsManagePage.attributeHead);

//    click to open color menu
        JSUtils.clickElementByJS(productsManagePage.colorsCheckbox);

//    select color
        productsManagePage.colorInput.sendKeys("green" + Keys.ENTER);

        JSUtils.clickElementByJS(productsManagePage.selectAllColor);
        JSUtils.clickElementByJS(productsManagePage.selectNoneColor);
        JSUtils.clickElementByJS(productsManagePage.addNewColor);
        ReusableMethods.waitFor(2);

        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.sendKeys("Bart");
            alert.accept();
        } catch (Exception e) {
        }

//    click to Visible on the product page
        JSUtils.clickElementByJS(productsManagePage.visibleOnPageColor);

//    test to Visible on the product page is unclicked
        assertFalse(productsManagePage.visibleOnPageColor.isSelected());

//  -----------  click to open size menu    -----------
        JSUtils.clickElementByJS(productsManagePage.sizeCheckbox);

//    select XXL
        productsManagePage.sizeInput.sendKeys("XXL" + Keys.ENTER);
        JSUtils.clickElementByJS(productsManagePage.selectAllSize);
        JSUtils.clickElementByJS(productsManagePage.selectNoneSize);
        JSUtils.clickElementByJS(productsManagePage.addNewSize);

        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.sendKeys("Bart");
            alert.accept();
        } catch (Exception e) {
        }

//    click to Visible on the product page
        JSUtils.clickElementByJS(productsManagePage.visibleOnPageSize);

//    test to Visible on the product page is clicked
        assertFalse(productsManagePage.visibleOnPageSize.isSelected());

//      click to add attribute button
        JSUtils.clickElementByJS(productsManagePage.addAttributeButton);

//      test to new attribute name visibility
        assertTrue(productsManagePage.newAttributeName.isDisplayed());
    }

    @Test
    public void tc_05() {
//    click to linked
        JSUtils.clickElementByJS(productsManagePage.linkedHead);

//    select to calculator
        productsManagePage.upsellInput.sendKeys("calculator");
        ReusableMethods.waitFor(2);
        productsManagePage.upsellResult.click();

//    test to Up-sells visibility
        List<WebElement> uppsell = productsManagePage.upsellList;
        assertFalse(uppsell.isEmpty());

//    select to product (calculator)
        productsManagePage.crossSellInput.sendKeys("calculator");
        ReusableMethods.waitFor(2);
        productsManagePage.crossSellInputResult.click();

//    test to Cross-sells visibility
        List<WebElement> crosssell = productsManagePage.crossSellList;
        assertFalse(crosssell.isEmpty());
    }

    @Test
    public void tc_06() {
//    click to SEO
        JSUtils.clickElementByJS(productsManagePage.seoHead);

//    test to Enter a focus keyword visibility
        assertTrue(productsManagePage.focusKeyword.isEnabled());
//    enter data with faker
        productsManagePage.focusKeyword.sendKeys(faker.backToTheFuture().character());

//    test to Meta description visibility"
        assertTrue(productsManagePage.metaDisc.isEnabled());
        productsManagePage.metaDisc.sendKeys(faker.backToTheFuture().quote());

    }

    @Test
    public void tc_07() {
//    click to Wholesale Product
        JSUtils.clickElementByJS(productsManagePage.wholesaleHead);

//    select Piece Type from Piece Type
        Select select = new Select(productsManagePage.pieceType);
        select.selectByValue("Carton");

//    test to Units Per Piece visibility
        assertTrue(productsManagePage.unitPerCart.isEnabled());
//    enter data
        productsManagePage.unitPerCart.sendKeys(faker.backToTheFuture().character());

//    test to Min Order Quantity? visibility
        assertTrue(productsManagePage.minOrder.isEnabled());
//    Enter data
        productsManagePage.minOrder.sendKeys(faker.number().digits(2));
    }

    @Test
    public void tc_08() {
//    click to Advanced
        JSUtils.clickElementByJS(productsManagePage.advanceHead);

//    test to Enable reviews selected
        assertTrue(productsManagePage.enableReviews.isSelected());

//    test to Menu Order visibility
        assertTrue(productsManagePage.minOrder.isEnabled());

//    Enter data
        productsManagePage.menuOrders.sendKeys(faker.commerce().productName());

//    "test to Purchase Note box visibility"
        assertTrue(productsManagePage.purchase_note.isEnabled());

//    Enter data
        productsManagePage.purchase_note.sendKeys(faker.commerce().promotionCode());

    }

    @AfterClass
    public void tearDown() {
        Driver.getDriver().quit();
    }


}
