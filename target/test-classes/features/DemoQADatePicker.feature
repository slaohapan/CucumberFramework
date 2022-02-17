@Regression
Feature: Demo QA Scenario
  		   I want to practice different scenarios on Demo QA

  @DemoQADatePicker
  Scenario: I should be able toselect a date from date picker
    Given I am on the date picker page "https://demoqa.com/date-picker"
    When I enter "02/02/2006" to date picker
    Then Date entered should be selected
