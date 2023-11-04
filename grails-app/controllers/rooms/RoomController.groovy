package rooms

class RoomController {

    static scaffold = Room

    def tryRoom() { // experiment with dynamic finder methods

        List<Room> rooms = Room.list()
//        List<Room> rooms = Room.listOrderByCapacity()
//        List<Room> rooms = Room.findAllByCapacityGreaterThan(30)

        String result = rooms.toString()
        render text: result
    }

}
