package rooms

class PersonController {

    static scaffold = Person // it is important to keep this line such that we only materialize the minimum of what is needed

    def show(Long id) {
        Person person = Person.findById(id)
        List<Booking> bookings = Booking.findAllByPerson(person)
        render view:"show", model: [person:person, bookings:bookings]
    }

}
