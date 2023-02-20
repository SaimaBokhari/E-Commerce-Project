package allovercommerce.tests.US_17;

import allovercommerce.pages.AddVariableProductPage;
import allovercommerce.pages.LoginPage;
import allovercommerce.pages.ShoppingPage;
import allovercommerce.tests.us_15.US_15_tests;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.JSUtils;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class VariableProductTest {

    Faker faker=new Faker();
    LoginPage loginPage=new LoginPage();
    ShoppingPage shoppingPage=new ShoppingPage();
    AddVariableProductPage addVaraiableProductPage=new AddVariableProductPage();
    Select select;
    US_15_tests us15=new US_15_tests();

    @Test
    public void TC01_variableProdTest() throws AWTException {

        us15.tc_01();

        // Select variable product from product dropdown
        Select selectProduct = new Select(addVaraiableProductPage.productSelectDropdown);
        selectProduct.selectByVisibleText("Variable Product");

        addVaraiableProductPage.productTitle.sendKeys("BArt Simpson");

        JSUtils.clickElementByJS(addVaraiableProductPage.featuredImage);

        //click on "media library "
        JSUtils.clickElementByJS(addVaraiableProductPage.mediaLibrary);

        //click on image
        JSUtils.clickElementByJS(addVaraiableProductPage.image);

        //click on select
        JSUtils.clickElementByJS(addVaraiableProductPage.select1);

        //click on gallery image
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(addVaraiableProductPage.galleryImage);

        //click on image
        JSUtils.clickElementByJS(addVaraiableProductPage.image2);

        //click on add to gallery button
        JSUtils.clickElementByJS(addVaraiableProductPage.addGalleryButton);

        //click on category checkbox
        JSUtils.clickElementByJS(addVaraiableProductPage.categoryCheckbox);

        //click on attributes
        JSUtils.clickElementByJS(addVaraiableProductPage.attributeButton);

        //click on color checkbox
        JSUtils.clickElementByJS(addVaraiableProductPage.colorCheckbox);

        //click on add new button to add color
        JSUtils.clickElementByJS(addVaraiableProductPage.addNewcolorButton);

        //send color keys to the alert
        Alert alertColor= Driver.getDriver().switchTo().alert();
        alertColor.sendKeys("ultraYellow color");
        alertColor.accept();

        //click on size checkbox
        JSUtils.clickElementByJS(addVaraiableProductPage.sizeCheckbox);

        //click on add new button to add size
        JSUtils.clickElementByJS(addVaraiableProductPage.addNewSizeButton);

        //send size key to the alert
        Alert alertSize= Driver.getDriver().switchTo().alert();
        alertSize.sendKeys("10w20hCm");
        alertSize.accept();

        //click on add attribute
        JSUtils.clickElementByJS(addVaraiableProductPage.addAttributeButton);

        //send keys to the attibute name field
        addVaraiableProductPage.attributeName.sendKeys("BArt Simpson dimensionAndColor");

        //click on product submit button
        addVaraiableProductPage.productSubmitButton.click();

        //click on Variations
        addVaraiableProductPage.variationsButton.click();
        ReusableMethods.waitFor(3);

        //click on any size to see the new dimensionn
        Select select = new Select(addVaraiableProductPage.anySizeDropdown);
        assertTrue("10w20hCm", addVaraiableProductPage.anySizeDropdown.isDisplayed());


    }
}

