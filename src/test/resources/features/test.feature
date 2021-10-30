Feature: Test
  Scenario: Booking test
    Given go to "https://www.booking.com/index.html?aid=1376321"
    Then enter hotel name, period and click search button
    When check hotel name and it's score
