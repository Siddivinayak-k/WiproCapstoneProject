Feature: Contact Form Submission

	Background:
		Given I am on the form page
    
  Scenario: Successful Form Submission with Valid Data
	  When I enter "John Doe" as first name, "Doe" as last name, "9234567890" as phone number, and "johndoe@gmail.com" as email
	  And I select Tai Chi for Arthritis and Living Healthy (Chronic Disease Self-Management) as programs of interest
	  And I select Santa Rosa as my county
	  And I select Virtual as my preferred class format
	  And I select I am best described as: option
	  And I enter "Internet" in Please help us by telling us where you heard about us:
	  And I select the checkbox I would like to be notified by email when classes are available in my area
	  And I click on the submit button
	  Then the form should be submitted successfully message should be displayed
    
	Scenario: Form Submission with Missing Required Fields
		When I leave the NAME field empty
		And I leave PHONE field empty
		And I leave EMAIL field empty
		And I click on the submit button
		Then an error message should be displayed for the missing fields