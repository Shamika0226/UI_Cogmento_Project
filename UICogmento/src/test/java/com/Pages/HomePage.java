package com.Pages;



import com.Pages.Calendar.CalendarPage;
import com.Pages.Company.CompanyPage;
import com.Pages.Contact.ContactPage;
import com.Pages.Email.EmailPage;
import com.Utility.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class HomePage {
    public WebDriverManager webDriverManager;
    public static ArrayList<String> allContacts;


    @FindBy(xpath = "//span[text()='Email']")
    WebElement icon_Email;

    @FindBy(xpath = "//i[@class='building icon']")
    WebElement icon_Company;

    @FindBy(xpath = "//i[@class='users icon']")
    WebElement icon_Contact;

    @FindBy(xpath = "//i[@class='calendar icon']")
    WebElement icon_Calendar;

    @FindBy(xpath="//i[@class='home icon']")
    WebElement icon_Home;

    @FindBy(xpath = "//div[@class='summary']//span//a")
    List <WebElement> contactNames;

//    @FindBy(xpath = "")

    public String homePageTitle(){

        return webDriverManager.getDriver().getTitle();
    }


    public HomePage navigateToHomePage(){
        icon_Home.click();
        return PageFactory.initElements(WebDriverManager.getDriver(),HomePage.class);
    }

    public CompanyPage navigateToCompanyPage(){
        icon_Company.click();
        return PageFactory.initElements(WebDriverManager.getDriver(), CompanyPage.class);
    }

    public EmailPage navigateToEmailPage(){
        icon_Email.click();
        return PageFactory.initElements(WebDriverManager.getDriver(), EmailPage.class);
    }

    public CalendarPage navigateToCalendarPage(){
        icon_Calendar.click();
        return PageFactory.initElements(WebDriverManager.getDriver(), CalendarPage.class);
    }

    public ContactPage navigateToContactPage(){
        icon_Contact.click();
        return PageFactory.initElements(WebDriverManager.getDriver(), ContactPage.class);
    }


    public List<String> getContactNames(){

        List<String> contactNamesList = new ArrayList<String>();
        for (WebElement element : contactNames) {
            contactNamesList.add(element.getText());
//            System.out.println(element.getText());
        }
//        for(String names : contactNamesList) {
//            System.out.println("Element of the list into String format : "+names);
//        }
        return contactNamesList;

    }


}
