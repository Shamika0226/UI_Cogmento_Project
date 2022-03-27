package com.Pages;



import com.Utility.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends WebDriverManager {



    @FindBy(xpath = "//input[@placeholder='E-mail address']")
    WebElement textbox_Username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement textbox_Password;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement button_Login;

    public LoginPage(WebDriver driver){ this.driver=driver;     // to get the driver object
                                                                // use with @FindBy annotation
                                                                //initElement can initialize all the elements captured by FindBy
                                                                // creates the findElement calls behind the scene.
    }


    public void type_Username(String username){textbox_Username.sendKeys(username); }

    public void type_Password(String password){textbox_Password.sendKeys(password);}

    public void click_LoginButton(){button_Login.click();}

    public void set_Username_and_Password(String username, String password){
        type_Username(username);
        type_Password(password);
    }

    public HomePage clickLogin(){

            click_LoginButton();
            return PageFactory.initElements(driver, HomePage.class);
    }


}
