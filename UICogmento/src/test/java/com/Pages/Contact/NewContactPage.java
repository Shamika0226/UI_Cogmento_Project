package com.Pages.Contact;

import com.Pages.Company.CompanyPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactPage{

    WebDriver driver;

    @FindBy(xpath = "//div[text()='Middle Name(s)']//following-sibling::div//div//span//p")
    WebElement addedContactMiddleName;

    @FindBy(xpath="//div[text()='Company']//following-sibling::div[@class='ui link list']//div[@class='content table-cell firstchild']//div[@class='shortlen-container className']")
    WebElement addedCompanyName;



    public NewContactPage(WebDriver driver) {
        this.driver=driver;
    }

    public String createdContactMiddleName(){
//        String createdContactName=newContactName.getText();
        return addedContactMiddleName.getText();
    }

    public String createdCompanyName(){

        return addedCompanyName.getText();
    }

    public CompanyPage naviagateToCompanyFromContact(){

        return PageFactory.initElements(driver,CompanyPage.class);
    }
}
