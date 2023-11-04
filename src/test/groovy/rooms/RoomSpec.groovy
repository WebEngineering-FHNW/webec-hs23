package rooms

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class RoomSpec extends Specification implements DomainUnitTest<Room> {

    def setup() {
    }

    def cleanup() {
    }

    void "test constructor"() {
        given:
            new Room(name: "Room 1", capacity: 10).save()
            new Room(name: "Room 2", capacity: 20).save()
            new Room(name: "Room 3", capacity: 30).save()
        when:"sample data is loaded"
            def rooms = Room.list()

        then:"there are 3 rooms"
            rooms.size() == 3
    }
}
