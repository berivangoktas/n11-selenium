package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageObject
{
    public SearchPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(id = "searchData")
    public WebElement searchText;

    @FindBy(css = "#iconSearch")
    public WebElement searchButton;

    @FindBy(css = "#notFoundContainer")
    public WebElement notFoundSearch;

    @FindBy(xpath = "//div[@class='columnContent adBg']")
    public List<WebElement> searchResultDetail;

}
