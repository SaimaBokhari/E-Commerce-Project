package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {
    public ShoppingPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='account']")
    public WebElement accountButton;

    @FindBy(xpath = "(//*[.='Orders'])[1]")
    public WebElement orderButton;

    @FindBy(xpath = "//*[.='Browse products']")
    public WebElement browseProductButton;

    @FindBy(xpath = "//*[.='Go Shop']")
    public WebElement goShopButton;


    @FindBy(xpath="(//*[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[2]")
    public WebElement selectItemToBuy;

    @FindBy(xpath="(//button[@type='submit'])[2]")
    public WebElement addToCartButton;

    @FindBy(xpath="(//*[@class='w-icon-cart'])[1]")
    public WebElement CartButton;

    @FindBy(xpath="//*[@class='button checkout wc-forward']")
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

    @FindBy(xpath = "//span[.='Order number']")
    public WebElement orderReceivedMessage;



}
