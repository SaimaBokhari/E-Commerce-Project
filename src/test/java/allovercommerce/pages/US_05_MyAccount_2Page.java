package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_05_MyAccount_2Page {

    public US_05_MyAccount_2Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Locate elements by using any locator

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButton;

    @FindBy(linkText = "Account details")
    public WebElement accountDetails;
}
