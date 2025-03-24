Feature: Edit Account Functionality

  @editAccount
  Scenario Outline: User edits an existing account
  
    Given User is on the Accounts page
    When User searches for an account with name "<ExistingAccountName>"
    And User selects the first account from the list
    And User updates the account name to "<NewAccountName>" and saves the changes
    Then The account name should be updated to "<NewAccountName>"

    Examples:
      | ExistingAccountName | NewAccountName |
      | TestLeaf           | TestLeafUpdated |
      | QeagleA            | QeagleModified  |