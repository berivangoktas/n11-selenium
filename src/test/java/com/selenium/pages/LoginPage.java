package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='btnSignIn']")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailText;

    @FindBy(id = "password")
    public WebElement passwordText;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@data-errormessagefor='password']/div")
    public WebElement errormessageForLoginPage;

    @FindBy(xpath = "//div[@data-errormessagefor='email']/div")
    public WebElement emptyUserNameWarningMessage;

    @FindBy(xpath = "//div[@data-errormessagefor='password']/div")
    public WebElement emptyPasswordWarningMessage;

}
