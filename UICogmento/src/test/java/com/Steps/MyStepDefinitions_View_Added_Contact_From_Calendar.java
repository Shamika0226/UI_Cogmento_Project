package com.Steps;

import com.Pages.Calendar.CalendarPage;
import com.Pages.Calendar.CreateNewEvent;
import com.Pages.HomePage;
import com.Utility.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyStepDefinitions_View_Added_Contact_From_Calendar {
    public WebDriverManager webDriverManager;
    private String expectedContactName;

    @When("user navigate to calendar page")
    public void userNavigateToCalendarPage() {
        HomePage homePage= PageFactory.initElements(webDriverManager.getDriver(),HomePage.class);
        homePage.navigateToCalendarPage();
        System.out.println("Now you are in the calendar page");
    }

    @And("user navigate to create new event page")
    public void userNavigateToCreateNewEventPage() {
        CalendarPage calendarPage=PageFactory.initElements(webDriverManager.getDriver(),CalendarPage.class);
        calendarPage.navigateToCreateNewEvent();
        System.out.println("Now you are in the create new event page");
    }

    @And("user enter event title as {string} and participants as {string}")
    public void userEnterEventTitleAsAndParticipantsAs(String title, String participants) {
        CreateNewEvent createNewEvent =PageFactory.initElements(webDriverManager.getDriver(),CreateNewEvent.class);
        createNewEvent.createNewCalendarEvent(title,participants);

    }

    @Then("user able to select added contact name from participant field")
    public void userAbleToSelectAddedContactNameFromParticipantField() {
        CreateNewEvent createNewEvent =PageFactory.initElements(webDriverManager.getDriver(),CreateNewEvent.class);
        System.out.println("Suggested contact names : "+createNewEvent.getSuggestedContactName());
        expectedContactName="Shamika Sajeewa Kiriwaththuduwa";
        Assert.assertTrue(createNewEvent.getSuggestedContactName().contains(expectedContactName));
        System.out.println("Assertion Passed!!!");


    }
}
