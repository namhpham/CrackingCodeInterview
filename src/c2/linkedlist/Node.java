package c2.linkedlist;

import java.util.Random;

/**
 * Created by nampham on 10/29/15.
 */
public class Node {
    Node next = null;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public Node setNext(Node next) {
        this.next = next;
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node next() {
        return next;
    }

    public int data() {
        return data;
    }

    public static void printList(final Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.data());
            if (node.next != null) {
                System.out.print(" -> ");
            } else {
                System.out.println();
            }
            node = node.next();
        }
    }

    public static Node createSampleList0(int size) {
        Node head = new Node(1);
        Node next = head;
        for (int i = 2; i <= size; i++) {
            next = next.setNext(new Node(size + 1 - i));
        }
        return head;
    }

    public static Node createSampleList1(int size) {
        Node head = new Node(1);
        Node next = head;
        for (int i = 2; i <= size; i++) {
            next = next.setNext(new Node(i));
        }
        return head;
    }

    public static Node createSampleList2(int size) {
        Node head = new Node(1);
        Node next = head;
        Random rand = new Random();
        for (int i = 2; i <= size; i++) {
            next = next.setNext(new Node(rand.nextInt(size)));
        }
        return head;
    }
}
