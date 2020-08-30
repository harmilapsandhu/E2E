Feature: Validate QA Click Academy

Scenario Outline: Positive Test Validating Scenario
Given Initialize the browser with Chrome
And Navigate to "https://rahulshettyacademy.com/#/index"
And Click on LogIn to enter secure LogIn page
When User enters <username> and <password> and clicks Log In
Then Verify that the user is successfully logged in

Examples:
|username					 |password	|
|karan1988@gmail.com		 |password1	|
|test99@gmail.com			 |123456	|