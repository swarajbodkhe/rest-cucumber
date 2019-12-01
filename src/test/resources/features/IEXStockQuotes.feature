#Arrange , Act and Assertion framework

Feature: IEX Stock Quotes

  @Sanity
  Scenario: 1st Rest Example
   Given I send GET request to "stock/aapl/quote"
   When I verify the response to have "AAPL"
