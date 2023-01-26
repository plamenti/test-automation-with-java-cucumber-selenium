@login
Feature: Login

  As a already registered user
  I want to login to PokerStars
  So that I can play poker

  @smoke @regression @valid_credentials
  Scenario: Login with valid credentials
    Given home page is open
    When user selects to login
    And provide valid credentials
    Then user is successfully logged in

  @smoke @invalid_credentials @focus
  Scenario: Login with invalid credentials
    Given home page is open
    When user selects to login
    And provide invalid credentials