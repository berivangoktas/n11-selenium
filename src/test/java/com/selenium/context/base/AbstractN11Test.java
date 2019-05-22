package com.selenium.context.base;

import com.selenium.pages.LoginPage;
import com.selenium.pages.UrlFactory;

public class AbstractN11Test extends AbstractWebTest
{
    private LoginPage loginPage;


    protected void login(String username, String password)
    {
        if (loginPage == null) loginPage = new LoginPage(driver);

        navigateToURL(UrlFactory.LOGIN_URL);
        waitAndSendKeys(loginPage.emailText, username);
        waitAndSendKeys(loginPage.passwordText, password);
        waitAndClick(loginPage.loginButton);
    }

}
