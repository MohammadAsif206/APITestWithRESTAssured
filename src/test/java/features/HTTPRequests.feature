Feature:
  Verify different HTTP requests by REST-assured

  Scenario: Verify the presence of a student
    Given User executes GET operation for "/student"
    Then User should be able to see the student name as "mohammad"

  Scenario: Verify number of students in the same class
    Given User executes GET operation for the "/student"
    Then User should be able to see the  name of the students

  Scenario: Verify pathPram in GET
    Given User executes GET operation for the "/student"
    Then User should be able to verify pathParam of GET

  Scenario: Verify POST operation
    Given User executes POST operation for the "/student"

  Scenario: Verify POST operation for profile
    Given User executes POST operation for the "/student/{profileNo}/profile" with body
        | name | profile |
        | Jani | 8      |
    Then User should be able to see the profile name as "Jani"




