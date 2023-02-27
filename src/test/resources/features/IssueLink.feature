@smoke
Feature: This file contains scenarios for issue creation and linking of issues
 
  Scenario: Create Issues and verify link is successful
   Given I am a valid user and can login in application
   And I can create an issue type "Bug" with issue summary "This is a bug"
   And I can create an issue type "Story" with issue summary "This is a story"
   When I link issue type bug with story
   And I open newly created story
   Then I successfully see bug is linked to story
  