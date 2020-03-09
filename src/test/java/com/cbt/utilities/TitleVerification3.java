package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) {


        List<String> urls = Arrays.asList("http://luluandgeorgia.com",
                "http://wayfair.com/", "http://walmart.com", "http://westelm.com/");


        for (int i = 0; i < urls.size() ; i++) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(urls.get(i));
            if (driver.getCurrentUrl().contains(driver.getTitle().replace(" ", "").toLowerCase())){
                System.out.println(driver.getCurrentUrl() + " contains " + driver.getTitle());
            }else {
                System.out.println(driver.getCurrentUrl() + " does not contains " + driver.getTitle());
            }
            driver.quit();
        }


    }
}
