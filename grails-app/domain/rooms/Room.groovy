package rooms

class Room {
    String name
    int    capacity
    Admin  admin

    String toString() {
        "$name ($capacity ${admin?.name})"                    // groovy style
//        return name + " (" + capacity + ")"; // java style
    }

    static constraints = {
        name        nullable: false, blank: false
        capacity    min: 0
        admin       nullable: true
    }
}
