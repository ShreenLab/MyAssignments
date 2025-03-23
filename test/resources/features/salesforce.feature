Feature: Create an account in Salesforce


@SalesforceAccount
  Scenario Outline: Successful verification of account name
  
  	Given the user is on the login page 'https://login.salesforce.com/'
    When the user enters username as 'bhuvanesh.moorthy@testleaf.com'
    And the user enters the password as 'Testleaf@2025'
    And the user logs into page
    Then the user should be redirected to the Home page
    And the user clicks on the toggle menu button from the left corner
    And the user clicks View All and selects Sales from the App Launcher
    And the user clicks on the Accounts tab
    And the user clicks on the New button
    And the user enters the account name as <name> 
    And the user selects Ownership as Public
    And the user clicks save and verifies the Account name
   	Examples:
   	|name|
	|Shreen|   	