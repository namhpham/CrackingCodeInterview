package c2.linkedlist;

/**
 * Check whether  a linked list is a palindrome
 *
 */
public class C2P6 {
    private Node head;
    public C2P6(final Node head) {
        this.head = head;
    }
    private boolean check(final Node revHead) {
        if (revHead != null) {
            boolean result = check(revHead.next);
            if (!result || revHead.data != head.data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome() {
        return check(head);
    }

    public boolean isPalindrome(Node head) {
        return check1(head, head).isPalindrome;
    }

    private NodeInfo check1(final Node revHead, final Node head) {
        if (revHead == null) { // a trick to store 'global' variable
            return new NodeInfo(head, true);
        }
        NodeInfo info = check1(revHead.next, head);
        if (!info.isPalindrome || revHead.data != info.node.data) {
            info.isPalindrome = false;
            return info;
        }
        info.node = info.node.next;
        return info;
    }

    public class NodeInfo {
        boolean isPalindrome = false;
        Node node = null;
        public NodeInfo(Node node, boolean isPalindrome) {
            this.node = node;
            this.isPalindrome = isPalindrome;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
//        head.setNext(new Node(22));
//        head.setNext(new Node(2)).setNext(new Node(2)).setNext(new Node(2));
        head = Node.createSampleList2(5);
        C2P6 sol = new C2P6(head);
        Node.printList(head);
        System.out.println(sol.isPalindrome(head));
        System.out.println(sol.isPalindrome());
    }
}
