package c1.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nampham on 10/26/15.
 * Check whether a string has a permutation is a palindrome (the same string when read forward or backward)
 */
public class C1P4 {
    public static class PalindromePermutation {
        public boolean isPP(String s) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); i++) {
                Character ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }

            int count = 0;
            for (Integer freq : map.values()) {
                if (freq %2 != 0) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        System.out.println(pp.isPP("A"));
        System.out.println(pp.isPP("HELLO"));
        System.out.println(pp.isPP("HELLOOE"));
        System.out.println(pp.isPP("tactcoa"));
    }
}
