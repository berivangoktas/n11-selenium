package com.selenium.context.base;

import com.selenium.context.manager.DriverManager;
import com.selenium.pages.UrlFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractSeleniumTest extends DriverManager implements Commons
{
    protected static final int DEFAULT_SLEEP = 1;
    protected static final int DEFAULT_MEDIUM_SLEEP = 5;
    protected static final int DEFAULT_LARGE_SLEEP = 10;

    @Override
    public void navigateToURL(UrlFactory url)
    {
        driver.manage().timeouts().pageLoadTimeout(configuration.getPageLoadTimeout(), TimeUnit.MINUTES);
        driver.navigate().to(url.pageUrl);
        sleep(DEFAULT_SLEEP);
    }

    @Override
    public void waitAndClick(WebElement element)
    {
        waitElementToBeClickable(element);
        element.click();
    }

    @Override
    public void selectOptionValue(WebElement element, String itemValue)
    {
        waitElementVisible(element);
        new Select(element).selectByValue(itemValue);
    }

    @Override
    public void waitAndSendKeys(WebElement element, String text)
    {
        waitElementVisible(element);
        element.sendKeys(text);
    }

    @Override
    public void waitElementToBeClickable(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, configuration.getWaitLoadTimeout());
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Override
    public void waitElementVisible(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, configuration.getWaitLoadTimeout());
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    @Override
    public String getText(WebElement element)
    {
        return element.getText();
    }

    @Override
    public void sleep(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000);
        }
        catch (Exception ex)
        {
        }

    }

}
