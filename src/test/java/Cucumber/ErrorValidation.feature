
@tag
Feature: Error Validation

  @ErrorValidation
  Scenario Outline: Positive test of submitting the order

    Given I landed on Ecommerce page
    When Logged in with username <username> and password <password>
    Then  "Incorrect email or password" message is displayed

    Examples:
      | username             | password   |
      |frkyz07.13@gmail.com  | Faruk.1313 |



