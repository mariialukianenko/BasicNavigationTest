package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class TitleVerification {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        List<String> titles = new ArrayList<>();

        for (String url : urls){
            driver.get(url);
            titles.add(driver.getTitle());

            if (driver.getCurrentUrl().startsWith("http://practice.cybertekschool.com")){
                System.out.println(driver.getCurrentUrl() + " start with: http://practice.cybertekschool.com");
            }else{
                System.out.println(driver.getCurrentUrl() + "does not start with: http://practice.cybertekschool.com");
            }
        }
        System.out.println(titles);

        for (int i = 0; i < titles.size()-1; i++) {
            StringUtility.verifyEquals(titles.get(i), titles.get(i+1));
        }
        StringUtility.verifyEquals(titles.get(0), titles.get(2));


        driver.quit();
    }
}
