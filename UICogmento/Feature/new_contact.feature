Feature: Adding a new contact to system

@TC2
  Scenario Outline: 1 : add a new contact and verify added contact from home dashboard
    Given user in the homepage
    When user navigate to contact page
    And user navigate to create new contact
    And user create a new contact first name as "<firstName>" middle name as "<middleName>" last name as "<lastName>" company name as "<companyName>" email as "<email>"
    And user save the created contact
    Then user able to view created contact
    When user navigate to home page
    Then user can view added contact details
    And user close the browser

    Examples:
    |firstName|middleName|lastName|companyName|email|
    |Shamika  |Sajeewa   |Kiriwaththuduwa | CompanyXYZ| shamika@gmail.com  |

