Feature: It will get a list of the highest starred repositories in the last week from the GitHub

  Scenario: client makes call to GET /rest/v1/gitrepo/2
    When client calls /rest/v1/gitrepo/2
    Then the client receives response status code of 200
    And the body has size of 2
    And the content type is json

#  Scenario:client makes call to GET /rest/v1/gitrepo/gg
#    When client calls /rest/v1/gitrepo/gg
#    Then the service uri returns status code 400
#    And the content type is json
#    And the body has json path $ of type object
#    And the body has json path $.errorStaus of type String
#    And the body has json path $.url that is equal to "rest/v1/gitrepo/gg"
