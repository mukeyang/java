package algs4.Capter1;

import java.util.Arrays;

/**
 * Created by CS on 2018/3/15.
 */
public class LongestContinuousIncreasingSubsequence_674 {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] < nums[i]) res = Math.max(res, ++cnt);
            else cnt = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(1, 2, 3, 4).stream().reduce(0, (a, b) -> a + b));
    }
}
