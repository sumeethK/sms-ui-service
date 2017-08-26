Feature: Facebook smoke test

  Scenario: User should be able to login to facebook
    Given Chrome is installed
    When User opens url "https://www.facebook.com"
    And User enters username as "admin" and password as "password"
    And User click login button
    Then User should get incorrect username/password error message