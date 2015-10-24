import java.util.HashMap;
import java.util.Map;

/**
 * Created by nampham on 10/23/15.
 */
public class C1P2 {
    public static class PermutationString{
        public boolean isPermutationString(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            Map<Character, Integer> map = new HashMap();

            for (int i = 0; i < s1.length(); i++) {
                Character key = s1.charAt(i);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }

            for (int i = 0; i < s1.length(); i++) {
                Character key = s2.charAt(i);
                if (!map.containsKey(key)) {
                    return false;
                }
                map.put(key, map.get(key) - 1);
            }

            for (Integer count : map.values()) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        PermutationString ps = new PermutationString();
        System.out.println(ps.isPermutationString("hello","olleh"));
        System.out.println(ps.isPermutationString("aabbb","abaabb"));
        System.out.println(ps.isPermutationString("aabbb","abaab"));
        System.out.println(ps.isPermutationString("aabbb","bbaab"));
        System.out.println(ps.isPermutationString("abcdef","aedbfc"));
    }
}
