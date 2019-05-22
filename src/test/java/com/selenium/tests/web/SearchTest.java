package com.selenium.tests.web;

import com.selenium.annotations.Description;
import com.selenium.context.base.AbstractN11Test;
import com.selenium.pages.SearchPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchTest extends AbstractN11Test
{
    private SearchPage searchPage;

    @Before
    public void init() throws Exception
    {
        super.init();
        searchPage = new SearchPage(driver);
    }


    @Description("Search alanına iphone yazarak ilanların geldiğini kontrol eder")
    @Test
    public void testSuccessSearch()
    {
        waitAndSendKeys(searchPage.searchText, "iphone");
        waitAndClick(searchPage.searchButton);
        Assert.assertTrue(searchPage.searchResultDetail.size() > 0);
    }

    @Description("Search alanına sonuç gelemyen bir kelime yazarak, arama sonuç gelmediğini kontrol eder.")
    @Test
    public void testNotFound()
    {
        waitAndSendKeys(searchPage.searchText, "dsf");
        waitAndClick(searchPage.notFoundSearch);
        Assert.assertTrue(searchPage.notFoundSearch.isDisplayed());
    }


}
