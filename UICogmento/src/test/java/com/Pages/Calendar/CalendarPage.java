package com.Pages.Calendar;

import com.Utility.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CalendarPage extends WebDriverManager {

    WebDriver driver;
    JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;

    @FindBy(xpath="//a[text()='Manage Calendars']")
    WebElement link_ManageCalender;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement button_ClosePopup;

    @FindBy(xpath = "//i[@type='button' or  @class='chevron left icon']")
    WebElement button_MoveBack;

    @FindBy(xpath = "//i[@class='chevron right icon']")
    WebElement button_MoveForward;

    @FindBy(xpath = "//span[text()='Week']")
    WebElement button_ByWeek;

    @FindBy(xpath = "//span[text()='Day']")
    WebElement button_ByDay;

    @FindBy(xpath = "//span[text()='Agenda']")
    WebElement button_ByAgenda;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement button_CreateNewOnCalendarPage;



    public CalendarPage(WebDriver driver){
        driver=driver;
    }

    public void calendarPageScroll(){

        jsexecutor.executeScript("window.scrollBy(0,400)");     //scrolled by 400 pixels vertically
    }

    public void click_MoveBack(){ button_MoveBack.click(); }

    public void click_MoveForward(){button_MoveForward.click();}

    public void click_ByWeek(){button_ByWeek.click(); }

    public void click_ByDay(){ button_ByDay.click(); }

    public void click_ByAgenda(){ button_ByAgenda.click(); }

    public void click_CreateNewEvent(){ button_CreateNewOnCalendarPage.click(); }

//    public void selectOptionWithText(String textToSelect) {
//        try {
//            try {
//                WebElement autoOptions = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[8]/div[2]/div/div"));
//                wait();
//                ExpectedConditions.visibilityOf(ByParticipant);
//
//                List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
//                for(WebElement option : optionsToSelect){
//                    if(option.getText().equals(textToSelect)) {
//                        System.out.println("Trying to select: "+textToSelect);
//                        option.click();
//                        break;
//                    }
//                }
//
//            } catch (NoSuchElementException e) {
//                System.out.println(e.getStackTrace());
//            }
//            catch (Exception e) {
//                System.out.println(e.getStackTrace());
//            }
//        }

    public CreateNewEvent navigateToCreateNewEvent(){
        click_CreateNewEvent();
        return PageFactory.initElements(driver,CreateNewEvent.class);
    }

}


