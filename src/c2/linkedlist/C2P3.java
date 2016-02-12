package c2.linkedlist;

/**
 * Created by nampham on 10/29/15.
 */
public class C2P3 {
    public Node removeMiddle(final Node head) {
        if (head == null) {
            return head;
        }
        Node p1 = head;
        Node p2 = head.next();
        Node prev = null;
        while (p2 != null) {
            prev = p1;
            p1 = p1.next();
            p2 = p2.next();
            if (p2 == null) { // even length linked list, no delete
                break;
            }
            p2 = p2.next();
            if (p2 == null) { //odd length, delete the middle p1
                prev.setNext(p1.next());
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        C2P3 sol = new C2P3();
        Node head = Node.createSampleList1(11);
        Node.printList(head);
        sol.removeMiddle(head);
        Node.printList(head);
    }
}
