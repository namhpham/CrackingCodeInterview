package c2.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nampham on 10/29/15.
 * Remove duplicates from unsorted linked list
 */
public class C2P1 {
    public static class RemoveDupNode {
        public void removeDup(final Node head) {
            if (head == null) {
                return;
            }
            Node cur = head;
            Node prev = null;
            Set<Integer> set = new HashSet<>();
            while (cur != null) {
                int data = cur.data();
                if (set.contains(data)) {
                    prev.setNext(cur.next());
                } else {
                    set.add(data);
                    prev = cur;
                }
                cur = cur.next();
            }

        }

        public void removeDupWithoutBuffer(final Node head) {
            Node cur = head;
            while (cur != null) {
                Node node = cur.next();
                Node prevNode = cur;
                while (node != null) {
                    if (node.data() == cur.data()) {
                        prevNode.setNext(node.next());
                    } else {
                        prevNode = node;
                    }
                    node = node.next();
                }
                cur = cur.next();
            }
        }
    }

    public static void main(String[] args) {
        RemoveDupNode removeDupNode = new RemoveDupNode();
        Node head = new Node(1);
        head.setNext(new Node(1)).setNext(new Node(1)).setNext(new Node(2)).setNext(new Node(2));

        Node.printList(head);
        removeDupNode.removeDup(head);
        Node.printList(head);

        Node head1 = new Node(1);
        head1.setNext(new Node(2)).setNext(new Node(3)).setNext(new Node(4)).setNext(new Node(5));
        Node.printList(head1);
        removeDupNode.removeDupWithoutBuffer(head1);
        Node.printList(head1);
    }
}
