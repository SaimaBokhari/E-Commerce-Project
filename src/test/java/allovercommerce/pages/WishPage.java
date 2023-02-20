package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishPage {
    public WishPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "ASUS X415EA-EB1360W")
    public WebElement itemOnWishList;

    @FindBy(xpath = "//*[@data-product='14216']")
    public WebElement quickViewButton;

    @FindBy(xpath = "//*[@class='posted_in']")
    public WebElement attributeOfProduct;

    @FindBy(xpath = "//*[@title='Close (Esc)']")
    public WebElement exitButton;

    @FindBy(xpath = "//*[@data-product_id='14216']")
    public  WebElement addToCartButton;

    @FindBy(xpath = "(//*[@class='w-icon-cart'])[1]")
    public WebElement cartButton;

    @FindBy(xpath = "//*[@class='button checkout wc-forward']")
    public WebElement checkOutButton;


}
