# WebEngineering Module, Spring Security

## Goals

### Abilities
Being able to identify the user and set up basic security.
Run tests with security enabled.

### Knowledge
Knowing the very basics of role-based security for web applications, incl.
- Annotation based
- url pattern based (config)
- url pattern based (from DB)

## Recommended Reading
https://grails.github.io/grails-spring-security-core/5.3.x/index.html#requestMappings

Steps to follow:
see the "security" branch and follow the commits

## Notes

Better not use "User" as a domain class or db table name.
That clashes with some DBMS e.g. Postgres.

## Steps that have been taken to set up the security

follow the steps of the security branch, which includes
- add to build gradle:     
  implementation 'org.grails.plugins:spring-security-core:5.3.0' // added to include security
- grailsw compile
- grailsw s2-quickstart rooms SecUser SecRole
- adapt the bootstrap
- add login/logout facility
- adapt the test cases
- adapt the security settings in conf/application.groovy

- Optional:
  - beautify the login view
  - set up reference from SecUser to Person
  - display bookings for a logged in, regular user
    see https://grails.github.io/grails-spring-security-core/5.3.x/index.html#controllerMethods
