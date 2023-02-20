package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressPage {


    public ShippingAddressPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[.='Add'])[2]")
    public WebElement addButtonShippingAddress;

    @FindBy(linkText = "Addresses")
    public WebElement getAddressesButton;

    @FindBy(xpath = "(//a[.='Add'])[2]")
    public WebElement getAddButtonShippingAddress;

    @FindBy(id =  "shipping_first_name")
    public WebElement shippingFirstName;


    @FindBy(id =  "shipping_last_name")
    public WebElement shippingLastName;

    @FindBy(id =  "shipping_company")
    public WebElement CompanyName;

    @FindBy(xpath = "(//*[.='Select a country / region…'])[6]")
    public WebElement shippingCountryDropdown;


//        @FindBy(xpath = "//input[@class='select2-search__field']")
//        public WebElement countryInputSection;

    @FindBy(id =  "shipping_address_1")
    public WebElement streetShippingAddress;

    @FindBy(id =  "shipping_postcode")
    public WebElement shippingPostCode;

    @FindBy(id =  "shipping_city")
    public WebElement shippingCity;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement provinceInput;
    //
    @FindBy(xpath = "(//*[.='Select an option…'])[1]")
    public WebElement provinceDropDown;

    @FindBy(name =  "Save_address")
    public WebElement saveAddressButton;


//    @FindBy(xpath = "(//span[@class='select2-selection__placeholder'])[1]")
//    public WebElement shippingCountry;
//
//    @FindBy(xpath = "//input[@class='select2-search__field']")
//    public WebElement inputSection;

    @FindBy(xpath = "//span[@class='select2-selection__placeholder']")
    public WebElement shippingProvince;

//    @FindBy(xpath = "//input[@class='select2-search__field']")
//    public WebElement inputSection2;
}


//"xpath","selector":"//input[@class='select2-search__field']"



