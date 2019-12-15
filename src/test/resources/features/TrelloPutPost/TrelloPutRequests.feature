Feature: Trello Put Requests

@Functional
Scenario: 005_Update Card status/List
When I send the body as below for PUT request:
|key        | value                    |
|idList     | 5de94d6f7a94b524c897df70 |
And I send PUT Request to "cards" for "card" with value "5de94d6f7a94b524c897dfa0"
Then I verify response code to be 200
And I verify "idList" to be "5de94d6f7a94b524c897df70"

  Scenario: 006_Move Card to Original List/Status
    When I send the body as below for PUT request:
      |key        | value                    |
      |idList     | 5de94d6f7a94b524c897df6f |
    And I send PUT Request to "cards" for "card" with value "5de94d6f7a94b524c897dfa0"
    Then I verify response code to be 200
    And I verify "idList" to be "5de94d6f7a94b524c897df6f"