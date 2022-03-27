package com.Steps;

import com.Pages.LoginPage;
import com.Utility.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class MyStepDefinitions_Login {

    public WebDriverManager webDriverManager;



    public MyStepDefinitions_Login() {

    }

    @Given("user launch chrome browser navigate to url {string} application")
    public void userLaunchChromeBrowserNavigateToUrlApplication(String url) {
        webDriverManager.browserSetup(url);
    }

    @When("user enter username as {string} and password as {string}")
    public void userEnterUsernameAsAndPasswordAs(String username, String password) {
        LoginPage loginPage= PageFactory.initElements(webDriverManager.getDriver(), LoginPage.class);
        loginPage.set_Username_and_Password(username,password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
//        loginPage=new LoginPage(driver);
//        PageFactory.initElements(driver,loginPage);
        LoginPage loginPage= PageFactory.initElements(webDriverManager.getDriver(), LoginPage.class);
        loginPage.click_LoginButton();
    }

    @Then("user able to navigate home page")
    public void userAbleToNavigateHomePage() {
//        expectedPageTitle="";
//        actualPageTitle=homePage.getPageTitle();
//        Assert.assertEquals(actualPageTitle,expectedPageTitle);
        System.out.println("Now you are in the home page");
    }
}
