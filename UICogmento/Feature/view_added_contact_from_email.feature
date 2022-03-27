Feature: Send email using added contact details

  @TC4
  Scenario Outline: 1 : Add a new contact to the system and send email with added contact
    Given user in the homepage
    When user navigate to contact page
    And user navigate to create new contact
    And user create a new contact first name as "<firstName>" middle name as "<middleName>" last name as "<lastName>" company name as "<companyName>" email as "<email>"
    And user save the created contact
    Then user able to view created contact
    When user navigate to email page
    And user navigate to compose email page
    And user enter subject as "<subject>" and receiver as "<receiver>"
    Then user able to select added contact name from To field


    Examples:
    |firstName|middleName|lastName|companyName|email|subject|receiver|
    |Shamika|Sajeewa|Kiriwaththuduwa|Company123|shamika123@gmail.com|subject here |Shamika|