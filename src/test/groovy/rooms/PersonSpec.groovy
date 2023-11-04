package rooms

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    def setup() {
    }

    def cleanup() {
    }

    void "test constructor"() {
        given :
            new Person(firstName: "John", lastName: "Smith").save()
            new Person(firstName: "Jane", lastName: "Doe").save()
        when:"sample data is loaded"
            def people = Person.list()

        then:"there are 2 people"
            people.size() == 2
    }
}
