Feature: User authentication for leaftaps application
Scenario: Successfull login using valid credentials
Given the user is on the login page
When user enters the valid username
And user enters the valid password
And user clicks the login button
Then user is redirected to login page
And user seeing the welcome message

