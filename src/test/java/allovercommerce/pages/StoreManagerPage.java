package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class StoreManagerPage {
    public StoreManagerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//*[@class='wcfmfa fa-cube'])[1]")
    public WebElement productPageButton;

    @FindBy(xpath = "(//*[.='Add New'])[1]")
    public WebElement addNewProduct;

    @FindBy(id = "featured_img_display")
    public WebElement bigFuture;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement bigFutureUpload;

    @FindBy(xpath = "(//*[.='Select'])[4]")
    public WebElement selectUpload;

    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement littlePicture;

    @FindBy(xpath = "//*[@data-id='19392']")
    public WebElement firstProduct;

    @FindBy(xpath = "(//button[.='Add to Gallery'])[2]")
    public WebElement addToGallery;

    @FindBy(id = "menu-item-upload")
    public WebElement uploadFilePageButton;


    @FindBy(id = "product_type")
    public WebElement productsDropdown;

    @FindBy(id = "pro_title")
    public WebElement productTitleInput;

    @FindBy(id = "regular_price")
    public WebElement priceInput;

    @FindBy(id = "sale_price")
    public WebElement priceInput2;

    @FindBy(xpath = "//*[@class='mce-content-body excerpt post-type-page post-status-publish page-template-default locale-en-us mceContentBody webkit wp-editor html5-captions']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//*[@class='mce-content-body description post-type-page post-status-publish page-template-default locale-en-us mceContentBody webkit wp-editor html5-captions']")
    public WebElement secondDescription;

    @FindBy(id = "excerpt_ifr")
    public WebElement firstIframe;

    @FindBy(id="description_ifr")
    public WebElement secondIFrame;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li/input")
    public List<WebElement> categoriesCheckboxList;

    @FindBy(xpath = "//*[@id='product_brand']//li//input")
    public List<WebElement> productBrandsList;

    @FindBy(xpath = "//*[.='+Add new category']")
    public WebElement addNewCategoryButton;

    @FindBy(id = "wcfm_new_cat")
    public WebElement newCategoryInput;

    @FindBy(id = "wcfm_new_parent_cat")
    public WebElement categoryDropdown;

    @FindBy(xpath = "(//*[@class='button wcfm_add_category_bt wcfm_add_taxonomy_bt'])[1]")
    public WebElement categoryFinalAddButton;

    @FindBy(name = "submit-data")
    public WebElement finishButton;

    @FindBy(xpath = "(//*[.='Chess'])[2]")
    public WebElement chessProduct;

    @FindBy(id = "product_url")
    public WebElement productURLInput;

    @FindBy(id = "button_text")
    public WebElement buttonTextInput;










    @FindBy(xpath = "(//span[@class='text'])[6]")
    public WebElement coupon;

    @FindBy(xpath = "//span[.='Add New']")
    public WebElement addNewButton;

    @FindBy(id = "title")
    public WebElement codeInput;



    @FindBy(id = "discount_type")
    public WebElement discountType;

    @FindBy(id = "coupon_amount")
    public WebElement couponAmount;

    @FindBy(id = "expiry_date")
    public WebElement expiryDate;

    @FindBy(id = "free_shipping")
    public WebElement checkBox1;

    @FindBy(id = "show_on_store")
    public WebElement checkBox2;

    @FindBy(id = "wcfm_coupon_manager_submit_button")
    public WebElement submitButton;

    @FindBy(xpath = "(//a[@class='wcfm_dashboard_item_title'])[1]")
    public WebElement xyzCoupon;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement productsSection;

    @FindBy(id = "product_type")
    public WebElement productType;

    @FindBy(id = "is_virtual")
    public WebElement virtualCheckBox;

    @FindBy(id = "is_downloadable")
    public WebElement downloadableCheckBox;

    @FindBy(id = "pro_title")
    public WebElement productTitle;

    @FindBy(id = "regular_price")
    public WebElement price;

    @FindBy(id = "sale_price")
    public WebElement salePrice;

    @FindBy(id = "featured_img_display")
    public WebElement picture;

    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement galeryPicture;

    @FindBy(xpath = "//button[@class='browser button button-hero']")
    public WebElement selectFilesButton;

    @FindBy(id = "menu-item-browse")
    public WebElement mediaLibrary;

    @FindBy(xpath = "//div[@class='thumbnail']")
    public WebElement choosePicture;

    @FindBy(xpath = "(//div[@class='thumbnail'])[5]")
    public WebElement chooseGalleryPicture;

    @FindBy(xpath = "//button[@class='button media-button button-primary button-large media-button-select']")
    public WebElement selectSubmitButton;

    @FindBy(xpath = "//button[@class='button media-button button-primary button-large media-button-select']")
    public WebElement addGaleryButton;

    @FindBy(xpath = "//span[.='education']")
    public WebElement categories;

    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[2]")
    public WebElement downloadableSection;

    @FindBy(id = "downloadable_files_name_0")
    public WebElement nameInput;

    @FindBy(id = "downloadable_files_file_0_button")
    public WebElement fileInput;

    @FindBy(id = "wcfm_products_simple_submit_button")
    public WebElement submitSectionButton;

    @FindBy(xpath = "//span[@class='product-status product-status-publish']")
    public WebElement publishedSection;

    @FindBy(xpath = "//div[@class='wcfm_menu_items wcfm_menu_wcfm-products']/a")
    public WebElement products;

    @FindBy(xpath = "//div[@class='wcfm_menu_items wcfm_menu_wcfm-products']/span")
    public WebElement productsAddNew;



}
