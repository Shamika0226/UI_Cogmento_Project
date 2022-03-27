Feature: Add a new company from contact page

  @TC3
  Scenario Outline: 1 : add a new company to the system from contact page and verify added company from company page
    Given user successfully logged in now in the homepage
    When user navigate to the contact page
    And user navigate to the create new contact page
    And user create a new contact first name as "<firstName>" middle name as "<middleName>" last name as "<lastName>" new company name as "<companyName>" email as "<email>"
    And user save created contact
    Then user able to view created contact with new company name as "Company123"
    When user navigate to company page
    Then user able to view added company name from company page
    And user close chrome browser

    Examples:
    |firstName|middleName|lastName|companyName|email|
    |Shamika  |Sajeewa   |Kiriwaththuduwa|Company123|shamika1@gmail.com|