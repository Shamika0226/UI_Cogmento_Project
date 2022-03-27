package com.Pages.Company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCompanyPage {

    WebDriver driver;

    @FindBy(xpath = "//div[text()='Name']//following-sibling::div//div//span//p")
    WebElement addedCompnayName;

    public NewCompanyPage(WebDriver driver) { this.driver = driver; }

    public String addedCompany(){
        return addedCompnayName.getText();
    }
}
