Feature: Create an event using added contact details

  @TC5
  Scenario Outline: 1 : Add a new contact to the system and create an event using added contact details
    Given user in the homepage
    When user navigate to contact page
    And user navigate to create new contact
    And user create a new contact first name as "<firstName>" middle name as "<middleName>" last name as "<lastName>" company name as "<companyName>" email as "<email>"
    And user save the created contact
    Then user able to view created contact
    When user navigate to calendar page
    And user navigate to create new event page
    And user enter event title as "<title>" and participants as "<participants>"
    Then user able to select added contact name from participant field

    Examples:
    |firstName|middleName|lastName|companyName|email|title|participants|
    |Shamika|Sajeewa|Kiriwaththuduwa|Company123|shamika123@gmail.com|title here|Shamika|