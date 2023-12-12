package rooms

class Person {
    String  firstName
    String  lastName
    SecUser secUser

    String toString() { "$firstName $lastName" }

    static constraints = {
        firstName nullable: true
        lastName  nullable: true
        secUser   nullable: true
    }
}
