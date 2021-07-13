@ReqRes
Feature: ReqRes - Get All Users and Post User

  @GetAllUsers
  Scenario: ReqRes - Get all Users
    Given User prepares "Get All Users" request
    When "Get" Request is submitted
    Then Response Code is "200"
    And User data in Response is as expected

#  @PostNewUser
#  Scenario: ReqRes - Create a New User
#    Given User prepares "Create New User" request with below data
#      | Name     | job      |
#      | John Doe | Engineer |
#    When "Post" Request is submitted
#    Then Response Code is "201"