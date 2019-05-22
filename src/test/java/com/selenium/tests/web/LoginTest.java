package com.selenium.tests.web;

import com.selenium.annotations.Description;
import com.selenium.context.base.AbstractN11Test;
import com.selenium.pages.LoginPage;
import com.selenium.pages.MyAccountPage;
import com.selenium.pages.UrlFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LoginTest extends AbstractN11Test
{
    private MyAccountPage myAccountPage;
    private LoginPage loginPage;
    private static final String ERROR_MESSAGE_FOR_WRONG_DATA = "E-posta adresiniz veya şifreniz hatalı";
    private static final String ERROR_MESSAGE_FOR_EMPTY_USERNAME = "Lütfen e-posta adresinizi girin.";
    private static final String ERROR_MESSAGE_FOR_EMPTY_PASSWORD = "Bu alanın doldurulması zorunludur.";

    @Before
    public void init() throws Exception
    {
        super.init();
        myAccountPage = new MyAccountPage(driver);
        loginPage = new LoginPage(driver);

        navigateToURL(UrlFactory.MAIN_URL);
    }


    @Description("Başarılı şekilde login olduğunun kontorlü")
    @Test
    public void testSuccessLogin()
    {
        Assert.assertTrue(driver.manage().getCookieNamed("ajs_user_id").getValue().equals("null"));

        login(configuration.getTestEmail(), configuration.getTestPassword());

        waitElementVisible(myAccountPage.myAccountTab);
        Assert.assertTrue("my Account tab not display", isDisplayed(myAccountPage.myAccountTab));
        Assert.assertTrue("my Account tab not display", isTextDisplayedOnPage(configuration.getTestUserName()));

        Assert.assertNotNull(driver.manage().getCookieNamed("legalAgreement_display"));
        Assert.assertNotNull(driver.manage().getCookieNamed("isMember"));
        Assert.assertNotNull(driver.manage().getCookieNamed("captchaID"));
        Assert.assertNotNull(driver.manage().getCookieNamed("ajs_user_id"));

    }

    @Description("Yanlış kullanıcı adı ile login olma kontrolü")
    @Test
    public void testLoginWithWrongUserName()
    {
        login(configuration.getTestWrongEmail(), configuration.getTestPassword());
        Assert.assertTrue(loginPage.errormessageForLoginPage.getText().equals(ERROR_MESSAGE_FOR_WRONG_DATA));
    }

    @Description("Yanlış password ile login olma kontrolü")
    @Test
    public void testLoginWithWrongPassword()
    {
        login(configuration.getTestEmail(), configuration.getTestWrongPassword());
        Assert.assertTrue(loginPage.errormessageForLoginPage.getText().equals(ERROR_MESSAGE_FOR_WRONG_DATA));
    }

    @Description("Yanlış password ile login olma kontrolü")
    @Test
    public void testLoginWithEmptyUserNameAndPassword()
    {
        login("", "");

        waitElementVisible(loginPage.emptyUserNameWarningMessage);
        Assert.assertTrue(loginPage.emptyUserNameWarningMessage.getText().equals(ERROR_MESSAGE_FOR_EMPTY_USERNAME));
        Assert.assertTrue(loginPage.emptyPasswordWarningMessage.getText().equals(ERROR_MESSAGE_FOR_EMPTY_PASSWORD));
    }


}
