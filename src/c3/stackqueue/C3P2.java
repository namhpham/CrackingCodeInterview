package c3.stackqueue;

import java.util.Stack;

/**
 * Design stack with min, pop, push in O(1)
 */
public class C3P2 {
    public static class StackMin {
        private Stack<Integer> stackP;
        private Stack<Integer> stackM;
        public StackMin() {
            stackP = new Stack<>();
            stackM = new Stack<>();
        }
        public Integer pop() {
            if (stackP.isEmpty()) {
                return null;
            }
            stackM.pop();
            return stackP.pop();
        }
        public void push(int e) {
            if (stackP.isEmpty()) {
                stackP.push(e);
                stackM.push(e);
            } else {
                stackP.push(e);
                int curMin = stackM.peek();
                stackM.push(curMin < e ? curMin : e);
            }
        }

        public Integer getMin() {
            if (stackM.isEmpty()) {
                return null;
            }
            return stackM.peek();
        }

    }

    public static void main(String[] args) {
        C3P2.StackMin stack = new C3P2.StackMin();
        stack.push(5);
        System.out.println(stack.getMin());
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(2);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
