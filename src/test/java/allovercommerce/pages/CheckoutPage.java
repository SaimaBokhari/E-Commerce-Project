package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public CheckoutPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']/h3")
    public WebElement billingDetail;

    @FindBy(id = "payment_method_bacs")
    public WebElement EFTRadioButton;

    @FindBy(id = "payment_method_cod")
    public WebElement payAtDoorRadioButton;

    @FindBy(id = "place_order")
    public WebElement placeOrder;
}
