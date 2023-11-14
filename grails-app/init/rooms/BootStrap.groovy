package rooms

import java.text.SimpleDateFormat
import java.time.LocalDate
import grails.util.Environment

class BootStrap {

    static Date today      = toUtilDate(LocalDate.now())
    static Date tomorrow   = toUtilDate(LocalDate.now().plusDays(1))
    static Date yesterday  = toUtilDate(LocalDate.now().minusDays(1))

    /**
     * This method is called when the server starts.
     */
    def init    = { servletContext ->

        if (Environment.current == Environment.PRODUCTION) { return } // guard clause

        // in production or test, this might already be in the DB
        SecRole adminRole = save(SecRole.findOrCreateWhere(authority: SecRole.ADMIN))
        SecRole guestRole = save(SecRole.findOrCreateWhere(authority: SecRole.GUEST))

        SecUser testUser  = save(new SecUser(username: 'me',    password: 'bad'))
        SecUser guest     = save(new SecUser(username: 'guest', password: 'guest'))

        testUser.withTransaction { tx ->
            SecUserSecRole.create(testUser, adminRole, true) //flush
            SecUserSecRole.create(guest,    guestRole, true)
        }

        // plausibility check
        assert SecRole.count()          == 2
        assert SecUser.count()          == 2
        assert SecUserSecRole.count()   == 2

        // in dev and test mode, we populate the database with some sample data to work with

        Person dierk  = save(new Person(firstName: "Dierk",  lastName: "König"))
        Person dieter = save(new Person(firstName: "Dieter", lastName: "Holz"))

        Room room_5_1C54 = save(new Room(name: "5.1C54", capacity: 40))
        Room room_5_2H51 = save(new Room(name: "5.2H51", capacity: 40))
        Room room_1_013  = save(new Room(name: "1.013" , capacity: 80))

        Date mspDate    = new SimpleDateFormat("yyyy-MM-dd").parse("2024-02-06")

        // same person, same room, same timeslot, different dates
        save(new Booking(person: dierk,  room: room_5_1C54, bookingDate: yesterday, timeslot: Booking.AM))
        save(new Booking(person: dierk,  room: room_5_1C54, bookingDate: today,     timeslot: Booking.AM))
        save(new Booking(person: dierk,  room: room_5_1C54, bookingDate: tomorrow,  timeslot: Booking.AM))

        // same person, same room, different timeslot, same date
        save(new Booking(person: dierk,  room: room_5_1C54, bookingDate: today,     timeslot: Booking.PM1))

        // different person, same room, different timeslot, same date
        save(new Booking(person: dieter, room: room_5_1C54, bookingDate: today,     timeslot: Booking.PM2))

        // same person, different room, different timeslot, same date
        save(new Booking(person: dierk,  room: room_5_2H51, bookingDate: today,     timeslot: Booking.PM2))

        // room with higher capacity
        save(new Booking(person: dierk,  room: room_1_013,  bookingDate: mspDate,    timeslot: Booking.AM, purpose: "MSP"))

        // run some plausibility checks
        assert Person.count()  == 2
        assert Room.count()    == 3
        assert Booking.count() == 7

    }

    /**
     * Convenience method to save a domain object and throw an exception if validation fails.
     * @param domainObject
     * @return Object - the saved domain object
     */
    static <T> T save(T domainObject) {
        domainObject.save(failOnError: true) // will throw an exception if validation fails
        return domainObject
    }

    /**
     * Convenience method to convert a LocalDate to a java.util.Date
     * @param localDate
     * @return Date - a java.util.Date
     */
    static Date toUtilDate(LocalDate localDate) {
        // this is not the best way to do it in general but it works for our purposes
        return new Date(localDate.toEpochDay() * 24 * 60 * 60 * 1000)
    }

    def destroy = {
    }


}
