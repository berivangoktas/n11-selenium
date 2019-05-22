package com.selenium.pages;


public enum UrlFactory
{

    MAIN_URL("https://www.n11.com/"),
    LOGIN_URL(MAIN_URL, "/giris-yap");

    //-----

    public final String pageUrl;

    UrlFactory(String pageUrl)
    {
        this.pageUrl = pageUrl;
    }

    UrlFactory(UrlFactory baseUrl, String pageUrl)
    {
        this.pageUrl = baseUrl.pageUrl + pageUrl;
    }

}
