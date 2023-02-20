package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddVariableProductPage {

    public AddVariableProductPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='account']")
    public WebElement accountButton;

    @FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManagerButton;

    @FindBy(xpath = "//div[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
    public WebElement productsButton;



    @FindBy(xpath = "(add_new_product_dashboard")
    public WebElement addNewProductButton;

    @FindBy(id = "product_type")
    public WebElement productSelectDropdown;

    @FindBy(id = "pro_title")
    public WebElement productTitle;

    //featured img

    @FindBy(id = "featured_img_display")
    public WebElement featuredImage;

    @FindBy(id = "menu-item-browse")
    public WebElement mediaLibrary;

    @FindBy(xpath = "(//img[@src='https://allovercommerce.com/wp-content/uploads/2023/01/Bart-Simpson-1-300x187.jpg'])[1]")
    public WebElement image;

    @FindBy(xpath = "(//*[.='Select'])[3]")
    public WebElement select1;

    //gallery img

    @FindBy(id = "(gallery_img_gimage_0_display")
    public WebElement galleryImage;

    @FindBy(xpath = "(//img[@src='https://allovercommerce.com/wp-content/uploads/2023/01/Bart-Simpson-1-300x187.jpg'])[2]")
    public WebElement image2;

    @FindBy(xpath = "(//*[.='Add to Gallery'])[8]")
    public WebElement addGalleryButton;


    //choose category
    @FindBy(xpath = "(//span[.='Best Seller']")
    public WebElement categoryCheckbox;

    @FindBy(id = "attributes_is_active_1")
    public WebElement colorCheckbox;

    @FindBy(xpath = "(//*[.='Add New'])[3]")
    public WebElement addNewcolorButton;

    @FindBy(id = "attributes_is_active_2")
    public WebElement sizeCheckbox;

    @FindBy(xpath = "(//*[.='Add New'])[4]")
    public WebElement addNewSizeButton;

    @FindBy(id = "wcfm_products_manage_form_attribute_head")
    public WebElement attributeButton;

    @FindBy(id = "wcfm_products_manage_form_attribute_head")
    public WebElement attributeName;

    @FindBy(id = "wcfm_products_simple_submit_button")
    public WebElement productSubmitButton;

    @FindBy(xpath = "v//select[@name='default_attributes[attribute_pa_size]']")
    public WebElement anySizeDropdown;










    //@FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
    //public WebElement colorDropdown;


    @FindBy(id = "attributes_is_active_2")
    public WebElement sizeButton;

    @FindBy(xpath = "(//input[@class='select2-search__field'])[3]")
    public WebElement sizeDropdown;

    @FindBy(id = "attributes_name_3")
    public WebElement attributeNameInput;

    @FindBy(xpath = "//button[@class='button wcfm_add_attribute']")
    public WebElement addAttributeButton;

    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[6]")
    public WebElement variationsButton;


}
