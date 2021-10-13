Feature: Login feature


@wip
Scenario: As a user I am in the login page
  Given As user I am on the Home Page
  When As a user I Click the login button
  And  Enter invalid username and password
  Then I should see the error message

