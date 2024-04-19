package com.example.nopcommerce;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrderTest {

  private WebDriver driver;
  private final String baseUrl = "https://demo.nopcommerce.com/";

  @BeforeTest
  public void setup() {
    driver = new ChromeDriver();
    driver.get(baseUrl);
    driver.manage().window().maximize();
  }

  @Test
  public void userRegistrationTest() throws InterruptedException {
    Thread.sleep(1000);

    By electronicsLink = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']");
    By cellPhonesLink = By.xpath("//a[@title='Show products in category Cell phones'][normalize-space()='Cell phones']");
    By nokiaLumiaLink = By.xpath("//a[normalize-space()='Nokia Lumia 1020']");
    By quantityInput = By.xpath("//input[@id='product_enteredQuantity_20']");
    By addToCartButton = By.xpath("//button[@id='add-to-cart-button-20']");
    By cartLink = By.xpath("//span[@class='cart-label']");
    By termsCheckbox = By.id("termsofservice");
    By checkoutButton = By.xpath("//button[@id='checkout']");
    By checkoutAsGuestButton = By.xpath("//button[normalize-space()='Checkout as Guest']");
    By FirstName = (By.xpath("//input[@id='BillingNewAddress_FirstName']"));
    By lastNameInput = By.xpath("//input[@id='BillingNewAddress_LastName']");
    By emailInput = By.xpath("//input[@id='BillingNewAddress_Email']");
    By companyInput = By.xpath("//input[@id='BillingNewAddress_Company']");
    By country = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    By stateprovince = By.xpath("//select[@id='BillingNewAddress_StateProvinceId']");
    By cardexpiremonth = By.xpath("//select[@id='ExpireMonth']");
    By cardexpireyear = By.xpath("//select[@id='ExpireYear']");
    By cityInput = By.xpath("//input[@id='BillingNewAddress_City']");
    By address1Input = By.xpath("//input[@id='BillingNewAddress_Address1']");
    By address2Input = By.xpath("//input[@id='BillingNewAddress_Address2']");
    By zipCodeInput = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    By phoneNumberInput = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    By faxNumberInput = By.xpath("//input[@id='BillingNewAddress_FaxNumber']");
    By saveButton = By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']");

    By shippingOption1 = By.xpath("//label[@for='shippingoption_1']");
    By shippingNextButton = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");

    By paymentMethod1 = By.xpath("//input[@id='paymentmethod_1']");
    By paymentNextButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");

    By visaOption = By.xpath("//select[@id='CreditCardType']");
    By cardholderNameInput = By.xpath("//input[@id='CardholderName']");
    By cardNumberInput = By.xpath("//input[@id='CardNumber']");
    By cardCodeInput = By.xpath("//input[@id='CardCode']");
    By paymentInfoNextButton = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    By confirmButton = By.xpath("//button[normalize-space()='Confirm']");
    By resultElement = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");

    click(electronicsLink);
    // Thread.sleep(1000);  

    click(cellPhonesLink);
    // Thread.sleep(1000);

    // Click on Nokia Lumia 1020 product
    click(nokiaLumiaLink);
    // Thread.sleep(1000);

    // Clear the default quantity (if any)
    WebElement quantityElement = driver.findElement(quantityInput);
    quantityElement.clear();

    // Set the quantity to 2
    quantityElement.sendKeys("2");
    // Thread.sleep(1000);

    // Add the product to the cart
    click(addToCartButton);

    // Go to shopping cart
    click(cartLink);
    // Thread.sleep(1000);

    // Accept terms of service
    click(termsCheckbox);
    // Thread.sleep(1000);

    // Proceed to checkout
    click(checkoutButton);
    // Thread.sleep(1000);

    // Checkout as Guest
    click(checkoutAsGuestButton);
    Thread.sleep(5000);

    sendKeys(FirstName, "Robi");
    Thread.sleep(1000);
    // Registration steps
    sendKeys(lastNameInput, "Sarker");
    Thread.sleep(1000);
    sendKeys(emailInput, "fakeemail@yopmail.com");
    Thread.sleep(1000);
    sendKeys(companyInput, "Tesla");
    Thread.sleep(1000);

    selectValue(country, "87");
    selectValue(stateprovince, "0");

    // Registration steps (continued)
    sendKeys(cityInput, "Kasablanca");
    Thread.sleep(1000);
    sendKeys(address1Input, "Sudan Street");
    Thread.sleep(1000);
    sendKeys(address2Input, "California");
    Thread.sleep(1000);
    sendKeys(zipCodeInput, "8080496");
    Thread.sleep(1000);
    sendKeys(phoneNumberInput, "89801781667897");
    Thread.sleep(1000);
    sendKeys(faxNumberInput, "89801781667111");
    Thread.sleep(1000);
    click(saveButton);
    Thread.sleep(5000);

    click(shippingOption1);
    Thread.sleep(1000);
    click(shippingNextButton);
    Thread.sleep(1000);

    click(paymentMethod1);
    Thread.sleep(1000);
    click(paymentNextButton);
    Thread.sleep(10000);

    // Assuming selectValue is for a dropdown
    selectValue(visaOption, "visa");
    Thread.sleep(1000);

    sendKeys(cardholderNameInput, "Robii");
    Thread.sleep(1000);
    sendKeys(cardNumberInput, "4111111111111111"); // Placeholder for credit card number, replace with actual value
    Thread.sleep(10000);

    selectValue(cardexpiremonth, "5");
    selectValue(cardexpireyear, "2026");

    // Registration steps (continued)
    sendKeys(cardCodeInput, "111");
    Thread.sleep(1000);
    click(paymentInfoNextButton);
    Thread.sleep(1000);
    click(confirmButton);
    Thread.sleep(5000);
    try {
      String displayedText = driver.findElement(resultElement).getText();
      if (displayedText.equals("Your registration completed")) {
        System.out.println("Registration successful message displayed!");
      } else {
        System.out.println("Expected registration message not found.");
      }
    } catch (NoSuchElementException e) {
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

}