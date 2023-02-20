package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//td[@class='product-name']/span/a")
    public List<WebElement> productsInCartPage;

    @FindBy(xpath = "//button[@class='quantity-plus w-icon-plus']")
    public WebElement increaseButton;

    @FindBy(xpath = "//button[@class='quantity-minus w-icon-minus']")
    public WebElement decreaseButton;

    @FindBy(name = "update_cart")
    public WebElement updateCartButton;

    @FindBy(xpath = "//div[@class='quantity']/input")
    public WebElement quantity;

    @FindBy(xpath = "//td[@class='product-price']//bdi")
    public WebElement productPrice;

    @FindBy(xpath = "//td[@class='product-subtotal']//bdi")
    public WebElement subtotalPrice;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckoutButton;

    @FindBy(id = "coupon_code")
    public WebElement couponInput;

    @FindBy(name = "apply_coupon")
    public WebElement applyCoupon;

    @FindBy(xpath = "//table[@class='shop_table']/tbody/tr/th")
    public WebElement discountElement;

}

