package com.TestCases;


import com.Pages.*;
import com.Pages.Company.CompanyPage;
import com.Pages.Contact.ContactPage;
import com.Pages.Contact.CreateNewContact;
import com.Pages.Contact.NewContactPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_3{

    public static WebDriver driver;
    public static String expectedCompanyName;

    public TC_3(WebDriver driver) {
        this.driver=driver;
    }

    @Test
    public void testcase3() {
//        log in
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); //create an instance of Login class and use it to refer its objects.
        loginPage.set_Username_and_Password("skiriwattuduwa@gmail.com","shAmi@123");
        HomePage homePage = loginPage.clickLogin();
        System.out.println("Login Page Executed in testcase 3");

        System.out.println("Title of home page : "+driver.getTitle());

//        navigate to contact page
        ContactPage contactPage=homePage.navigateToContactPage();
        System.out.println("Navigate to contact page");

//        navigate to create new contact page
        CreateNewContact createnewcontact=contactPage.navigateToCreateNewContact();

//        create new contact and save
        createnewcontact.addNewContact("Shamika","Sajeewa","Kiriwaththuduwa","CompanyXYZ","shamika1@gmail.com");
        System.out.println("New contact added");

//        navigate to new contact page
        NewContactPage newContactPage=createnewcontact.navigateToNewContactPage();
        expectedCompanyName ="CompanyXYZ";

//        assert on new contact page
        Assert.assertEquals(newContactPage.createdCompanyName(), expectedCompanyName);
        System.out.println("verification passed at contact page!");

//        CompanyPage companyPage=newContactPage.naviagateToCompanyFromContact();
//        System.out.println("Navigate to company dashboard");

//        navigate to company page
        CompanyPage companyPage=homePage.navigateToCompanyPage();
        System.out.println("Navigate to company dashboard");

//        assert on the company page
        Assert.assertTrue(companyPage.getCompanyNames().contains(expectedCompanyName));
        System.out.println("Assertion Passed on company page");

    }


}
