package com.TestCases;



import com.Pages.Company.CompanyPage;
import com.Pages.Company.CreateNewCompany;
import com.Pages.Company.NewCompanyPage;
import com.Pages.HomePage;
import com.Pages.LoginPage;

import com.Utility.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_1 extends WebDriverManager {

    public static String expectedCompanyName;

    @Test
    public void testCase1(){

//        log in
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); //create an instance of Login class and use it to refer its objects.
        loginPage.set_Username_and_Password("skiriwattuduwa@gmail.com","shAmi@123");
        HomePage homePage = loginPage.clickLogin();
        System.out.println("Login Page Executed in testcase 1");

//        navigate to company page
        CompanyPage companyPage=homePage.navigateToCompanyPage();

//        navigate to create new company
        CreateNewCompany createnewcompany=companyPage.navigateToCreateNewCompany();

//        add a new company
        createnewcompany.createNewCompany("Company123","company.com","No.1,Company Address","City","Country","12418","1234567890","0987654321","Description");
        System.out.println("New Company added");

        expectedCompanyName="company123";

//        navigate to new company page
        NewCompanyPage newCompanyPage=createnewcompany.navigateToNewCompanyPage();

//        assert on the new company page
        Assert.assertEquals(newCompanyPage.addedCompany(),expectedCompanyName);
        System.out.println("Verification passed at new company page");

//        navigate to company page
        homePage.navigateToCompanyPage();


//        assert added company name from company list
        Assert.assertTrue(companyPage.getCompanyNames().contains(expectedCompanyName));
        System.out.println("Verification passed at company page");

//error - company page is not loading




//        Assert.assertEquals();

    }
}
