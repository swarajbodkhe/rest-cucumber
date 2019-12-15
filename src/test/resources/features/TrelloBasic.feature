Feature: Basic Trello Functionality

  @Sanity
  Scenario: 001_Verify Trello Board
    Given I send GET Request for "boards/FzFDlcjh"
    Then I verify response code to be 200
    And I verify "name" to be "Agile Board"
    And I verify "labelNames.green" to be "Marketing"

    @Sanity
    Scenario:002_Verify list of cards
      Given I send GET Request for "boards/FzFDlcjh/cards"
      Then I verify response code to be 200
      When I print list of "name"
      Then I verify list of "name" to contain "Review Tech partner pages,Q3 Webinar Content Planning"

    @Sanity
    Scenario:003_Verify list of Lists on Board
      Given I send GET Request for "boards/FzFDlcjh/lists"
      Then I verify response code to be 200
      When I print list of "name"
      Then I verify list of "name" to contain "Done,Current Sprint,In Progress,On Hold,Next-up,Questions"

  @Functional
  Scenario:004_Verify Card Appears in Proper List
    Given I send GET Request for "boards/FzFDlcjh/cards"
    Then I verify response code to be 200
    When I print list of "name"
    And I store the value of "idList" with criteria "name=Google Adwords list of referrers" as "CardsListId"
    And I send GET Request for "boards/FzFDlcjh/lists"
    Then I verify response code to be 200
    When I print list of "name"
    And I store the value of "id" with criteria "name=Current Sprint" as "IdOfList"
    Then I verify "CardsListId" to be equal to "IdOfList"


#    @Functional
#   Scenario: Update Card status/List
#      Given I send GET Request for "boards/FzFDlcjh/cards"
#      Then I verify response code to be 200
#      When I print list of "name"
#      And I store the value of "idList" with criteria "name=Google Adwords list of referrers" as "CardsListId"
#      And I store the value of "id" with criteria "name=Google Adwords list of referrers" as "CardsId"
#      And I send GET Request for "boards/FzFDlcjh/lists"
#      Then I verify response code to be 200
#      When I print list of "name"
#      And I store the value of "id" with criteria "name=On Hold" as "IdOfNewList"
#      When I send the body as below for PUT request:
#      |key        |value        |
#      |idList     | IdOfNewList |
#      And I send PUT Request to "cards" for "card" with value "CardsId"
#      Then I verify response code to be 200