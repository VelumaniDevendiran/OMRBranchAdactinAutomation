@BookHotel
Feature: Verifying Adactin Book A Hotel page

  @Book1
  Scenario Outline: Veryfying Adactin Book A Hotel page by enter Details all fields
    Given User is on the adactin page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Velumani!"
    And User should enter details in Search Hotel "<location>","<hotels>","<roomType>","<numberofRooms>","<checkInDate>","<checkOutDate>","<adultsperRoom>" and "<childrenperRoom>"
    Then User should verify  after Select Hotel page msg "Select Hotel"
    And User should selct hotel and click continue
    Then User should verify after continue "Book A Hotel"
    And User should perform book hotel "<firstName>","<lastName>" and "<billingAddress>"
      | creditCardNo     | creditCardType   | expiryMonth | expiryYear | cvvNumber |
      | 9876543212345678 | VISA             | May         |       2022 |      9876 |
      | 9876543212348765 | American Express | June        |       2022 |      9876 |
      | 6786543212345672 | VISA             | Feb         |       2022 |      9876 |
      | 9876543212349876 | Master card      | May         |       2022 |      9876 |
      | 9876543212309774 | other            | May         |       2022 |      9876 |
      | 9876543212309873 | VISA             | May         |       2022 |      9876 |
      | 9876543212309876 | VISA             | May         |       2022 |      9876 |
    Then User should verify after click book now msg "Booking Confirmation"

    Examples: 
      | username | password  | location | hotels      | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrenperRoom | firstName | lastName   | billingAddress  |
      | Velumani | Mine@123# | London   | hotel Creek | Standard | 2 - Two       | 25/08/2022  | 28/08/2022   | 1 - one       | 0 - None        | Velumani  | Devendiran | Chennai OMR 119 |

  @Book2
  Scenario Outline: Veryfying Adactin Book A Hotel page without enter details any fields
    Given User is on the adactin page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Velumani!"
    And User should enter details in Search Hotel "<location>","<hotels>","<roomType>","<numberofRooms>","<checkInDate>","<checkOutDate>","<adultsperRoom>" and "<childrenperRoom>"
    Then User should verify  after Select Hotel page msg "Select Hotel"
    And User should selct hotel and click continue
    Then User should verify after continue "Book A Hotel"
    And User should click Book now option With out enter details
    Then User should verify Error msg "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | username | password  | location | hotels      | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrenperRoom |
      | Velumani | Mine@123# | London   | hotel Creek | Standard | 2 - Two       | 25/08/2022  | 28/08/2022   | 1 - one       | 0 - None        |
