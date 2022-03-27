package com.Pages.Company;

import com.Utility.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateNewCompany extends WebDriverManager {


    @FindBy(xpath = "//input[@name='name' and @autocomplete='new-password']")
    WebElement textbox_CompanyName;

    @FindBy(xpath = "//button[@class='ui small fluid positive toggle button']")
    WebElement button_Access;

    @FindBy(xpath = "//input[@name='url']")
    WebElement textbox_Link;

    @FindBy(xpath = "//input[@name='address']")
    WebElement textbox_CompanyAddress;

    @FindBy(xpath = "//input[@name='city']")
    WebElement textbox_ComoanyCity;

    @FindBy(xpath = "//input[@name='state']")
    WebElement textbox_State;

    @FindBy(xpath="//input[@name='zip']")
    WebElement textbox_ZipCode;

    @FindBy(xpath = "//input[@placeholder='Number']")
    WebElement textbox_Mobileno;

    @FindBy(xpath = "//input[@placeholder='Home, Work, Mobile...']")
    WebElement textbox_Homeno;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement textbox_Description;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement button_Save;


    public void setTextbox_CompanyName(String companyName){ textbox_CompanyName.sendKeys();}

    public void setButton_Access(){
        button_Access.click();
    }

    public void setTextbox_Link(String url){
        textbox_Link.sendKeys(url);
    }

    public void setTextbox_CompanyAddress(String companyAddress){ textbox_CompanyAddress.sendKeys(companyAddress); }

    public void setTextbox_CompanyCity(String comoanyCity){
        textbox_ComoanyCity.sendKeys(comoanyCity);
    }

    public void setTextbox_State(String country){
        textbox_State.sendKeys(country);
    }

    public void setTextbox_ZipCode(String postcode){
        textbox_ZipCode.sendKeys(postcode);
    }

    public void setTextbox_Mobileno(String mobileNumber){
        textbox_Mobileno.sendKeys(mobileNumber);
    }

    public void setTextbox_Homeno(String homeNumber){
        textbox_Homeno.sendKeys(homeNumber);
    }

    public void setTextbox_Description(String description){
        textbox_Description.sendKeys(description);
    }

    public void setButton_Save(){ button_Save.click();}

    public void createNewCompany(String companyName,String companyUrl,String address,String city,String country,String zipcode,String mobileNo,String homeNo,String description){

                WebDriverWait wait=new WebDriverWait(driver,10);
                wait.until(ExpectedConditions.visibilityOf(textbox_CompanyName));

                if (textbox_CompanyName.isEnabled()) {
                    setTextbox_CompanyName(companyName);
                    setButton_Access();
                    setTextbox_Link(companyUrl);
                    setTextbox_CompanyAddress(address);
                    setTextbox_CompanyCity(city);
                    setTextbox_State(country);
                    setTextbox_ZipCode(zipcode);
                    setTextbox_Mobileno(mobileNo);
                    setTextbox_Homeno(homeNo);
                    setTextbox_Description(description);
                    setButton_Save();

                }else{
                    System.out.println("Company name text box not visible");
                }

    }

    public NewCompanyPage navigateToNewCompanyPage(){

        return PageFactory.initElements(driver,NewCompanyPage.class);
    }


}
