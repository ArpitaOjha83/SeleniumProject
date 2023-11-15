Feature: Application Login

  Background: 
    Given User launch the merchant website

  Scenario Outline: Application page login
    Given User in landing page
    When User login in application with  <Username> and <Password>
    Then User verifies Home Page is displayed
    And  Print total link in home page
    Then User search the product <ProductName>
    Then User verifes if searched product <ProductName> is displayed
    And  User clicks on first <ProductName>
    Then User clicks on Add to Cart
    Then User verifies first search product <ProductName> is added to Cart
    Then User removes the same cart item <ProductName>
    Then User logs out
 

    Examples: 
      | Username                | Password |    ProductName			 |
      | arpitaojha@deloitte.com | Hello123 |		Wireless Speaker |
