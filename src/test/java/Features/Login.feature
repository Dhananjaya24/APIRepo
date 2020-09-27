Feature: Application login


Scenario: Application homepage should open
Given User is on login page
When user logins into application with "dhanu" and "123"
Then User logged in homepage should display
And logged in user name display "True"


Scenario: Application homepage should open
Given User is on login page
When user logins into application with "jay" and "12345"
Then User logged in homepage should display
And logged in user name display "False"