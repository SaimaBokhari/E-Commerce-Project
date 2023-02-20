package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsManagePage {
    public ProductsManagePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_inventory_head']/div")
    public WebElement inventoryHead;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_shipping_head']/div")
    public WebElement shippingHead;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_attribute_head']/div")
    public WebElement attributeHead;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_linked_head']/div")
    public WebElement linkedHead;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_yoast_head']/div")
    public WebElement seoHead;

    @FindBy(xpath = "//div[@class='page_collapsible wcfm_acf_products_manage_3116_collapsible simple variable external grouped booking collapse-close']/div")
    public WebElement wholesaleHead;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_advanced_head']/div")
    public WebElement advanceHead;

    //  =========Products========
    @FindBy(id="sku")
    public WebElement sku;

    @FindBy(id="manage_stock")
    public WebElement manageStock;

    @FindBy(id="sold_individually")
    public WebElement soldIndividually;

    @FindBy(id="backorders")
    public WebElement stockStatus;

    // =======shipping elements======
    @FindBy(id = "weight")
    public WebElement weight;

    @FindBy(id = "length")
    public WebElement length;

    @FindBy(id = "width")
    public WebElement width;

    @FindBy(id = "height")
    public WebElement height;

    @FindBy(id = "shipping_class")
    public WebElement shippingClass;

    @FindBy(id = "_wcfmmp_processing_time")
    public WebElement processingTime;

    //========Attributes elements=======
    //******Color*******
    @FindBy(id = "attributes_is_active_1")
    public WebElement colorsCheckbox;

    @FindBy(id = "attributes_is_active_1")
    public WebElement attributesActive;

    @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
    public WebElement colorInput;

    @FindBy(xpath = "select2-attributes_value_1-result-lv5i-40")
    public WebElement green;

    @FindBy(xpath = "//button[text()='Select all']")
    public WebElement selectAllColor;

    @FindBy(xpath = "//button[text()='Select none']")
    public WebElement selectNoneColor;

    @FindBy(xpath = "//button[text()='Add New']")
    public WebElement addNewColor;

    @FindBy(id = "attributes_is_visible_1")
    public WebElement visibleOnPageColor;

    //******Size******
    @FindBy(id = "attributes_is_active_2")
    public WebElement sizeCheckbox;

    @FindBy(xpath = "(//input[@class='select2-search__field'])[3]")
    public WebElement sizeInput;

    @FindBy(xpath = "(//button[text()='Select all'])[2]")
    public WebElement selectAllSize;

    @FindBy(xpath = "(//button[text()='Select none'])[2]")
    public WebElement selectNoneSize;

    @FindBy(xpath = "(//button[text()='Add New'])[2]")
    public WebElement addNewSize;

    @FindBy(id = "attributes_is_visible_2")
    public WebElement visibleOnPageSize;

    @FindBy(xpath = "//button[@class='button wcfm_add_attribute']")
    public WebElement addAttributeButton;

    @FindBy(xpath = "//p[@class='attributes_name_0 wcfm_title wcfm_ele simple variable external grouped booking']")
    public WebElement newAttributeName;

    //  ========== linked ==============
    @FindBy(xpath = "(//input[@class='select2-search__field'])[4]")
    public WebElement upsellInput;

    @FindBy(xpath = "(//li[@class='select2-selection__choice'])[1]")
    public List<WebElement> upsellList;

    @FindBy(xpath = "//*[@id='select2-upsell_ids-results']//*[text()='calculator (#17653)']")
    public WebElement calculatorUpsell;

    @FindBy(xpath = "(//input[@class='select2-search__field'])[5]")
    public WebElement crossSellInput;

    @FindBy(xpath = "//*[@id='select2-crosssell_ids-results']//*[text()='calculator (#17653)']")
    public WebElement calculatorCrossSell;

    @FindBy(xpath = "(//li[@class='select2-selection__choice'])[2]")
    public List<WebElement> crossSellList;

    @FindBy(id = "select2-upsell_ids-results")
    public WebElement upsellResult;

    @FindBy(id = "select2-crosssell_ids-results")
    public WebElement crossSellInputResult;

    //   ========   seo   ===========
    @FindBy(id = "yoast_wpseo_focuskw_text_input")
    public WebElement focusKeyword;

    @FindBy(id = "yoast_wpseo_metadesc")
    public WebElement metaDisc;

    //  ========  whole Sale  ============
    @FindBy(id = "piecetype")
    public WebElement pieceType;

    @FindBy(id = "unitpercart")
    public WebElement unitPerCart;

    @FindBy(id = "minorderqtytr")
    public WebElement minOrder;

    //  =====  advanced  ======
    @FindBy(id = "enable_reviews")
    public WebElement enableReviews;

    @FindBy(id = "menu_order")
    public WebElement menuOrders;

    @FindBy(id = "purchase_note")
    public WebElement purchase_note;


}
