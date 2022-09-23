@CancelBooking
Feature: Verifying Adactin Cancel Booking page

  @Cancel
  Scenario Outline: Veryfying Adactin Cancel Booking
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
    And User should cancel booking with generated order id
    Then User should Verify after Cancel selected "The booking has been cancelled."

    Examples: 
      | username | password  | location | hotels      | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrenperRoom | firstName | lastName   | billingAddress  |
      | Velumani | Mine@123# | London   | Hotel Creek | Standard | 2 - Two       | 25/08/2022  | 28/08/2022   | 1 - One       | 0 - None        | Velumani  | Devendiran | Chennai OMR 119 |

  @Cancelorder
  Scenario Outline: Veryfying Adactin Cancel Booking
    Given User is on the adactin page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Velumani!"
    And User should cancel booking with exitsing "<orderid>"
    Then User should Verify after Cancel selected "The booking has been cancelled."

    Examples: 
      | username | password  | 
      | Velumani | Mine@123# |
