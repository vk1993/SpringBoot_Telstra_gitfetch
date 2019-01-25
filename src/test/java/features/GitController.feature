Feature: It will get a list of the highest starred repositories in the last week from the GitHub

  Scenario:Is the rest/v1/gitrepo/5 uri returning data
    When I make a "GET" request to "rest/v1/gitrepo/5"
    Then I get status code 200
    And the content type is json
    And the body has json path $ of type object