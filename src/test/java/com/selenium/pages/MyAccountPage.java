package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject
{
    public MyAccountPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Hesabım']")
    public WebElement myAccountTab;
}
