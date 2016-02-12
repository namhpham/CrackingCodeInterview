package c3.stackqueue;

import com.google.common.collect.ImmutableList;

import java.util.*;

/**
 * Transform word "HEAD" to "TAIL" - each transform is to change one letter at the different position than the previous transform and each transform results in a valid english word
 */
public class HEAD_TAIL {
    public static final List<String> dict = ImmutableList.of("HEAD", "TAIL","HEAL", "SEAL", "SELL", "TELL", "HEAL",
                                                             "TALL", "TEAL", "READ", "REID", "RAID", "RAIL", "HELL");

    private String transform(String str, int pos, char ch) {
        return str.substring(0, pos) + ch + str.substring(pos+1);
    }
    private void printResult(String src, String dst, Map<String, String> trace) {
        String str = dst;
        while (!str.equals(src)) {
            System.out.print(str + " -> ");
            str = trace.get(str);
        }
        System.out.println(src);
    }
    private boolean isValid(String str) {
        return dict.contains(str);
    }
    public boolean findPath(String src, String dst) {
        if (src == null || dst == null || src.length() != dst.length()) {
            return false;
        }
        if (src.equals(dst)) {
            return true;
        }
        int length = src.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(src);
        Map<String, String> trace = new HashMap<>();
        trace.put(src,"");
        while (!queue.isEmpty()) {
            String str = queue.poll();
            for (int i = 0; i < length; i++) {
                for (char ch = 'A'; ch <= 'Z'; ch++) {
                    String trans = transform(str, i, ch);
                    if (!trace.containsKey(trans) && isValid(trans)) {
                        queue.offer(trans);
                        trace.put(trans, str);
                        if (trans.equals(dst)) {
                            printResult(src, dst, trace);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HEAD_TAIL ht = new HEAD_TAIL();
        ht.findPath("HEAD", "TAIL");
        ht.findPath("READ", "TAIL");
        ht.findPath("SEAL", "TAIL");
    }
}
