package com.Pages.Email;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EmailPage{

    WebDriver driver;
    JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;

    @FindBy(xpath="//button[@class='ui fluid button']")
    WebElement button_Compose;


//    @FindBy(xpath="//*[@id='main-content']/div/div[2]/div/div[1]/div/div[1]/button")
//    WebElement button_Compose;

    @FindBy(xpath="//i[@class='refresh icon']")
    WebElement icon_Refresh;

    public EmailPage(WebDriver driver){ this.driver=driver; }

    public void clickRefresh(){icon_Refresh.click();}

    public void clickComposeEmail(){
//        Actions actions=new Actions(driver);
//        actions.moveToElement(button_Compose).click();
        button_Compose.click();
    }


    public ComposeEmail navigateToComposeEmailPage(){

        clickRefresh();
        clickComposeEmail();
        return PageFactory.initElements(driver,ComposeEmail.class);
    }
}


