@Regression
Feature: Testing API restful-booker

	Scenario: Verify Create Booking
		Given I create booking
		Then Booking is created successfully

	Scenario: Verify Get Booking - All Bookings
		Given I get details of all bookings
		Then I view details of booking successfully

	Scenario: Verify Get Booking by booking id
		Given I get details of booking by id
		Then I view details of booking successfully

	Scenario: Verify Get Booking by firstname
		When I get details of booking by firstname
		Then I view details of booking successfully

	Scenario: Verify Get Booking by lastname
		When I get details of booking by lastname
		Then I view details of booking successfully

	Scenario: Verify Get Booking by firstname and lastname
		When I get details of booking for firstname and lastname
		Then I view details of booking successfully


	Scenario: Verify Update Booking
		Given I create booking
		And I am an authorized user
		When I update booking
		Then Booking is updated successfully

	Scenario: Verify error when updating booking with unauthorized user
		Given I create booking
		When I update booking with unauthorized user
		Then Booking is not updated

	Scenario: Verify Partial Update for Booking
		Given I create booking
		And I am an authorized user
		When I partially update the booking details
		Then Booking is partially updated successfully

	Scenario: Verify error when partial updating booking with unauthorized user
		Given I create booking
		When I partially update the booking details with unauthorized user
		Then Booking is not partially updated

	Scenario: Verify Delete Booking
		Given I create booking
		And I am an authorized user
		When I delete booking
		Then Booking is deleted successfully

	Scenario: Verify Delete Booking with unauthorized user
		Given I create booking
		When I delete booking with unauthorized user
		Then Booking is not deleted
