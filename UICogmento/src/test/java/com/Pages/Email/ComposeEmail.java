package com.Pages.Email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ComposeEmail {

    WebDriver driver;

    @FindBy(xpath="//div[@name='to']//input[1]")
    WebElement textbox_To;

    @FindBy(xpath = "//div[@role='option']//span[1]")
    List<WebElement> suggested_ContactNames;

    @FindBy(xpath="//input[@name='cc']")
    WebElement textbox_Cc;

    @FindBy(xpath="//input[@name='bcc']")
    WebElement textbox_BCc;

    @FindBy(xpath="//input[@name='subject']")
    WebElement textbox_Subject;

    @FindBy(xpath = "//a[text()='Back']")
    WebElement button_Back;

    @FindBy(xpath = "//button[text()='Connect email account']")
    WebElement button_ConnectToEmail;

    @FindBy(xpath = "//a[text()='My Company']")
    WebElement select_MyCompanyOption;

    @FindBy(xpath = "//input[@name='address']")
    WebElement textbox_Address;

    @FindBy(xpath = "//input[@name='city']")
    WebElement textbox_City;

    @FindBy(xpath = "//input[@name='zip']")
    WebElement textbox_PostCode;

    @FindBy(xpath = "//input[@name='state']")
    WebElement textbox_State;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement button_Save;

    @FindBy(xpath = "//div[@class='visible menu transition']")
    WebElement item_EmailOption;

    public ComposeEmail(WebDriver driver){ this.driver=driver; }

    public void insert_Receiver(String reciever){ textbox_To.sendKeys(reciever);}

    public void insert_Cc(String mailCC){
        textbox_Cc.sendKeys(mailCC);
    }

    public void insert_BCc(String mailBcc){
        textbox_BCc.sendKeys(mailBcc);
    }

    public void insert_Subject(String subject){
        textbox_Subject.sendKeys(subject);
    }

    public void click_Back(){
        button_Back.click();
    }

    public void click_ConnectToEmail(){
        button_ConnectToEmail.click();
    }

    public void click_MyCompanyOption(){
        select_MyCompanyOption.click();
    }

    public void insert_Address(String address){
        textbox_Address.sendKeys(address);
    }

    public void insert_City(String cityname){
        textbox_City.sendKeys(cityname);
    }

    public void insert_PostCode(String postcode){
        textbox_PostCode.sendKeys(postcode);
    }

    public void insert_State(String state){
        textbox_State.sendKeys(state);
    }

    public void click_Save(){
        button_Save.click();
    }


    public void createNewEmail(String subject,String receiver){

        insert_Subject(subject);
        insert_Receiver(receiver);

    }

    public List<String> getSuggestedContactName(){


//        FluentWait<WebDriver> fluentWait = new FluentWait(driver).withTimeout(Duration().pollingEvery().ignoring(NoSuchElementException.class);
//        WebElement suggested_ContactNames = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span[1]")));
//        System.out.println("Suggested name clicked");
//        return suggested_ContactNames.getText();

//        List<String> suggestedContactNames = suggested_ContactNames.stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> suggestedContactList = new ArrayList<String>();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']//span[1]")));

        for (WebElement element : suggested_ContactNames) {
            suggestedContactList.add(element.getText());
            System.out.println(element.getText());
        }

        return suggestedContactList;
        }

    }

