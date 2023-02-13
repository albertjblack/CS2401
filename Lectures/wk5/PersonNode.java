public class PersonNode {
    PersonNode next = null;
    int id, hours;

    public PersonNode() {
    }

    public PersonNode(int id) {
        this.id = id;
    }

    public PersonNode(int id, int hours) {
        this.id = id;
        this.hours = hours;
    }
}
