package rooms


class RoomController {

    static scaffold = Room

    def show(Long id) {
        Room room = Room.findById(id)
        List<Booking> bookings = Booking.findAllByRoom(room)
        render view:"show", model: [room:room, bookings:bookings]
    }

}
