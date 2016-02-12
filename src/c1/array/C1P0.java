package c1.array;

/**
 * Created by nampham on 10/27/15.
 * Twitter Interview Question:
 * An array of columns with different heights. Fill the array with water from the top. How many unit of water stuck between columns.
 * For example: 4 2 5 -> 2; 5 1 1 5 -> 8
 *
 * Answer: the idea here is to locate the left most i and right most j column such that col[i] > col[i+1] >...>col[k]<col[k+1] <....<col[j] - Think about
 * "U shape" parabola.
 * Easy to notice column i and j are the local-top columns (.i.e col[i] > col[i-1] && col[i] > col[i+1], same with jth column
 * It leads to an approach of finding all local-top columns and find water between them.
 * However, we need to skip the top column which is surround by other higher top columns.
 *
 */
public class C1P0 {
    public static class WaterColumn{
        private int calWaterRange(int[] col, int i, int j) {
            int limit = Math.min(col[i], col[j]);
            int sum = 0;
            for (int k = i + 1; k < j; k++) {
                sum += limit - col[k];
            }
            return sum;
        }
        public int calWater(int[] col) {
            int n = col.length;
            if (n < 3) {
                return 0;
            }
            int[] topColumn = new int[n];
            int m = 0;
            for (int i = 0; i < n; i++) {
                // check the first and last element as top columns as well
                if ((i == n - 1 || col[i] > col[i+1])
                        && (i == 0 || col[i] > col[i-1])) {
                    // only add a new high point that does not create a dip at the current top column
                    if (m  < 2 ||
                            col[topColumn[m-2]] < col[topColumn[m-1]] ||
                            col[i] < col[topColumn[m-1]]) {
                        topColumn[m] = i;
                        m++;
                    } else { // override the current top column
                        topColumn[m-1] = i;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < m - 1; i++) {
                sum += calWaterRange(col, topColumn[i], topColumn[i+1]);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        WaterColumn wc = new WaterColumn();
        System.out.println(wc.calWater(new int[]{5, 1, 2, 3, 1, 2, 6, 2, 3}));
        System.out.println(wc.calWater(new int[]{5, 2, 1}));
        System.out.println(wc.calWater(new int[]{5, 1, 4}));
        System.out.println(wc.calWater(new int[]{4, 1, 1, 5}));
        System.out.println(wc.calWater(new int[]{2, 1, 4, 1, 2, 1, 1, 3, 5}));
    }
}
