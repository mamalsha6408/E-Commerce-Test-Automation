Feature: login functionality

  @s1
  Scenario: User logs in with valid credentials

    Given the user in on the loginPage
    When the user enters username "standard_user"
    And the user enters password "secret_sauce"
    And the user clicks the login button
    Then the use should be redirected to the product page

  @s2
  Scenario: User logs in with an invalid password

    Given the user in on the loginPage
    When the user enters username "standard_user"
    And the user enters password "wrong_password"
    And the user clicks the login button
    Then the user should see an error message "Epic sadface: Username and password do not match any user in this service"

  @s3
  Scenario: User logs in with an invalid username

    Given the user in on the loginPage
    When the user enters username "invalid_user"
    And the user enters password "secret_sauce"
    And the user clicks the login button
    Then the user should see an error message "Epic sadface: Username and password do not match any user in this service"

  @s4
  Scenario: User attempts login with empty fields
    Given the user in on the loginPage
    When the user leaves both username and password fields empty
    And the user clicks the login button
    Then the user should see an error message "Epic sadface: Username is required"

  @s5
  Scenario: User attempts login with a locked-out account

    Given the user in on the loginPage
    When the user enters username "locked_out_user"
    And the user enters password "secret_sauce"
    And the user clicks the login button
    Then the user should see an error message "Epic sadface: Sorry, this user has been locked out."

  @s6
  Scenario: User logs in and verifies logout functionality
    Given the user in on the loginPage
    When the user enters username "standard_user"
    And the user enters password "secret_sauce"
    And the user clicks the login button
    Then the user should be redirected to the products page
    When the user clicks the menu button
    And the user clicks the logout option
    Then the user should be redirected back to the login page