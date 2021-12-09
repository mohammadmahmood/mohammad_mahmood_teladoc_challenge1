Feature: To do list

  Background:
    Given I am on Protractor Practice website home page

  @ProtractorPractice @AddUser @TC_001
  Scenario:  Add a user and validate the user has been added to the table
		When I click on "Add User" Button
		And I enter "First Name" as "TestFirst"
		And I enter "Last Name" as "TestLast"
		And I enter "User Name" as "TestUser"
		And I enter "Password" as "Test1234"
		And I select "company AAA" radio button
		And I select role as "Admin"
		And I enter  "email" as "Strange.test@testmail.com"
		And I enter "Cell Phone" as "9876543210"
		And I click on "Save" Button
		Then I should see user with "Strange.test@testmail.com" email is added to the list
		
	@ProtractorPractice @TC_002 @DeleteUser
  Scenario: Delete user User Name: novak and validate user has been delete
  	When I delete user with name "novak"
  	And I click ok on confirmation pup up
  	Then I do not see "novak" in the user list