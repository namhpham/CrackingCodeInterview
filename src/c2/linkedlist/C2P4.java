package c2.linkedlist;

/**
 * Created by nampham on 11/3/15.
 */
public class C2P4 {
    private void swap(Node p1, Node p2) {
        int temp = p1.data();
        p1.setData(p2.data());
        p2.setData(temp);
    }
    // not preserver order
    public Node partitaion1(Node head, int x) {
        Node p1= head;
        Node pp1 = null;
        while (p1.next() != null) {
            pp1 = p1;
            p1 = p1.next();
            if (p1.data() < x) { // insert as a new head
                pp1.next = p1.next;
                //put p1 as a new head
                p1.next = head;
                head = p1;
                p1 = pp1;
            }
        }
        return head;
    }
    // preserve order
    public Node partitaion2(Node node, int x) {
        Node head = null;
        Node tail = node;
        while (tail != null && tail.data < x) {
            head = tail;
            tail = tail.next;
        }
        tail = head;
        Node prev = null;
        while (tail.next != null) {
            prev = tail;
            tail = tail.next;
            if (tail.data < x) {
                prev.next = tail.next;
                if (head != null) {
                    tail.next = head.next;
                    head.next = tail;
                } else {
                    tail.next = node;
                    node = tail;
                }
                head = tail;
                tail = prev;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        C2P4 sol = new C2P4();
        Node head = Node.createSampleList0(11);
        Node.printList(head);
        //int x = head.next.next.data;
        int x = 5;
        System.out.println(x);
        head = sol.partitaion2(head, x);
        Node.printList(head);
        // test
        while (head != null && head.data < x) {
            head = head.next;
        }

        while (head != null) {
            if (head.data < x) {
                System.out.println("INCORRECT");
                return;
            }
            head = head.next;
        }
        System.out.println("CORRECT");
    }

}
