package com.Pages.Contact;



import com.Utility.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends WebDriverManager {

    WebDriver driver;
    JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;


//    @FindBy(xpath = "//i[@class='users icon']")
//    WebElement icon_Contact;

    @FindBy(xpath = "//button[contains(text(),'Show Filters')]")
    WebElement button_ShowFilter;

    @FindBy(xpath = "//button[text()='Export']")
    WebElement button_Export;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement handle_PopupOk;

    @FindBy(xpath = "//button[text()='Create']")
    WebElement button_CreateNewOnContactPage;

//    @FindBy(xpath = "//input[@name='first_name']")
//    WebElement textbox_FirstName;
//
//    @FindBy(xpath = "//input[@name='middle_name']")
//    WebElement textbox_MiddleName;
//
//    @FindBy(xpath = "//input[@name='last_name']")
//    WebElement textbox_LastName;
//
//    @FindBy(xpath = "//*[@id='main-content']/div/div[2]/form/div[2]/div[2]/div/div/input")
//    WebElement textbox_Company;
//
//    @FindBy(xpath="//input[@placeholder='Email address']")
//    WebElement textbox_Email;
//
//    @FindBy(xpath = ".//*[@name='category' and @class='ui selection dropdown']")
//    WebElement dropdown_Category;
//
//    @FindBy(xpath = "//span[text()='Customer']")
//    WebElement select_Cutomer;
//
//    @FindBy(xpath = "//div[@name='channel_type']")
//    WebElement dropdown_ChannelType;
//
//    @FindBy(xpath = "//span[text()='LinkedIn']")
//    WebElement select_LinkedIn;
//
//    @FindBy(xpath = "//div[@name='country']")
//    WebElement dropdown_Country;
//
//    @FindBy(xpath = "//span[text()='Sri Lanka']")
//    WebElement select_SriLanka;
//
//    @FindBy(xpath = "//button[text()='Cancel']")
//    WebElement button_CancelOnContactpage;
//
//    @FindBy(xpath = "//button[@class='ui linkedin button']")
//    WebElement button_Save;
//
//    @FindBy(xpath = "//tr/td[2]/a")
//    List<WebElement> contactnames;

//    List <WebElement> contactnames=driver.findElements(By.xpath("//div[@class='vertical-timeline-element-content bounce-in']"));


//    public void scrollContactPageBy400(){ jsexecutor.executeScript("window.scrollBy(0,400)"); }

//    public void scrollContactPageBy900(){ jsexecutor.executeScript("window.scrollBy(0,900)");}

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }


    public void buttonShowFiltersOnContact() {
        button_ShowFilter.click();
    }

    public void buttonExport() {
        button_Export.click();
    }

    public void handlePopup() {
        handle_PopupOk.click();
    }

    public void buttonCreateNew() {
        button_CreateNewOnContactPage.click();
    }

//    public void insertFirstName(String firstname) {
//        textbox_FirstName.sendKeys(firstname);
//    }
//
//    public void insertMiddleaName(String middlename) {
//        textbox_MiddleName.sendKeys(middlename);
//    }
//
//    public void insertLastName(String lastname) {
//        textbox_LastName.sendKeys(lastname);
//    }
//
//    public void insertEmail(String email){
//        textbox_Email.sendKeys(email);
//    }
//
//    public void insertCompnay(String companyname){textbox_Company.sendKeys(companyname);
//    }
//
//    public void categoryDropdown() {
//        dropdown_Category.click();
//    }
//
//    public void selectCustomerOption() {
//        select_Cutomer.click();
//    }
//
//    public void channelTypeDropdown() {
//        dropdown_ChannelType.click();
//    }
//
//    public void selectChannelType() {
//        select_LinkedIn.click();
//    }
//
//    public void countryDropdown() {
//        dropdown_Country.click();
//    }
//
//    public void selectSrilanka() {
//        select_SriLanka.click();
//    }
//
//    public void buttonCancel() {
//        button_CancelOnContactpage.click();
//    }
//
//    public void buttonSave() {
//        button_Save.click();
//    }

    public CreateNewContact navigateToCreateNewContact(){

        buttonCreateNew();
        return PageFactory.initElements(driver,CreateNewContact.class);
    }



}

