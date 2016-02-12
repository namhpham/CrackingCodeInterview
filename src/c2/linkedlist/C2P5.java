package c2.linkedlist;

/**
 * Created by nampham on 11/11/15.
 * Sum of two linked list in reversed order. Try to do it with natural order
 */
public class C2P5 {
    public Node getSum(final Node num1, final Node num2) {
        Node head1 = num1;
        Node head2 = num2;
        Node head = null;
        Node tail = null;
        int carryOver = 0;
        while (head1 != null || head2 != null || carryOver > 0) {
            int val1 = 0;
            if (head1 != null) {
                val1 = head1.data;
                head1 = head1.next;
            }
            int val2 = 0;
            if (head2 != null) {
                val2 = head2.data;
                head2 = head2.next;
            }
            int sum = val1 + val2 + carryOver;
            carryOver = sum / 10;
            Node node = new Node(sum%10);
            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }
    public class Result {
        Node node;
        int carryOver;
        public Result(Node node, int carryOver) {
            this.carryOver = carryOver;
            this.node = node;
        }
    }
    private Result traverse(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return new Result(null, 0); // a trick to avoid using global variable
        }
        int val1 = head1.data;
        int val2 = head2.data;

        Result result = traverse(head1.next, head2.next);
        int sum = val1 + val2 + result.carryOver;
        int carryOver = sum / 10;
        Node node = new Node(sum % 10);
        node.next = result.node;
        return new Result(node, carryOver);
    }

    private int getLength(Node head) {
        Node node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    private Node paddingZero(final Node head, final int size) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            Node zero = new Node(0);
            zero.next = node;
            node = zero;
        }
        return node;
    }

    public Node getSum2(final Node num1, final Node num2) {
        Node head1 = num1;
        Node head2 = num2;
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        if (length1 > length2) {
            head2 = paddingZero(head2, length1 - length2);
        } else {
            head1 = paddingZero(head1, length2 - length1);
        }
        Result result = traverse(head1, head2);
        if (result.carryOver > 0) {
            Node node = new Node(result.carryOver);
            node.next = result.node;
            return node;
        }
        return result.node;
    }

    public static void main(String[] args) {
        Node head1 = new Node(9);
        head1.setNext(new Node(9));
        Node head2 = new Node(9);
        head2.setNext(new Node(1)).setNext(new Node(9));
        Node.printList(head1);
        Node.printList(head2);
        C2P5 sol = new C2P5();
        Node head = sol.getSum2(head1, head2);
        Node.printList(head);
    }
}
