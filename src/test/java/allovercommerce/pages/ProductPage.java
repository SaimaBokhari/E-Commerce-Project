package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "add-to-cart")
    public WebElement addToCart;

    @FindBy(xpath = "//button[@class='quantity-plus w-icon-plus']")
    public WebElement increaseButton;

    @FindBy(xpath = "//button[@class='quantity-minus w-icon-minus']")
    public WebElement decreaseButton;

    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-btn alert-success']")
    public WebElement viewCartAlert;

    @FindBy(xpath = "//i[@class='w-icon-cart']")
    public WebElement cartButton;

    @FindBy(xpath = "//*[@class='cart-item-meta mini-item-meta']/a")
    public WebElement productInCartPopup;

    @FindBy(xpath = "//p[@class='woocommerce-mini-cart__buttons buttons']/a[1]")
    public WebElement viewCartButton;


}
