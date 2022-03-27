package com.Steps;

import com.Pages.Contact.ContactPage;
import com.Pages.Contact.CreateNewContact;
import com.Pages.Contact.NewContactPage;
import com.Pages.HomePage;
import com.Utility.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyStepDefinitions_Add_New_Contact {

    public static WebDriver driver;
    public WebDriverManager webDriverManager;
    public static String expectedHomePageTitle;
    public static String actualHomePageTitle;
    public static String expectedContactMiddleName;
    public static String actualContactMiddleName;
    public static String expectedContactName;


    @Given("user in the homepage")
    public void userInTheHomepage() {

        HomePage homePage= PageFactory.initElements(webDriverManager.getDriver(),HomePage.class);
        actualHomePageTitle=homePage.homePageTitle();
        expectedHomePageTitle="Cogmento CRM";
        Assert.assertEquals(actualHomePageTitle,expectedHomePageTitle);
        System.out.println("Home page title verified, you are in the home page");

    }

    @When("user navigate to contact page")
    public void userNavigateToContactPage() {

        HomePage homePage= PageFactory.initElements(webDriverManager.getDriver(),HomePage.class);
        homePage.navigateToContactPage();
        System.out.println("Navigate to contact page");
    }

    @And("user navigate to create new contact")
    public void userNavigateToCreateNewContact() {
        ContactPage contactPage= PageFactory.initElements(webDriverManager.getDriver(),ContactPage.class);
        contactPage.navigateToCreateNewContact();
        System.out.println("Navigate to create new contact page");
    }

    @And("user create a new contact first name as {string} middle name as {string} last name as {string} company name as {string} email as {string}")
    public void userCreateANewContactFirstNameAsMiddleNameAsLastNameAsCompanyNameAsEmailAs(String firstName, String middleName, String lastName, String companyName, String email) {
       CreateNewContact createNewContact = PageFactory.initElements(webDriverManager.getDriver(),CreateNewContact.class);
       createNewContact.addNewContact(firstName,middleName,lastName,companyName,email);
       System.out.println("New contact added");
    }

    @And("user save the created contact")
    public void userSaveTheCreatedContact() {
        CreateNewContact createNewContact = PageFactory.initElements(webDriverManager.getDriver(),CreateNewContact.class);
        createNewContact.navigateToNewContactPage();
        System.out.println("New contact saved successfully");
    }

    @Then("user able to view created contact")
    public void userAbleToViewCreatedContact() {
       expectedContactMiddleName ="Sajeewa";
       NewContactPage newContactPage=PageFactory.initElements(webDriverManager.getDriver(),NewContactPage.class);
       actualContactMiddleName =newContactPage.createdContactMiddleName();
       Assert.assertEquals(actualContactMiddleName, expectedContactMiddleName);
       System.out.println("Verification passed on contact page");

    }

    @When("user navigate to home page")
    public void userNavigateToHomePage() {
        HomePage homePage= PageFactory.initElements(webDriverManager.getDriver(),HomePage.class);
        homePage.navigateToHomePage();
        System.out.println("Now you are in the home page");
    }

    @Then("user can view added contact details")
    public void userCanViewAddedContactDetails() {
        expectedContactName="Shamika Sajeewa Kiriwaththuduwa";
        HomePage homePage=PageFactory.initElements(webDriverManager.getDriver(),HomePage.class);
        Assert.assertTrue(homePage.getContactNames().contains(expectedContactName),"Added contact name verified at Home Page");

    }

    @And("user close the browser")
    public void userCloseTheBrowser() {
        webDriverManager.browserTearDown();
    }


}
