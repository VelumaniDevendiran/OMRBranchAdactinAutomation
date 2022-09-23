@SearchHotel
Feature: Verifying Adactin Search Hotel details

  Scenario Outline: Veryfying Adactin Search hotel with valid credentials
    Given User is on the adactin page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Velumani!"
    And User should enter details in Search Hotel "<location>","<hotels>","<roomType>","<numberofRooms>","<checkInDate>","<checkOutDate>","<adultsperRoom>" and "<childrenperRoom>"
    Then User should verify  after Select Hotel page msg "Select Hotel"

    Examples: 
      | username | password  | location | hotels      | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrenperRoom |
      | Velumani | Mine@123# | London   | hotel Creek | Standard | 2 - Two       | 25/08/2022  | 28/08/2022   | 1 - one       | 0 - None        |

  Scenario Outline: Verifying Adactin Search hotel by mandatory fields
    Given User is on the adactin page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Velumani!"
    And User should enter mandatory fields "<location>","<numberofRooms>","<checkInDate>","<checkOutDate>" and "<adultsperRoom>"
    Then User should verify  after Select Hotel page msg "Select Hotel"

    Examples: 
      | username | password  | location | numberofRooms | checkInDate | checkOutDate | adultsperRoom |
      | Velumani | Mine@123# | London   | 2 - Two       | 25/08/2022  | 28/08/2022   | 1 - One       |

  Scenario Outline: Verifying Adactin Search hotel with invalid date credentials
    Given User is on the adactin page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Velumani!"
    And User should enter details in Search Hotel "<location>","<hotels>","<roomType>","<numberofRooms>","<checkInDate>","<checkOutDate>","<adultsperRoom>" and "<childrenperRoom>"
    Then User should verifying after enter invalid date error messgae  "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | username | password  | location | hotels      | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrenperRoom |
      | Velumani | Mine@123# | London   | hotel Creek | Standard | 2 - Two       | 25/08/2023  | 28/08/2022   | 1 - one       | 0 - None        |

  Scenario Outline: Verifying Adactin Search hotel without entering all fields
    Given User is on the adactin page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Velumani!"
    And User should click search button
    Then User should verify Search Hotel error message "Please Select a Location"

    Examples: 
      | username | password  |
      | Velumani | Mine@123# |
