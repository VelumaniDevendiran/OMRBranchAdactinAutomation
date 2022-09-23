@SelectHotel
Feature: Verifying Adactin Select Hotel details

  Scenario Outline: Veryfying Adactin Select hotel page by select hotel name
    Given User is on the adactin page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Velumani!"
    And User should enter details in Search Hotel "<location>","<hotels>","<roomType>","<numberofRooms>","<checkInDate>","<checkOutDate>","<adultsperRoom>" and "<childrenperRoom>"
    Then User should verify  after Select Hotel page msg "Select Hotel"
    And User should selct hotel and click continue
    Then User should verify after continue "Book A Hotel"

    Examples: 
      | username | password  | location | hotels      | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrenperRoom |
      | Velumani | Mine@123# | London   | hotel Creek | Standard | 2 - Two       | 25/08/2022  | 28/08/2022   | 1 - one       | 0 - None        |

  @Select2
  Scenario Outline: Veryfying Adactin Select hotel without select hotel name and click continue
    Given User is on the adactin page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Velumani!"
    And User should enter details in Search Hotel "<location>","<hotels>","<roomType>","<numberofRooms>","<checkInDate>","<checkOutDate>","<adultsperRoom>" and "<childrenperRoom>"
    Then User should verify  after Select Hotel page msg "Select Hotel"
    And User should not select hotel name and click continue button
    Then User should verify error msg after continue "Please Select a Hotel"

    Examples: 
      | username | password  | location | hotels      | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrenperRoom |
      | Velumani | Mine@123# | London   | hotel Creek | Standard | 2 - Two       | 25/08/2022  | 28/08/2022   | 1 - one       | 0 - None        |
