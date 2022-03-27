package com.TestCases;


import com.Pages.*;
import com.Pages.Contact.ContactPage;
import com.Pages.Contact.CreateNewContact;
import com.Pages.Contact.NewContactPage;
import com.Utility.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;




public class TC_2 extends WebDriverManager {

    private static String expectedContactName1;
    private static String expectedContactName2;


    @Test
    public void testcase2(){
//        log in
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); //create an instance of Login class and use it to refer its objects.
        loginPage.set_Username_and_Password("skiriwattuduwa@gmail.com","shAmi@123");
        HomePage homePage = loginPage.clickLogin();
        System.out.println("Login Page Executed in testcase 2");

//        navigate to contact page
        ContactPage contactPage=homePage.navigateToContactPage();
        System.out.println("Now you are in the contact page");

//        navigate to create new contact page
        CreateNewContact createnewcontact=contactPage.navigateToCreateNewContact();

//        create a new contact and save
        createnewcontact.addNewContact("Shamika","Sajeewa","Kiriwaththuduwa","Company123","shamika1@gmail.com");
        System.out.println("New contact created successfully");

//        navigate to new contact page
        NewContactPage newContactPage=createnewcontact.navigateToNewContactPage();

        String expectedContactName=newContactPage.createdContactMiddleName();
        System.out.println("Expected name: "+expectedContactName);
        expectedContactName1 ="Sajeewa";

//        assert on the create new contact page
        Assert.assertEquals(expectedContactName1,expectedContactName);
        System.out.println("Verification passed on contact page");

        System.out.println("New contact added");

//        navigate to home dashboard
        homePage.navigateToHomePage();
        System.out.println("Now you are in the home page");

        expectedContactName2 ="Shamika Sajeewa Kiriwaththuduwa";

//        assert contact name in the home dashboard
        Assert.assertTrue(homePage.getContactNames().contains(expectedContactName2));
        System.out.println("Assertion passed");

    }
}
