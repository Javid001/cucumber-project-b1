Feature: Passing multiple parameters to the same step


  Scenario: Searching multiple items
    Given user is on Google search page
    Then user searches the following item
      | Loop Academy |
      | java         |
      | selenium     |
      | cucumber bdd |
      | sql          |
      | nadir        |
      | anna         |
      | anything     |

#    option + command + L - mac
#    CTRL + ALT + L window