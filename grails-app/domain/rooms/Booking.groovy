package rooms

class Booking {

    String purpose = "Lecture"
    Person person
    Room   room
    Date   bookingDate   // a date where we ignore the time and assume 00:00:00
    String timeslot      // one of AM, PM1, PM2

    public static final String AM  = "08:15 - 11:00"
    public static final String PM1 = "12:15 - 15:00"
    public static final String PM2 = "15:15 - 18:00"

    static constraints = {
        purpose     ()
        person      nullable: false
        room        nullable: false
        bookingDate nullable: false
        timeslot    nullable: false, inList: [AM, PM1, PM2]
    }
}
