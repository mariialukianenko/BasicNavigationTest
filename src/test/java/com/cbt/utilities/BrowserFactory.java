package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver (String browserName) {

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().version("79.0").setup();
            return new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            return null;
        } else if (browserName.equals("opera")) {
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        } else if (browserName.equals("safari")) {
            return new SafariDriver();
        }else {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();

        }
    }
}