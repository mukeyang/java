/**
 * Created by CS on 2018/3/11.
 */
public class MissingNumber_268 {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (int) (0.5 * len * (len + 1));
        for (int i : nums) sum -= i;
        return sum;
    }

    public int missingNumber_2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber_268().missingNumber_2(new int[]{0, 1, 2, 3}));
    }
}
