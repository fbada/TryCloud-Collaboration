Feature: As a user, I should be able to search any item/ users from the homepage.
  Story: As a user, I should be able to search any item/ users from the homepage.


  Scenario Outline: Verify users can search any files/folder/users from the search box.

    Given user on the login page
    When the user enters "<username>" and "<password>"
    When the user clicks the magnifier icon on the right top
    And users search any existing file/folder/user name
    Then verify the app displays the expected result option
