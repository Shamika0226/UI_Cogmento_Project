Feature: login to system

  @TC2 @TC3 @TC4 @TC5
  Scenario Outline: 1 : login with valid login credentials
    Given user launch chrome browser navigate to url "<url>" application
    When user enter username as "<username>" and password as "<password>"
    And user click login button
    Then user able to navigate home page

    Examples:
      |url|username|password|
      |https://ui.cogmento.com/ |skiriwattuduwa@gmail.com     | shAmi@123|
#    |https://ui.cogmento.com/ |someOne@gmail.com    | someOne@123 |




