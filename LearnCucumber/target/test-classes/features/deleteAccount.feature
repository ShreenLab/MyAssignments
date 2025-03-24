Feature: Delete Lead Functionality
@deleteAccount
  Scenario: User deletes a lead successfully
    Given User is on the Find Leads page
    When User searches for a lead with phone number "88258"
    And User selects the first lead from the search results
    And User clicks the Delete button
    Then The lead should be deleted successfully