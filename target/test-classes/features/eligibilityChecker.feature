@EndToEndJourney
Feature: NHS Eligibility checker

			As a person from Wales
			I need to know what help I can get with my NHS costs
			So that I can get the treatment I need
      
  Background:
   
    Given I navigate to NHS eligibility checker tool

  Scenario: Wales Test Ticket - Acceptance Criteria
            
      Given I am a person from Wales
			When I put my circumstances into the Checker tool
			Then I should get a result of whether I will get help or not