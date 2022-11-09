@US10
Feature: : As a user, I should be able to update their settings.
  Story: As a user, I should be able to update settings.

  Scenario Outline: Verify users be able to update settings.
    Given user on the login page
    When the user enters "<username>" and "<password>"
    When the user clicks the "Files" module
    And user clicks Settings on the left bottom corner
    Then the user should be able to click any buttons
    Examples:
      | username | password    |
      | User4    | Userpass123 |
      | User34   | Userpass123 |
      | User64   | Userpass123 |
      | User94   | Userpass123 |
  @wip
  Scenario Outline: Verify users to see the app storage usage
    Given user on the login page
    When the user enters "<username>" and "<password>"
 #   When user on the dashboard page
    When the user clicks the "Files" module
    And user checks the current storage usage
    And user uploads file with the "Upload" file option
    And user refresh the page
    Then the user should be able to see storage usage is increased

    Examples:
      | username | password    |
      | User4    | Userpass123 |
    #  | User34   | Userpass123 |
   #   | User64   | Userpass123 |
   #   | User94   | Userpass123 |