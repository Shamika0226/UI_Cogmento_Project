package com.TestCases;


import com.Pages.*;
import com.Pages.Contact.ContactPage;
import com.Pages.Contact.CreateNewContact;
import com.Pages.Email.ComposeEmail;
import com.Pages.Email.EmailPage;
import com.Utility.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_4 extends WebDriverManager {

    private static String expectedContactName;


    @Test
    public void testcase4(){
//        log in
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); //create an instance of Login class and use it to refer its objects.
        loginPage.set_Username_and_Password("skiriwattuduwa@gmail.com","shAmi@123");
        HomePage homePage = loginPage.clickLogin();
        System.out.println("Login Page Executed in testcase 4");

//        navigate to contact page
        ContactPage contactPage=homePage.navigateToContactPage();
        System.out.println("Navigate to contact page");

//        navigate to create new contact page
        CreateNewContact createnewcontact=contactPage.navigateToCreateNewContact();

//        create new contact and save
        createnewcontact.addNewContact("Shamika","Sajeewa","Kiriwaththuduwa","Company123","shamika123@gmail.com");
        System.out.println("New contact created");

//        navigate to email page
        EmailPage emailPage=homePage.navigateToEmailPage();
        System.out.println("navigate to email page");

//        navigate to compose email page
        ComposeEmail composeEmail=emailPage.navigateToComposeEmailPage();
        System.out.println("Navigate to compose email page");

//        enter title and To fields and capture suggested contact names
        composeEmail.createNewEmail("I am the subject","Shamika");
        System.out.println("Subject and To field completed");


        expectedContactName="Shamika Sajeewa Kiriwaththuduwa [ shamika123@gmail.com]";

//        assert on the compose email page
        Assert.assertTrue(composeEmail.getSuggestedContactName().contains(expectedContactName));
        System.out.println("Assertion Passed!!!");


        //suggested name not return
    }

}
