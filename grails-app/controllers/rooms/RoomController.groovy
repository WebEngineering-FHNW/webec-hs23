package rooms

class RoomController {

    static scaffold = Room

    def tryRoom() {
//        List<Room> rooms = Room.list()
//        List<Room> rooms = Room.listOrderByCapacity()

        Admin hans  = new Admin(name: "Hans",  tel: "1234", cardNumber: "1234").save()
        Admin grete = new Admin(name: "Grete", tel: "4321", cardNumber: "4321").save()

        new Room(name: "5.1C56", capacity: 40, admin: hans).save()
        // java style
//        for (int i = 0; i < 10; i++) {
//            new Room(name: "Room " + i, capacity: i * 5).save()
//        }
        // groovy style
        10.times { n ->
            new Room(name: "Room " + n, capacity: n * 5, admin: grete).save()
        }

//        List<Room> rooms = Room.findAllByCapacityGreaterThan(30)
        List<Room> rooms = Room.findAllByAdmin(grete)
        String result = rooms.toString()
        render text: result
    }

}
