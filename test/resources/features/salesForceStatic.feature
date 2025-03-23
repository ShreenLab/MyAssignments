Feature: Edit Salesforce Account
As a Salesforce user
I want to edit an account
So that I can update its details
@SalesForceStatic
Scenario Outline: Update account details in Salesforce
Given User is on the Salesforce login page
When enters username and password
And clicks the login button
Then should be redirected to the Salesforce home page
When User clicks the App Launcher Icon next to Setup
And selects Accounts
And searches for the account using <account_name>
And clicks the dropdown icon next to the account and select Edit
And sets Type to Technology Partner
And sets Industry to Healthcare
And enters the Billing Address as "<billing_address>"
And enters the Shipping Address as "<shipping_address>"
And sets Customer Priority to Low
And sets SLA to Silver
And sets Active to NO
And enters a unique number in the Phone field as "<phone_number>"
And sets Upsell Opportunity to 'No'
And clicks Save
Examples:
| account_name | billing_address | shipping_address | phone_number |
| TestAccount1 | 123 Main St, NY | 456 Elm St, CA | 9876543210 |
