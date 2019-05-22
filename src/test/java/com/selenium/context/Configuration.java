package com.selenium.context;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class Configuration
{
    private static final Logger logger = Logger.getLogger(Configuration.class);

    private Properties configProps = new Properties();

    private String browserType;
    private Integer pageLoadTimeout;
    private Integer waitLoadTimeout;
    private Integer implicitlyWait;
    private String macChromeDriver;
    private String windowsChromeDriver;
    private String macFirefoxDriver;
    private String windowsFirefoxDriver;
    private String testResultReport;
    private String testEmail;
    private String testPassword;
    private String testUserName;
    private String testWrongEmail;
    private String testWrongPassword;

    public Configuration() throws IOException
    {
        loadConfigProperties();

        this.browserType = System.getProperties().getProperty("browser.type");

        this.pageLoadTimeout = Integer.valueOf(configProps.getProperty("page.load.timeout"));
        this.waitLoadTimeout = Integer.valueOf(configProps.getProperty("wait.timeout.seconds"));
        this.implicitlyWait = Integer.valueOf(configProps.getProperty("implicitly.wait"));
        this.macChromeDriver = configProps.getProperty("mac.chrome.driver");
        this.windowsChromeDriver = configProps.getProperty("windows.chrome.driver");
        this.testResultReport = configProps.getProperty("test.result.report");
        this.macFirefoxDriver = configProps.getProperty("mac.firefox.driver");
        this.windowsFirefoxDriver = configProps.getProperty("windows.firefox.driver");

        this.testEmail = configProps.getProperty("test.mail.address");
        this.testPassword = configProps.getProperty("test.mail.address.password");
        this.testUserName = configProps.getProperty("test.user.userName");
        this.testWrongEmail = configProps.getProperty("test.mail.wrong.address");
        this.testWrongPassword = configProps.getProperty("test.mail.address.wrong.password");
    }

    private void loadConfigProperties() throws IOException
    {
        String configFile = "config.properties";
        InputStream in = ClassLoader.getSystemResourceAsStream(configFile);

        configProps.load(new InputStreamReader(in, Charset.forName("UTF-8")));
    }

    public String getBrowserType()
    {
        return browserType;
    }

    public void setBrowserType(String browserType)
    {
        this.browserType = browserType;
    }

    public Integer getPageLoadTimeout()
    {
        return pageLoadTimeout;
    }

    public void setPageLoadTimeout(Integer pageLoadTimeout)
    {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public Integer getWaitLoadTimeout()
    {
        return waitLoadTimeout;
    }

    public void setWaitLoadTimeout(Integer waitLoadTimeout)
    {
        this.waitLoadTimeout = waitLoadTimeout;
    }

    public Integer getImplicitlyWait()
    {
        return implicitlyWait;
    }

    public void setImplicitlyWait(Integer implicitlyWait)
    {
        this.implicitlyWait = implicitlyWait;
    }

    public String getMacChromeDriver()
    {
        return macChromeDriver;
    }

    public void setMacChromeDriver(String macChromeDriver)
    {
        this.macChromeDriver = macChromeDriver;
    }

    public String getWindowsChromeDriver()
    {
        return windowsChromeDriver;
    }

    public void setWindowsChromeDriver(String windowsChromeDriver)
    {
        this.windowsChromeDriver = windowsChromeDriver;
    }

    public String getTestResultReport()
    {
        return testResultReport;
    }

    public void setTestResultReport(String testResultReport)
    {
        this.testResultReport = testResultReport;
    }

    public String getMacFirefoxDriver()
    {
        return macFirefoxDriver;
    }

    public void setMacFirefoxDriver(String macFirefoxDriver)
    {
        this.macFirefoxDriver = macFirefoxDriver;
    }

    public String getWindowsFirefoxDriver()
    {
        return windowsFirefoxDriver;
    }

    public void setWindowsFirefoxDriver(String windowsFirefoxDriver)
    {
        this.windowsFirefoxDriver = windowsFirefoxDriver;
    }

    public String getTestEmail()
    {
        return testEmail;
    }

    public void setTestEmail(String testEmail)
    {
        this.testEmail = testEmail;
    }

    public String getTestPassword()
    {
        return testPassword;
    }

    public void setTestPassword(String testPassword)
    {
        this.testPassword = testPassword;
    }

    public String getTestUserName()
    {
        return testUserName;
    }

    public void setTestUserName(String testUserName)
    {
        this.testUserName = testUserName;
    }

    public String getTestWrongEmail()
    {
        return testWrongEmail;
    }

    public void setTestWrongEmail(String testWrongEmail)
    {
        this.testWrongEmail = testWrongEmail;
    }

    public String getTestWrongPassword()
    {
        return testWrongPassword;
    }

    public void setTestWrongPassword(String testWrongPassword)
    {
        this.testWrongPassword = testWrongPassword;
    }
}
