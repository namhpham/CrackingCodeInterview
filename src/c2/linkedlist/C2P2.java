package c2.linkedlist;

/**
 * Created by nampham on 10/29/15.
 *
 * Find kth node to the last in the singly linked list
 */
public class C2P2 {
    public Node getKthNode(final Node head, final int k) {
        if (head == null) {
            return head;
        }
        Node curNode = head;
        Node nextNode = head;
        for (int i = 0;i < k; i++) {
            nextNode = nextNode.next();
            if (nextNode == null) {
                return curNode;
            }
        }
        while (nextNode != null) {
            curNode = curNode.next();
            nextNode = nextNode.next();
        }
        return curNode;
    }
    public static void main(String[] args) {
        C2P2 solution = new C2P2();
        Node head = Node.createSampleList1(10);
        Node.printList(head);
        Node kNode = solution.getKthNode(head, 10);
        System.out.println(kNode.data());
    }
}
