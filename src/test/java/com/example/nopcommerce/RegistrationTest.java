package com.example.nopcommerce;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class RegistrationTest {
  
  private static WebDriver driver;
  private final String baseUrl = "https://demo.nopcommerce.com/";
  private static ExtentReports extentReports;
  private static ExtentTest test;


  @BeforeAll
  public static void setupExtentReporter() {
       // extentReports = ExtentReports.extentReports()
        //         .outputDirectory("")
        //         .reportName("report.html")
        //         .build();
        
  }


  
  @BeforeTest
  public void setup() throws Exception {

    driver = new ChromeDriver();
    driver.get(baseUrl);
    driver.manage().window().maximize();
    // test = extentReports.createTest("User Registration Test"); // Create a test for each scenario
  }

  @Test
  public void userRegistrationTest() throws Exception {

    ScreenRecorderUtil.startRecord("userRegistrationTest");

    // Page elements
    By homeRegisterButton = By.xpath("//a[@class='ico-register' and contains(@href, '/register?returnUrl=%2F')]");
    By maleGender = By.xpath("//input[@id='gender-male']");
    By firstName = By.xpath("//input[@id='FirstName' and @type='text']");
    By lastName = By.xpath("//input[@id='LastName' and @type='text']");
    By dateOfBirthDay = By.xpath("//select[@name='DateOfBirthDay']");
    By dateOfBirthMonth = By.xpath("//select[@name='DateOfBirthMonth']");
    By dateOfBirthYear = By.xpath("//select[@name='DateOfBirthYear']");
    By email = By.xpath("//input[@id='Email' and @type='email']");
    By company = By.xpath("//input[@id='Company']");
    By newsletterCheckbox = By.id("Newsletter");
    By password = By.xpath("//input[@id='Password' and @type='password']");
    By confirmPassword = By.xpath("//input[@id='ConfirmPassword' and @type='password']");
    By registerButton = By.xpath("//button[@class='button-1 register-next-step-button' and @type='submit']");
    By resultElement = By.xpath("//div[@class='result']");

    // Registration steps
    click(homeRegisterButton);
    Thread.sleep(100);
    click(maleGender);
    Thread.sleep(1000);
    sendKeys(firstName, "Robi");
    Thread.sleep(100);
    sendKeys(lastName, "Sarker");
    Thread.sleep(100);

    selectValue(dateOfBirthDay, "3");
    Thread.sleep(100);
    selectValue(dateOfBirthMonth, "3");
    Thread.sleep(100);
    selectValue(dateOfBirthYear, "1990");
    Thread.sleep(100);

    sendKeys(email, "fakemeail2@gmail.com");
    Thread.sleep(100);
    sendKeys(company, "Amazon XYZ");
    Thread.sleep(100);

    if (!isSelected(newsletterCheckbox)) {
      click(newsletterCheckbox);
    }

    sendKeys(password, "5236465AbcD^&!##@*&%");
    Thread.sleep(100);
    sendKeys(confirmPassword, "5236465AbcD^&!##@*&%");
    Thread.sleep(100);
    click(registerButton);
    Thread.sleep(2000);

    try {
      String displayedText = driver.findElement(resultElement).getText();
      if (displayedText.equals("Your registration completed"))
        System.out.println("Registration successful message displayed!");
      else {
        System.out.println("Expected registration message not found.");
      }
    }
     catch (NoSuchElementException e) {
      System.out.println("Result element not found. Registration message");
    } finally {
      driver.quit();
    }

  }

  private void click(By locator) {
    driver.findElement(locator).click();
  }

  private void sendKeys(By locator, String text) {
    driver.findElement(locator).sendKeys(text);
  }

  private void selectValue(By locator, String value) {
    new Select(driver.findElement(locator)).selectByValue(value);
  }

  private boolean isSelected(By locator) {
    return driver.findElement(locator).isSelected();
  }
  @AfterAll
  public static void flushReports() {
      extentReports.flush();
      driver.quit();
  }
}