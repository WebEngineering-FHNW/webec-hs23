package rooms

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

import static rooms.BootStrap.today

class BookingSpec extends Specification implements DomainUnitTest<Booking> {
    Person  john
    Room    room_1
    Booking booking_1

    def setup() {
        john   = new Person(firstName: "John", lastName: "Smith").save()
        room_1 = new Room(name: "Room 1", capacity: 10).save()
        booking_1 = new Booking(
            person:         john,
            room:           room_1,
            bookingDate:    today,
            timeslot:       Booking.AM)
            .save()
    }

    def cleanup() {
        john.delete()
        room_1.delete()
        booking_1.delete()
    }

    void "test constructor"() {
        when:"sample data is loaded"
            def bookings = Booking.list()

        then:"there is a booking"
            bookings.size() == 1
    }

    void "simple finder methods"() {
        expect:
        [booking_1] == Booking.findAllByPerson(john)
        [booking_1] == Booking.findAllByRoom(room_1)
        [booking_1] == Booking.findAllByBookingDate(today)
        [booking_1] == Booking.findAllByTimeslot(Booking.AM)
        []          == Booking.findAllByTimeslot(Booking.PM1)
        "Lecture"   == Booking.findAllByPurpose("Lecture").first().purpose
    }

    void "find all names of all rooms booked by john"() {
        expect:
        ["Room 1"] == Booking.findAllByPerson(john).room.name
    }

    void "find the first names of all people that booked rooms today or in the future"() {
        expect:
        ["John"] == Booking.findAllByBookingDateGreaterThanEquals(today).person.firstName
    }
}
