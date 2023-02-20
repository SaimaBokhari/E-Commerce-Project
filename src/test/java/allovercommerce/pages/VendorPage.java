package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {

    public VendorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@class='register_as_vendor']")
    public WebElement vendorSignupOption;
    @FindBy(id = "user_email")
    public WebElement emailInput;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement codeInput;


    @FindBy(xpath = "(//*[.='Sign In'])[1]")
    public WebElement signInOptions;

    @FindBy (id = "username")
    public WebElement usernameInput;

    @FindBy(name = "login")
    public WebElement signInButton;

    @FindBy (name = "s")
    public WebElement searchInput;

    @FindBy(xpath = "//*[@data-original-product-id='14216']")
    public WebElement addWishList;

    @FindBy(id = "password")
    public WebElement passwordInput;



    @FindBy(id = "confirm_pwd")
    public WebElement confirmPasswordInput;

    @FindBy(id = "wcfm_membership_register_button")
    public WebElement registerButton;

    @FindBy(xpath = "//div[.='This Email already exists. Please login to the site and apply as vendor.']")
    public WebElement emailAlreadyExistMessage;

    @FindBy(xpath = "(//*[text()='Orders'])[2]")
    public WebElement ordersLink;

    @FindBy(xpath = "(//*[text()='Downloads'])[2]")
    public WebElement downloadsLink;

    @FindBy(xpath= "(//*[text()='Addresses'])[2]")
    public WebElement addressesLink;

    @FindBy(xpath = "(//*[text()='Account details'])[2]")
    public WebElement accountDetailsLink;

    @FindBy(xpath = "(//*[text()='Downloads'])[1]")
    public WebElement downloadsDashboardLink;

    @FindBy(xpath = "(//*[text()='Orders'])[1]")
    public WebElement ordersDashboardLink;

    @FindBy(xpath = "(//*[text()='Logout'])[2]")
    public WebElement logoutLink;

    @FindBy(linkText = "Wishlist")
    public WebElement whishlistDashboardLink;

    @FindBy(xpath = "//p[.='Wishlist']")
    public WebElement whishlistLink;

    @FindBy(xpath = "(//*[text()='Dashboard'])[1]")
    public WebElement dashboardLink;

    @FindBy(xpath = "(//*[text()='Store Manager'])[1]")
    public WebElement storeManagerLink;

    @FindBy(xpath = "(//*[text()='Support Tickets'])[1]")
    public WebElement supportTicketsLink;

    @FindBy(xpath = "(//*[text()='Followings'])[1]")
    public WebElement followingsLink;

    @FindBy(xpath = "(//*[text()='Logout'])[1]")
    public WebElement logoutDashboardLink;

    @FindBy(xpath = "//h2")
    public WebElement myAccountHeader;
    @FindBy(xpath = "//span[@class='wcicon-status-completed']")
    public WebElement verificationCodeMessage;

    @FindBy(xpath = "//span[@class='wcicon-status-cancelled']")
    public WebElement passwordTooShortFailureMessage;

    @FindBy(linkText = "Wishlist")
    public WebElement wishlistLink;

    @FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManager;



}

