
  @tag
  Feature: Purchase the order from Ecommerce website

    Background:
      Given I landed on Ecommerce page

    @SubmitOrder
    Scenario Outline: Positive test of submitting the order

      Given Logged in with username <username> and password <password>
      When i add the product <productName> to the cart
      And Checkout <productName> and submit the order
      Then i verify the "THANKYOU FOR THE ORDER." message

      Examples:
        | username             | password   | productName |
        |frkyz07.13@gmail.com  | Faruk.1313 | ZARA COAT 3 |



