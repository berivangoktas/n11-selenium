package com.selenium.context.manager;

import com.selenium.AbstractTest;
import com.selenium.context.Configuration;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class DriverManager extends AbstractTest
{
    protected static RemoteWebDriver driver;
    protected static Configuration configuration;
    public static String session;

    protected void createDriver() {}

    public RemoteWebDriver getDriver() throws Exception
    {
        if (driver == null)
        {
            configuration  = new Configuration();

            createDriver();
        }
        return driver;
    }
}
