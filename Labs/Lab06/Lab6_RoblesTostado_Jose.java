// Jose A. Robles Tostado
// jaroblestos@miners.utep.edu

public class Lab6_RoblesTostado_Jose {

    public static void main(String args[]) {

        Person head1 = new Person("bob", 1);
        head1.next = new Person("jose", 2);
        head1.next.next = new Person("hannah", 4);
        head1.next.next.next = new Person("angel", 7);
        head1.next.next.next.next = new Person("eve", 8);

        Person head2 = new Person("jose", 2);
        head2.next = new Person("alex", 3);
        head2.next.next = new Person("neven", 5);
        head2.next.next.next = new Person("angel", 7);

        Person head = mergeSortedLL(head1, head2);
        System.out.println("---------After merge:---------\n");
        printLL(head);

        Person new_node = new Person("sillis", 6);
        head = insertInSortedOrder(head, new_node);
        Person new_node2 = new Person("mateo", 0);
        head = insertInSortedOrder(head, new_node2);
        System.out.println("-----After adding new node in sorted order:----\n");
        printLL(head);

        head = deleteDuplicate(head);
        System.out.println("-----After deleting duplicates:-----\n");
        printLL(head);

        head = reverseLL(head);
        System.out.println("----------After reverse:----------\n");
        printLL(head);

        System.out.println("----------Palindromic Names:----------\n");
        printPalindromicNames(head);

    }

    public static void printLL(Person curr) {

        if (curr == null)
            return;

        System.out.println(curr);
        printLL(curr.next);
    }

    public static Person mergeSortedLL(Person curr1, Person curr2) {
        Person mergeHead = null;

        // check if one node is none, then we return the other
        if (curr1 == null) {
            return curr2;
        }

        if (curr2 == null) {
            return curr1;
        }

        // if we have not returned, then both nodes exists, so -> init mergehead with
        // smallest
        if (curr1.getId() < curr2.getId()) {
            mergeHead = curr1;
            curr1 = curr1.next;

        } else {
            mergeHead = curr2;
            curr2 = curr2.next;
        }

        // temp head to maintain head
        Person temp = mergeHead;

        // start building mergeHead (ascending order)
        while (curr1 != null && curr2 != null) {
            if (curr1.getId() < curr2.getId()) {
                temp.next = curr1;
                temp = temp.next;
                curr1 = curr1.next;
            } else {
                temp.next = curr2;
                temp = temp.next;
                curr2 = curr2.next;
            }
        }

        // if any left, just make temp point to it
        if (curr1 != null) {
            temp.next = curr1;
        } else {
            temp.next = curr2;
        }

        return mergeHead;

    }

    public static Person insertInSortedOrder(Person curr, Person new_node) {
        // no head, return new node
        if (curr == null) {
            return new_node;
        }

        // if node id is smaller, make it the head
        if (curr.getId() > new_node.getId()) {
            new_node.next = curr;
            return new_node;
        }

        // find position to insert new node if it is not the biggest id
        Person temp = curr;
        while (temp != null && temp.next != null) {
            if (temp.next.getId() > new_node.getId()) {
                Person _tmp = temp.next;
                temp.next = new_node;
                temp = temp.next;
                temp.next = _tmp;
                return curr;
            } else {
                temp = temp.next;
            }
        }

        // if biggest id, then make it last
        temp.next = new_node;
        return curr;
    }

    public static Person deleteDuplicate(Person curr) {

        // while we have both temp and temp.next
        // we will chek if dups
        // if dups we will jump over dup
        Person temp = curr;
        while (temp != null && temp.next != null) {
            if (temp.getId() == temp.next.getId()) {
                temp.next = temp.next.next;
                temp = temp.next;
            } else {
                temp = temp.next;
            }
        }

        return curr;
    }

    public static Person reverseLL(Person curr) {

        // we need to store the previous pointer
        // we will reverse all pointers until we have no more valid pointers to reverse
        // return the last version of current, which will be the new head
        Person prev = null;
        Person _tmp = new Person();
        while (curr != null) {
            _tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = _tmp;
        }

        return prev;
    }

    // helper
    public static boolean isPalindrome(String name, int start, int end) {

        // check if letters are same, end and start, if not, return false
        while (start <= end) {
            if (name.charAt(start) != name.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        // if we haven't returned -> we have a palindrome
        return true;

    }

    public static void printPalindromicNames(Person curr) {
        if (curr == null) {
            return;
        }
        if (isPalindrome(curr.getName(), 0, curr.getName().length() - 1)) {
            System.out.println(curr.getName() + " is a Palindrome");
        }
        printPalindromicNames(curr.next);

    }

}