Feature: Test example
Scenario: Test example
Given I open main page of site
  And Input word in search field
  And Filter by click search button
  When I am not authorized user
  Then System shows search result