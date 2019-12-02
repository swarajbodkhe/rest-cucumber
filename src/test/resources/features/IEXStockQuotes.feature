#Arrange , Act and Assertion framework

Feature: IEX Stock Quotes

  @Sanity
  Scenario: Verify basic details of a Stock by Symbol
   Given I send request GET stock quote for "aapl"
   Then I verify the response has code 200
   And I verify the response has "companyName" as "Apple, Inc."
   And I verify the response has "primaryExchange" as "NASDAQ"

    @Sanity
    Scenario: Verify Open Close Price of a stock
      Given I send request to GET open-close price of "aapl" stock on "2019-11-04" date
      Then I verify the price response has "[0].high" as 257.85
      And I verify the price response has "[0].low" as 255.38
