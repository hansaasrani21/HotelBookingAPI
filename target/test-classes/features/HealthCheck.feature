@Smoke
Feature: Health Check - API restful-booker

  Scenario: Health check of restful-booker API
    Given I hit the restful-booker API
    Then I confirm API is up and running