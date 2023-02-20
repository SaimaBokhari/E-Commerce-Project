package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_22_SelectingAndShop {
    public US_22_SelectingAndShop() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='account']")
    public WebElement accountButton;

    @FindBy(xpath = "(//*[.='Orders'])[1]")
    public WebElement orderButton;

    @FindBy(xpath = "//*[.='Go Shop']")
    public WebElement goShopButton;

    @FindBy(xpath="//div//li[2]")
    public WebElement selectItemToBuy;

    @FindBy(id="//button[@name='add-to-cart']")
    public WebElement addToCartButton;

    @FindBy(xpath="(//*[@class='w-icon-cart'])[1]")
    public WebElement CartButton;

    @FindBy(linkText="Checkout")
    public WebElement checkoutButton;




    @FindBy(id="billing_first_name")
    public WebElement billingFirstname;

    @FindBy(id="billing_last_name")
    public WebElement billingLastname;

    @FindBy(id="select2-billing_country-container")
    public WebElement billingCountryDropdown;

    @FindBy(id="billing_address_1")
    public WebElement billingStreetAddress;

    @FindBy(id="billing_city")
    public WebElement billingCity;

    @FindBy(id="select2-billing_state-container")
    public WebElement billingState;

    @FindBy(id="billing_postcode")
    public WebElement billingZipcode;

    @FindBy(id="billing_phone")
    public WebElement billingPhone;

    @FindBy(id="billing_email")
    public WebElement billing_email;



    @FindBy(id="payment_method_bacs")
    public WebElement wireTransferEFT;

    @FindBy(id="payment_method_cod")
    public WebElement payAtTheDoor;

    @FindBy(id="place_order")
    public WebElement placeOrder;

    @FindBy(linkText="Thank you. Your order has been received.")
    public WebElement orderReceivedMessage;

    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    public WebElement couponAddToCart;

    @FindBy(linkText = "CHECKOUT")
    public WebElement couponCheckout;

    @FindBy(xpath = "//a[@class='showcoupon']")
    public WebElement enterYourCode;

    @FindBy(id = "coupon_code")
    public WebElement typeCode;

    @FindBy(xpath = "//button[@name='apply_coupon']")
    public WebElement applyCoupon;

    @FindBy(xpath = "//span[@class='woocommerce-Price-amount amount']")
    public WebElement checkTotalPrice;

    @FindBy(xpath = "//tfoot/tr[2]/th")
    public WebElement couponText;

    @FindBy(xpath = "//a[@class='woocommerce-remove-coupon']")
    public WebElement removeCoupon;

}