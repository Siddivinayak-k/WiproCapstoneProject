Feature: Navigation and Access to Health Programs
  
  Scenario: Navigate to Health Programs
    Given I am on the Home page
    When I click on the "PROGRAMS" menu
    Then I should see a list of health programs

  Scenario: Access Program Details
    Given I am on the "PROGRAMS" page
    When I click on the "Tobacco" program
    Then I should see the TOBACCO program details
