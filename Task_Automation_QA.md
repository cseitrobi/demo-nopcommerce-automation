## Suppose we want to build an automation project that will execute every night at 12:00 AM, generate reports and then give us the reports. Right now we want to cover the following two features Registration and PlaceOrder.

### Here is the website link: [nopCommerce](https://demo.nopcommerce.com/)

- Please use two different test files Registration and PlaceOrder.

```gherkin
@registration
Feature: Nopcommerce registration feature Test

  @test-1
  Scenario Outline: User should be able to registration new account successfully
    Given User go to the NopCommerce Home page
    And User navigate to the Registration page
    When User select the <type> as gender
    And User set first name and last name
    And User set <dob> as date of birth
    And User set <dynamicEmail> as email
    And User set <companyName> as company details
    And User set Newsletter option as <status>
    And User set <password> as password and confirm password again
    And User click on the Register button
    Then Verify that the new account registration message <msg> is displayed
    Examples:
      | type     | dob          | dynamicEmail | companyName       | status      | password    | msg                           |
      | "Male"   | "20/05/1995" | ""           | "Tesla - X-23" | "checked"   | "pass@1234" | "Your registration completed" |
      | "Female" | "9/05/1999"  | ""           | "Tesla - X-23" | "unchecked" | "pass@1234" | "Your registration completed" |
      | "Female" | "3/05/2000"  | ""           | "Tesla - X-23" | "unchecked" | "pass@1234" | "Your registration completed" |
      | "Male"   | "2/05/2001"  | ""           | "Tesla - X-23" | "checked"   | "pass@1234" | "Your registration completed" |
      | "Female" | "10/05/1990" | ""           | "Tesla - X-23" | "unchecked" | "pass@1234" | "Your registration completed" |
```

```gherkin
@placeOrder
Feature: Nopcommerce place order feature Test

  @test-2
  Scenario: User should be able to successfully place order as a guest user
    Given User go to the NopCommerce Home page
    When User click "Cell phones" option from "Electronics" category
    And User click on the "Nokia Lumia 1020" for product details
    And User set the quantity number 2 in the quantity field
    And User click on the "ADD TO CART" button
    And User go to the shipping cart page
    And User accept terms conditions and click checkout button
    And User click checkout as guest button
    And User input all the billing details and click continue
    And User select shipping method "Next Day Air" and click continue
    And User select payment method "Credit Card" and click continue
    And User select "Visa" card and input card information
    And User click confirm button to place the order
    Then Verify that the order place message "Your order has been successfully processed!" is displayed
```

## Additional functionalities, that may be covered:

- Automation projects should be capable of running on different OS platform
- Use any automation framework you preferred
- Use Java or other programming languages as you prefer
- Choose any framework that supports Page Object Modal(POM) design pattern
- You can feel free to use any test reporting tools(Ex. Extent Report, Allure report)
- You can feel free to use any data provider such as excel/CSV
- Use your imagination and write some additional tests if you feel you can cover other important functionalities
- The more, the better. Only if it makes sense 😏

## Record a video of tests execution:

- Please record a video of the test cases execution and attach the video as part of your solution

## Task Submission:

- You can put the code publicly in (GitHub or similar code control systems) if you want.
- Send it in your favourite format (link to versioned code, code in zip file etc.) to us.

## Note:

- Please don't use Amazon-23 or Tesla - X-23 name in title, description or the code itself. This helps others to find the
  libraries that are really related to our services and/or are developed and maintained by our team.
