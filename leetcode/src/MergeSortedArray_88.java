/**
 * Created by CS on 2018/3/11.
 */
public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        int idx1 = m - 1;
        int idx2 = n - 1;
        int len = m + n - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] > nums2[idx2]) nums1[len--] = nums1[idx1--];
            else nums1[len--] = nums2[idx2--];
        }
        while (idx2 >= 0) nums1[len--] = nums2[idx2--];
    }

}
