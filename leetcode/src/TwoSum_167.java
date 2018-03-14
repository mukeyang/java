import java.util.Arrays;

/**
 * Created by CS on 2018/3/9.
 */
public class TwoSum_167 {
    public int[] twoSum(int[] numbers, int target) {
        int j;
        for (int i = 0; i < numbers.length - 1; i++) {

            if ((j = search(numbers, i, target - numbers[i])) != -1) return new int[]{i + 1, j + 1};

        }
        return null;
    }

    static int search(int[] numbers, int i, int target) {
        int low = i + 1;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (numbers[mid] == target) return mid;
            else if (numbers[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    public static int[] twoSum_2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            System.out.println(left + "----" + right);
            int value = numbers[left] + numbers[right];
            if (value == target) return new int[]{left + 1, right + 1};
            else if (value < target) left++;
            else right--;

        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum_2(new int[]{1, 3, 4, 8}, 6)));
    }
}
