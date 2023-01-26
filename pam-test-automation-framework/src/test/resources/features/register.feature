Feature: Registration

  As a user
  I want to register to PokerStars
  So that I can login and I can play poker

  Scenario: Registration form is present
    Given home page is open
    When user selects to register
    Then registration form is open