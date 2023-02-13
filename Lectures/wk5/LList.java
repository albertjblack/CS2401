public class LList {

    public static void main(String args[]) {
        PersonNode p1 = new PersonNode(101);
        PersonNode p2 = new PersonNode(102, 3);
        PersonNode p3 = new PersonNode(107, 8);
        PersonNode p4 = new PersonNode(112, 1);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        printLL(p1);

        System.out.println();

        addNode(p1, new PersonNode(120, 1), 2);
        printLL(p1);

        removeNode(p1, 2);
        printLL(p1);

    }

    public static void printLL(PersonNode head) {
        if (head == null) {
            return;
        }

        PersonNode curr = head;
        while (curr != null) {
            System.out.print(curr.id + " ");
            curr = curr.next;
        }
    }

    public static PersonNode addNode(PersonNode head, PersonNode node, int pos) {
        if (head == null) {
            return node;
        }

        if (pos < 0) {
            return null;
        }

        if (pos == 0) {
            node.next = head;
            return node;
        }

        int curr_pos = 0;
        PersonNode curr_node = head;
        while (curr_node.next != null && curr_pos < (pos - 1)) {
            curr_pos++;
            curr_node = curr_node.next;
        }

        if (curr_node.next == null) {
            System.out.println("The position <" + pos
                    + "> exceeds the maximum position. The node will be added at the end of the list with position <"
                    + curr_pos + ">");
            curr_node.next = node;

        } else {
            System.out
                    .println("Node added at <" + pos + ">. The previous node at that position will be now at position <"
                            + (pos + 1) + ">");
            PersonNode temp_node = curr_node.next;
            curr_node.next = node;
            node.next = temp_node;
        }

        return head;

    }

    public static PersonNode removeNode(PersonNode head, int pos) {
        if (head == null) {
            return null;
        }

        int curr_pos = 0;
        PersonNode curr_node = head;

        while (curr_node.next != null && curr_pos < (pos - 1)) {
            curr_pos++;
            curr_node = curr_node.next;
        }

        if (curr_node.next == null) {
            System.out.println("The position <" + pos
                    + "> exceeds the maximum position. The node does not exists, thus it cannot be removed");
        } else {
            System.out
                    .println("The node at <" + pos + "> has been removed successfully.");
            PersonNode temp = curr_node.next;
            curr_node.next = curr_node.next.next;
            temp.next = null;
            temp = null;
        }

        return head;
    }

};