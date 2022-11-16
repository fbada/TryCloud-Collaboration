Feature: As a user, I should be able to search any item/ users from the homepage.
  Story: As a user, I should be able to search any item/ users from the homepage.
  #prereq -> file/folder/user MUST EXIST

  @wip
  Scenario Outline: Verify users can search any files/folder/users from the search box.

    Given user on the login page
    When the user enters "<username>" and "<password>"
    When the user clicks the magnifier icon on the right top
    And users search any existing "<search>"
    Then verify the app displays the expected result "<search>"

    Examples:
      | username | password    | search  |
      | User64   | Userpass123 | User34  |
      | User4    | Userpass123 | Jenkins |
