package c1.array;

/**
 * Created by nampham on 10/25/15.
 *
 * Replace a space with '%20' in a url string
 */
public class C1P3 {
    public static class URLify {
        public String update(String s) {
            int length = s.length();
            for (int i=0;i < s.length();i ++) {
                if (s.charAt(i) == ' ') {
                    length = length + 2;
                }
            }
            char[] url = new char[length];
            int j = length - 1;
            for (int i = s.length()-1; i >= 0; i--) {
                char ch = s.charAt(i);
                if (ch == ' ') {
                    url[j] = '0';
                    url[j-1] = '2';
                    url[j-2] = '%';
                    j = j - 3;
                } else {
                    url[j] = ch;
                    j--;
                }
            }
            return new String(url);
        }
    }
    public static void main(String[] args) {
        URLify urlify = new URLify();
        System.out.println(urlify.update("Hello  World   Developer"));
        System.out.println(urlify.update("Hello% 2 0World"));
        System.out.println(urlify.update(" "));
    }
}
