package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_10_VendorRegisterPage {
    public US_10_VendorRegisterPage(){  // Constructor
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "passoword")
    public WebElement password;

    @FindBy(xpath = "//div[@name='password_strength']")
    public WebElement passwordQuality;
}
