package com.Steps;


import com.Pages.Company.CompanyPage;
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

public class MyStepDefinitions_View_Added_Company {

    public static WebDriver driver;
    public WebDriverManager webDriverManager;
    public static String expectedCompanyName;
    public static String actualCompanyName;

    @Given("user successfully logged in now in the homepage")
    public void userSuccessfullyLoggedInNowInTheHomepage() {
        System.out.println("Now you are in the home page");

    }

    @When("user navigate to the contact page")
    public void userNavigateToTheContactPage() {
        HomePage homePage = PageFactory.initElements(webDriverManager.getDriver(),HomePage.class);
        homePage.navigateToContactPage();
        System.out.println("Navigate to contact page");
    }

    @And("user navigate to the create new contact page")
    public void userNavigateToTheCreateNewContactPage() {
        ContactPage contactPage= PageFactory.initElements(webDriverManager.getDriver(),ContactPage.class);
        contactPage.navigateToCreateNewContact();
        System.out.println("Navigate to create new contact page");
    }

    @And("user create a new contact first name as {string} middle name as {string} last name as {string} new company name as {string} email as {string}")
    public void userCreateANewContactFirstNameAsMiddleNameAsLastNameAsNewCompanyNameAsEmailAs(String firstName, String middleName, String lastName, String companyName, String email) {
        CreateNewContact createNewContact=PageFactory.initElements(webDriverManager.getDriver(),CreateNewContact.class);
        createNewContact.addNewContact(firstName,middleName,lastName,companyName,email);
        System.out.println("New contact added");
    }

    @And("user save created contact")
    public void userSaveCreatedContact() {
        CreateNewContact createNewContact=PageFactory.initElements(webDriverManager.getDriver(),CreateNewContact.class);
        createNewContact.navigateToNewContactPage();
        System.out.println("New contact saved successfully");
    }

    @Then("user able to view created contact with new company name as {string}")
    public void userAbleToViewCreatedContactWithNewCompanyNameAs(String companyName) {
        NewContactPage newContactPage=PageFactory.initElements(webDriverManager.getDriver(),NewContactPage.class);
        expectedCompanyName=companyName;
        actualCompanyName=newContactPage.createdCompanyName();
        Assert.assertEquals(actualCompanyName,expectedCompanyName);
        System.out.println("verification passed at contact page!");

    }

    @When("user navigate to company page")
    public void userNavigateToCompanyPage() {
        HomePage homePage = PageFactory.initElements(webDriverManager.getDriver(),HomePage.class);
        homePage.navigateToCompanyPage();
        System.out.println("Navigate to company dashboard");
    }

    @Then("user able to view added company name from company page")
    public void userAbleToViewAddedCompanyNameFromCompanyPage() {
        CompanyPage companyPage=PageFactory.initElements(webDriverManager.getDriver(),CompanyPage.class);
        Assert.assertTrue(companyPage.getCompanyNames().contains(expectedCompanyName),"Verification Passed at company page");
    }

    @And("user close chrome browser")
    public void userCloseChromeBrowser() {
        webDriverManager.browserTearDown();
    }
}
