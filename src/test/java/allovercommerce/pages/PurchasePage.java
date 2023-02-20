package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {
    public PurchasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "billing_first_name")
    public WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    public WebElement lastNameInput;

    @FindBy(id = "select2-billing_country-container")
    public WebElement countryDropdown;

    @FindBy(name = "billing_address_1")
    public WebElement streetAddressInput;

    @FindBy(id = "billing_city")
    public WebElement cityInput;

    @FindBy(id = "select2-billing_state-container")
    public WebElement stateDropdown;

    @FindBy(id = "billing_postcode")
    public WebElement postCodeInput;

    @FindBy(id = "billing_phone")
    public WebElement phoneInput;

    @FindBy(id ="billing_email")
    public WebElement email;

    @FindBy(id = "place_order")
    public WebElement placeOrderButton;
}
