package rooms

class Admin {

    String name
    String tel
    String cardNumber

    public String toString() {
        return name;
    }

    static constraints = {
        name        nullable: false, blank: false
        tel         nullable: true
        cardNumber  nullable: true
    }
}
