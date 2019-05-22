package com.selenium.context.manager;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManagerWeb extends DriverManager
{
    private static final Logger logger = Logger.getLogger(FirefoxDriverManagerWeb.class);

    private FirefoxOptions firefoxOptions;
    private DesiredCapabilities desiredCapabilities;

    @Override
    public void createDriver()
    {
        firefoxOptions = firefoxOptins();

        desiredCapabilities = desiredCapabilities(firefoxOptions);

        if (Platform.getCurrent().is(Platform.MAC))
        {
            System.setProperty("webdriver.gecko.driver", configuration.getMacFirefoxDriver());
        }
        else if (Platform.getCurrent().is(Platform.WINDOWS))
        {
            System.setProperty("webdriver.gecko.driver", configuration.getWindowsFirefoxDriver());
        }

        driver = new FirefoxDriver(desiredCapabilities);

        session = (driver).getSessionId().toString();
        logger.info("=================================================================");
        logger.info("=====> This Execute Session ID --> " + session);
    }

    private DesiredCapabilities desiredCapabilities(FirefoxOptions firefoxOptions)
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(ChromeOptions.CAPABILITY, firefoxOptions);

        return capabilities;
    }

    private FirefoxOptions firefoxOptins()
    {
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        return firefoxOptions;
    }

}
