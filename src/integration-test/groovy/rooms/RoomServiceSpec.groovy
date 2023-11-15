package rooms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Ignore
import spock.lang.Specification
import org.hibernate.SessionFactory

// this is an exercise that the student should make running
@Ignore
@Integration
@Rollback
class RoomServiceSpec extends Specification {

    RoomService roomService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Room(...).save(flush: true, failOnError: true)
        //new Room(...).save(flush: true, failOnError: true)
        //Room room = new Room(...).save(flush: true, failOnError: true)
        //new Room(...).save(flush: true, failOnError: true)
        //new Room(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //room.id
    }

    void "test get"() {
        setupData()

        expect:
        roomService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Room> roomList = roomService.list(max: 2, offset: 2)

        then:
        roomList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        roomService.count() == 5
    }

    void "test delete"() {
        Long roomId = setupData()

        expect:
        roomService.count() == 5

        when:
        roomService.delete(roomId)
        sessionFactory.currentSession.flush()

        then:
        roomService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Room room = new Room()
        roomService.save(room)

        then:
        room.id != null
    }
}
