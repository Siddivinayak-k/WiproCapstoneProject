Feature: User Login
	
	 Background:
    Given I am on the login page
	
  Scenario: Login with registered credentials
    When I enter "john123" as username and "johndoe@#136" as password
    And I click on the Login button
    Then I should be successfully logged in

  Scenario: Login with invalid credentials
    When I enter "johndoe" as username and "johndoe.#456" as password
    And I click on the Login button
    Then an error message should be displayed for invalid credentials

  Scenario: Login with forgotten password
    When I click on the Forgot Password link
    And I enter "johndoe@gmail.com" as email address
    And I click on the Submit button
    Then a password reset link should be sent to the email