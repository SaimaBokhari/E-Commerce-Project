package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyStorePage {
    public MyStorePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "add_new_product_dashboard")
    public WebElement addNewProduct;






}
