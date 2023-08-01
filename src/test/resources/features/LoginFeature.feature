Feature: Docuport Login Logout Feature

Background: will run for each scenario first
  Given user is on Docuport login page

 # @smoke @regression
  @smoke
  Scenario: Login as a client
    Given user is on Docuport login page
    When user enters username for client
    And user enters password for client
    And user clicks login button
    Then user should see the home page for client

    #@regression
  @Javid
    Scenario: Login as a employee
      Given user is on Docuport login page
      When user enters username for employee
      And user enters password for employee
      And user clicks login button
      Then user should see the home page for employee

  #@regression
  @Javid
  Scenario: Login as a advisor
    Given user is on Docuport login page
    When user enters username for advisor
    And user enters password for advisor
    And user clicks login button
    Then user should see the home page for advisor

#@regression
  @Javid
Scenario: Login as a admin
  Given user is on Docuport login page
  When user enters username for admin
  And user enters password for admin
  And user clicks login button
  Then user should see the home page for admin

    @Java
  Scenario: Login as a supervisor
    When user enter username for supervisor
    And  user enter password for supervisor
    And  user clicks login button
    Then user should see the home page for supervisor

  #@regression
  @Javid
  Scenario: Login as a client map practice
    When user enters credentials
    | username | b1g1_client@gmail.com |
    | password | Group1                |
    Then user should see the home page for client