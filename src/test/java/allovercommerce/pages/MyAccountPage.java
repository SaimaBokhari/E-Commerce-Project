package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public MyAccountPage(){  // Constructor

        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Sign up link
    @FindBy(partialLinkText = "Sign Up")
    public WebElement signupOption;

    // Locate elements by using any locator
    @FindBy(xpath = "//span[@class='icon-box-icon icon-addresses']")
    public WebElement addressSection;

    @FindBy(partialLinkText = "Addresses")
    public WebElement addressesButton;

    @FindBy(xpath = "(//a[.='Add'])[1]")
    public WebElement addButtonForBillingAddress;

    @FindBy(id = "billing_first_name")
    public WebElement billingFirstName;

    @FindBy(id = "billing_last_name")
    public WebElement billingLastName;

    @FindBy(id = "select2-billing_country-container")
    public WebElement billingCountryDropdown;

    @FindBy(id = "billing_address_1")
    public WebElement billingStreetAddress;

    @FindBy(id = "billing_city")
    public WebElement billingCity;

    @FindBy(xpath = "//span[@class='select2-selection__placeholder']")
    public WebElement billingState;
    @FindBy(id = "billing_postcode")
    public WebElement billingZipcode;

    @FindBy(id = "billing_phone")
    public WebElement billingPhone;

    @FindBy(name = "save_address")
    public WebElement saveBillingAddress;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-account/']")
    public WebElement accountDetails;

    @FindBy(xpath = "(//i[@class='w-icon-long-arrow-right'])[3]")
    public WebElement addButtonUnderShipping;

    @FindBy(id = "shipping_first_name")
    public WebElement shippingFirstName;

    @FindBy(id = "shipping_last_name")
    public WebElement shippingLastName;

    @FindBy(xpath = "(//span[@class='select2-selection__placeholder'])[1]")
    public WebElement shippingCountry;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement inputSection;

    @FindBy(id = "shipping_address_1")
    public WebElement shippingStreetAddress;

    @FindBy(id = "shipping_city")
    public WebElement shippingCity;

    @FindBy(xpath = "//span[@class='select2-selection__placeholder']")
    public WebElement shippingProvince;

    @FindBy(id = "shipping_postcode")
    public WebElement shippingPostCode;

    @FindBy(name = "save_address")
    public WebElement saveAddressButton;

    @FindBy(linkText = "Store Manager")
    public WebElement storeManager;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement inputSection2;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement countryInputSection;


    @FindBy(id = "billing_email")
    public WebElement billingEmailConfirmation;





    @FindBy(xpath = "//div[@class='woocommerce-notices-wrapper']")
    public WebElement successMessage;




    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement countryInputSectionForBilling;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement stateInputSectionForBilling;






    @FindBy(linkText = "My Account")
    public WebElement myAccountPageExist;

    @FindBy(id = "billing_first_name")
    public WebElement firstName;


    @FindBy(id = "billing_last_name")
    public WebElement lastName;

    @FindBy(xpath = "//select[@id='billing_country']")
    public WebElement countryRegion;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    public WebElement streetAddress;

    @FindBy(xpath = "//input[@id='billing_city']")
    public WebElement townCity;

    @FindBy(xpath = "//select[@id='billing_state']")
    public WebElement stateUS;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@id='billing_phone']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='billing_email']")
    public WebElement vendorEmail;

    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement saveAddress;

    @FindBy(xpath = "//a[normalize-space()='Edit Your Billing Address']")
    public WebElement addBillingAddress;

    @FindBy(xpath = "//*[text()='Addresses']")
    public WebElement addressesLink;

    @FindBy(xpath = "//td[normalize-space()='World Way 151']")
    public WebElement savedAddressField;




}

