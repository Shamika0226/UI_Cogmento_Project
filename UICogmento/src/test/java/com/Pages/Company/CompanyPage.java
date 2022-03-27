package com.Pages.Company;

import com.Utility.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class CompanyPage extends WebDriverManager {
    WebDriver driver;
    JavascriptExecutor jsexecutor=(JavascriptExecutor) driver;
    public static  String values;
    public ArrayList <String> allCompanyList;


//    @FindBy(xpath = "//i[@class='building icon']")
//    WebElement icon_Company;

    @FindBy(xpath = "//button[text()='Show Filters']")
    WebElement button_ShowFilterOnCompanyPage;

    @FindBy(xpath = "//button[@class='ui small button']")
    WebElement button_AddFilters;

    @FindBy(xpath = "//i[@class='columns small icon']")
    WebElement button_AddColumns;

    @FindBy(xpath = "//label[text()='Website']")
    WebElement checkbox_Websites;

    @FindBy(xpath = "//label[text()='Phone']")
    WebElement checkbox_Phone;

    @FindBy(xpath = "//label[text()='Description']")
    WebElement checkbox_Description;

    @FindBy(xpath = "//button[text()='Set']")
    WebElement button_Set;

    @FindBy(xpath = "//button[text()='Create']")
    WebElement button_CreateOnCompanyPage;

    @FindBy(xpath="//tr/td[2]/a")
    List<WebElement> companyNames;

    public CompanyPage(WebDriver driver){
        this.driver=driver;
    }

//    Actions act=new Actions(driver);

    public void scrollCompanyPage(){

        jsexecutor.executeScript("window.scrollBy(0,400)");
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }


    public void setButton_CreateOnCompanyPage(){
        button_CreateOnCompanyPage.click();
// try {
//            wait();
//            ExpectedConditions.visibilityOf(button_CreateOnCompanyPage);
//            button_CreateOnCompanyPage.click();
//        }
//        catch (NoSuchElementException e) {
//            System.out.println(e.getStackTrace());
//        }
//        catch (Exception e) {
//            System.out.println(e.getStackTrace());
//        }
//        getActions().click(button_CreateOnCompanyPage);
    }

    public void setButton_ShowFilterOnCompanyPage(){
        button_ShowFilterOnCompanyPage.click();
    }

    public void setButton_AddFilters(){
        button_AddFilters.click();
    }

    public void setButton_AddColumns(){
        button_AddColumns.click();
    }

    public void setCheckbox_Websites(){
        checkbox_Websites.click();
    }

    public void setCheckbox_Phone(){
        checkbox_Phone.click();
    }

    public void setCheckbox_Description(){
        checkbox_Description.click();
    }

    public void setButton_Set(){
        button_Set.click();
    }

    public CreateNewCompany navigateToCreateNewCompany() {
//        Actions action = new Actions(driver);
//        action.moveToElement(button_CreateOnCompanyPage).click();

        setButton_CreateOnCompanyPage();

        return PageFactory.initElements(driver,CreateNewCompany.class);
    }

    public List<String> getCompanyNames(){

        List<String> companyNamesList = new ArrayList<String>();
        for (WebElement element : companyNames ) {
            companyNamesList.add(element.getText());
//            System.out.println(element.getText());
        }
        for(String names : companyNamesList) {
            System.out.println("Element of the list into String format : "+names);
        }
        return companyNamesList;
    }

}
