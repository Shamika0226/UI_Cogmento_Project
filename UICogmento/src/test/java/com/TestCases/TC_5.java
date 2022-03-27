package com.TestCases;

import com.Pages.*;
import com.Pages.Calendar.CalendarPage;
import com.Pages.Calendar.CreateNewEvent;
import com.Pages.Contact.ContactPage;
import com.Pages.Contact.CreateNewContact;
import com.Utility.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5 extends WebDriverManager {

    public static String expectedContactName;

    @Test
    public void testcase5(){
        //log in
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); //create an instance of Login class and use it to refer its objects.
        loginPage.set_Username_and_Password("skiriwattuduwa@gmail.com","shAmi@123");
        HomePage homePage = loginPage.clickLogin();
        System.out.println("Login Page Executed in testcase 5");

        //navigate to contact page
        ContactPage contactPage=homePage.navigateToContactPage();

        //navigate to create new contact page
        CreateNewContact createnewcontact=contactPage.navigateToCreateNewContact();

        //create a new contact and save
        createnewcontact.addNewContact("Shamika","Sajeewa","Kiriwaththuduwa","Company123","shamika123@gmail.com");
        System.out.println("New Contact created");

        //navigate to calendar page
        CalendarPage calendarPage=homePage.navigateToCalendarPage();
        System.out.println("Navigate to calendar page");

        //navigate to create new event page
        CreateNewEvent createnewevent=calendarPage.navigateToCreateNewEvent();
        System.out.println("Navigate to create new event");

        //enter title and participant's name
        createnewevent.createNewCalendarEvent("I am Title","Shamika");
        System.out.println("New event created");
        expectedContactName="Shamika Sajeewa Kiriwaththuduwa";


        //assert suggested contact names in the participants field
        Assert.assertTrue(createnewevent.getSuggestedContactName().contains(expectedContactName));
        System.out.println("Verification passed!!!");

        //error - Null pointer exception

    }
}
