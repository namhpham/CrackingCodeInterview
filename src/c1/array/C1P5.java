package c1.array;

/**
 * Created by nampham on 10/26/15.
 * Check whether two strings is one or zero edit away. An eligible edit is replace, remove or insert a character
 */
public class C1P5 {
    public static class OneAway {
        public boolean isOneEditAway(String s1, String s2) {
            int length1 = s1.length();
            int length2 = s2.length();
            if (Math.abs(length1 - length2) > 1) {
                return false;
            }
            int i = 0;
            int j = 0;
            int numEdit = 0;
            while (i < length1 && j < length2) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    numEdit++;
                    if (numEdit > 1) {
                        return false;
                    }
                    if (length1 > length2) {
                        i++;
                    } else if (length1 < length2) {
                        j++;
                    } else {
                        i++;
                        j++;
                    }
                }
            }
            if (i < length1 || j < length2) {
                return numEdit == 0;
            }
            return true;

        }
    }

    public static void main(String[] args) {
        OneAway oa = new OneAway();
        System.out.println(oa.isOneEditAway("12345","1234"));
        System.out.println(oa.isOneEditAway("12345","12645"));
        System.out.println(oa.isOneEditAway("","1234"));
        System.out.println(oa.isOneEditAway("123","134"));
        System.out.println(oa.isOneEditAway("5","1"));
        System.out.println(oa.isOneEditAway("ple","ple"));
        System.out.println(oa.isOneEditAway("pales","pale"));
        System.out.println(oa.isOneEditAway("pale","bale"));
        System.out.println(oa.isOneEditAway("pale","bake"));

    }
}
