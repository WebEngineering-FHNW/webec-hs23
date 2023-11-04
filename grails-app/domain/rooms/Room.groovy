package rooms

class Room {
    String name
    int    capacity

    String toString() {
        "$name ($capacity)"                             // groovy style
//        return name + " (" + capacity + ")";          // java style
    }

    static constraints = {
        name        nullable: false, blank: false
        capacity    min: 0
    }
}
