package allovercommerce.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import allovercommerce.utilities.Driver;

public class US_05_AccountDetailsPage {
    public US_05_AccountDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Locate elements by using any locator

    @FindBy(id = "account_first_name")
    public WebElement firstName;

    @FindBy(id="account_last_name")
    public WebElement lastName;

    @FindBy(id="account_display_name")
    public WebElement displayName;

    @FindBy(id="account_email")
    public WebElement email;

    @FindBy(xpath = "//button[@name='save_account_details']")
    public WebElement saveButton;

    @FindBy(id="tinymce")
    public WebElement biographySection;

    @FindBy(id="password_current")
    public WebElement currentPassword;

    @FindBy(id="password_1")
    public WebElement newPassword;

    @FindBy(id="password_2")
    public WebElement confirmPassword;

    @FindBy(linkText = "Logout")
    public WebElement logoutButton;

}
