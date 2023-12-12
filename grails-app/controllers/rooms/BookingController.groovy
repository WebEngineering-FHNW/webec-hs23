package rooms

class BookingController {
    def springSecurityService

    static scaffold = Booking

    def myBookings() {
        if (!springSecurityService.isLoggedIn()) {
            redirect(controller: 'login', action: 'auth', params: params)
            return
        }
        SecUser secUser           = springSecurityService.currentUser
        Person person             = Person.findBySecUser(secUser)
        List<Booking> bookingList = Booking.findAllByPerson(person)
        render view:"index", model:[bookingList: bookingList, person: person]
    }

}
