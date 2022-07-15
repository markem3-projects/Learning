Feature: The My Thai Star Website

  Scenario Outline: As a user, I can add items to the cart

    Given I am on the menu page
    When I click ADD TO ORDER button
    Then I should see a pop up menu with an item added to the cart

    # Examples:
