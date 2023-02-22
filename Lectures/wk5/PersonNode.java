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

    /*
     * public void addFirst(E e) {
     * Node<E> newNode = new Node<>(e); // Create a new node
     * newNode.next = head; // link the new node with the head
     * head = newNode; // head points to the new node
     * size++; // Increase list size
     * 
     * if (tail == null) // the new node is the only node in list
     * tail = head;
     * }
     */

}
