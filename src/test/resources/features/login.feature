Feature: Login feature


@wip
Scenario: Login with invalid credentials
  Given As user I am on the Home Page
  When As a user I Click the login button
  And  Enter invalid username and password
  Then I should see the error message

