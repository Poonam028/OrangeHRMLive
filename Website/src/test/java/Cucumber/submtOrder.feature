
@tag
Feature: Purchase the product from ecommerce website 
  I want to use this template for my feature file
  
  Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of submitting the order 
    Given logged in with username <name> and password <password>
    When I add the product <ProductName> to cart
    Then Checkout <ProdductName> and submit

    Examples: 
      |     name                    |     password    |    ProductName  | 
      |  anshika@gmail.com          |    Iamking@000  |    ZARA COAT 3  | 
