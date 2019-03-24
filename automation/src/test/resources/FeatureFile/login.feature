Feature: GOOGLE SEARCH

  Background: searching in google

  Scenario: Test1
    Given user enters google in url
    When user searches automation
    Then user is directed to results page

  Scenario: Test2
    Given user enters google in url
    When user searches automation
    Then user is directed to results page

#  Scenario: Test2
#    Given user is logged in
#    When user enters the following details
#      | firstName | surname | age |
#      | syed      | ahmad   | 19  |
#      | ihsaan    | ahmad   | 6   |
#
#    Then user is directed to results page
#
#  Scenario Outline: Test3
#    Given user is logged in
#    When user enters <firstName>, <surname> and <age>
#    Then user is directed to results page
#
#    Examples:
#      | firstName | surname | age |
#      | syed      | ahmad   | 19  |
#      | ihsaan    | ahmad   | 6   |
