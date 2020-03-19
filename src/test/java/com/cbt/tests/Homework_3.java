package com.cbt.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Homework_3 {


    private WebDriver driver;


    @Test
    public void testCase_1(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(), 'Registration Form')]")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");
        WebElement warningMessageIsDisplayed = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));
        Assert.assertTrue(warningMessageIsDisplayed.isDisplayed());
    }

    @Test
    public void testCase_2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(), 'Registration Form')]")).click();
        List<WebElement> webElements = driver.findElements(By.xpath("//label[@class='form-check-label']"));
        for (WebElement webElement : webElements){
            System.out.println(webElement.getText());
        }
    }

    @Test
    public void testCase_3(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(), 'Registration Form')]")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("M");
        String expected = "first name must be more than 2 and less than 64 characters long";
        WebElement webElement = driver.findElement(By.xpath("//small[@class='help-block' and contains (text(), 'first name must be more')]"));
        String actual = webElement.getText();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase_4(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(), 'Registration Form')]")).click();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("L");
        String expected = "The last name must be more than 2 and less than 64 characters long";
        WebElement webElement = driver.findElement(By.xpath("//small[@class='help-block' and contains (text(), 'last name must be more')]"));
        String actual = webElement.getText();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase_5() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(), 'Registration Form')]")).click();
        driver.findElement(By.name("firstname")).sendKeys("Mariia");
        driver.findElement(By.name("lastname")).sendKeys("Lukianenko");
        driver.findElement(By.name("username")).sendKeys("lukianenko");
        driver.findElement(By.name("email")).sendKeys("lukianenko.mariia@gmail.com");
        driver.findElement(By.name("password")).sendKeys("lukianenko");
        driver.findElement(By.name("phone")).sendKeys("952-334-0131");
        List<WebElement> gender = driver.findElements(By.name("gender"));
        gender.get(2).click();
        driver.findElement(By.name("birthday")).sendKeys("01/14/1995");

        WebElement departmentDropdown = driver.findElement(By.name("department"));
        Select departmentSelect  = new Select(departmentDropdown);
        departmentSelect.selectByVisibleText("Department of Engineering");

        WebElement jobTitleDropdown = driver.findElement(By.name("job_title"));
        Select jobTitleSelect  = new Select(jobTitleDropdown);
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        String expected = "You've successfully completed registration!";
        WebElement actual = driver.findElement(By.tagName("p"));
        Assert.assertEquals(actual.getText(), expected);

    }

    @Test
    public void testCase_6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.id("email")).getText();
        Thread.sleep(2000);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Name");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        String actual = driver.findElement(By.cssSelector("h3[class='subheader']")).getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(expected, actual);
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.navigate().to("https://www.tempmailaddress.com");
        WebElement emailfrom = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]"));
        Assert.assertTrue(emailfrom.isDisplayed());
        emailfrom.click();
        String expectedEmailFrom = "do-not-reply@practice.cybertekschool.com";
        String actualEmailFrom = driver.findElement(By.id("odesilatel")).getText();
        Assert.assertEquals(actualEmailFrom, expectedEmailFrom);
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.id("predmet")).getText();
        Assert.assertEquals(actualSubject, expectedSubject);
    }


        @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
}

     @AfterMethod
     public void teardown(){
        driver.quit();
     }


}