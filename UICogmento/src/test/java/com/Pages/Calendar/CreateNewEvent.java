package com.Pages.Calendar;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.List;

public class CreateNewEvent{
    WebDriver driver;

    @FindBy(xpath = "//textarea[@name='location']")
    WebElement textbox_Location;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement textbox_Description;

    @FindBy(xpath="//input[@name='title']")
    WebElement textbox_Title;

    @FindBy(xpath = "//*/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement textbox_StartDate;

    @FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--018']")
    WebElement select_StartDate;

    @FindBy(xpath = "//li[text()='00:15']")
    WebElement select_StartTime;

    @FindBy(xpath = "//*/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]")
    WebElement textbox_EndDate;

    @FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--019']")
    WebElement select_EndDate;

    @FindBy(xpath = "//li[text()='12:00']")
    WebElement select_EndTime;

    @FindBy(xpath = "//div[@class='ui toggle checkbox']")
    WebElement checkbox_AllDay;

    @FindBy(xpath="//div[@name='minutesBefore']")
    WebElement dropdown_AllertBefore;

    @FindBy(xpath = "//span[text()='1 Hour']")
    WebElement select_OneHour;

    @FindBy(xpath = "//button[@class='ui button']")
    WebElement button_CancelOnCalendarPage;

    @FindBy(xpath = "//div[@name='participants']//input")
    WebElement addParticipants;

    @FindBy(xpath = "//div[@name='participants']//div//div[2]")
    List<WebElement> suggestedContactNames;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement button_Save;

    public CreateNewEvent(WebDriver driver) {
        this.driver = driver;
    }

    public void insert_Location(String location){ textbox_Location.sendKeys(location);}

    public void insert_Description(String description){textbox_Description.sendKeys(description); }

    public void insert_Title(String title){ textbox_Title.sendKeys(title); }

    public void click_StartDate(){ textbox_StartDate.click(); }

    public void selectOn_StartDate(){ select_StartDate.click(); }

    public void selectOn_StartTime(){select_StartTime.click(); }

    public void click_EndDate(){textbox_EndDate.click(); }

    public void selectOn_EndDate(){select_EndDate.click(); }

    public void selectOn_EndTime(){ select_EndTime.click(); }

    public void checkbox_AllDay(){ checkbox_AllDay.click(); }

    public void dropdown_AllertBefore(){ dropdown_AllertBefore.click(); }

    public void select_OneHour(){select_OneHour.click(); }

    public void click_CancelOnCalendarPage(){ button_CancelOnCalendarPage.click(); }

    public void selectParticipants(String participants){ addParticipants.sendKeys(participants);}

    public void click_Save(){ button_Save.click();}

    public void createNewCalendarEvent(String title, String participants){

        insert_Title(title);
//        click_StartDate();
//        selectOn_StartDate();
//        selectOn_StartTime();
//        click_EndDate();
//        selectOn_EndDate();
//        selectOn_EndTime();
//        insert_Description(description);
//        insert_Location(location);
//        calendarPageScroll();
//        dropdown_AllertBefore();
//        select_OneHour();
        selectParticipants(participants);
//        click_Save();

    }

    public List<String> getSuggestedContactName(){
        List<String> contactNamesList = new ArrayList<String>();
        for (WebElement element : suggestedContactNames ) {
            contactNamesList.add(element.getText());
//            System.out.println(element.getText());
        }
//        for(String names : contactNamesList) {
//            System.out.println("Element of the list into String format : "+names);
//        }
        return contactNamesList;
    }
}
