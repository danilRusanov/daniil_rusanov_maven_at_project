Feature: Elements suite

  @53084
  Scenario: Text box submitting
    Given Open Text Box form
    Given Input "DanilRus" in Full name field
    When  Click Submit button
    Then  Check "DanilRus" in Result block
    Then Close browser

  @53085
  Scenario: 2 check-boxes selecting
    Given Open checkBox form
    When  Open Home structure
    When  Select Home check-box
    Then  All check-boxes are selected
    Then  Selected check-boxes are in result message
    Then  Close browser

  @53086
  Scenario: Radio-button selecting
    Given Open Radio block
    When  Select radio
    Then  Check radio
    Then  Close browser

  @53087
  Scenario: Edit record in webtables
    Given Open webtables page

  @53088
  Scenario: Clicking all buttons
    Given Open buttons block
    When Make doubleClick
    Then Check doubleClick
    Then Close browser



