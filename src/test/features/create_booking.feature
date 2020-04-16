Feature: End to end flow - create a booking, update it, get the updated values and delete it

  Scenario: Create a new booking successfully
    Given Create default request payload
    When  Send POST request
    Then  Status code is 200
#    And   The data in the response body is the same as data in the request body
    And   The booking id was saved successfully

    Given Generate token for authentication
    Given Create update request payload
    When  Send PUT request
    Then  Status code is 200
#    And   The data in the response body is the same as data in the request body

    When  Send GET request
    Then  Status code is 200
#    And   The retrieved data in payload is the updated one
#
    When  Send DELETE request
    Then  Status code is 201

    When  Send GET request
    Then  Status code is 404
