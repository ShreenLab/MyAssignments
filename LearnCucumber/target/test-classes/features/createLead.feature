Feature: Create Lead Functionality

  Scenario Outline: User creates a new lead
    Given User is on the Create Lead page
    When User enters company name "<CompanyName>"
    And User enters first name "<FirstName>"
    And User enters last name "<LastName>"
    And User enters phone number "<PhoneNumber>"
    And User submits the form
    Then A new lead should be created with "<CompanyName>"

    Examples:
      | CompanyName | FirstName | LastName | PhoneNumber |
      | Testleaf   | Shreen     | Banu      | 98127       |
      | tl         | Jane      | Smith    | 23466       |
      |Qeagle     | Zeeba      |Sithara   |4567|
      