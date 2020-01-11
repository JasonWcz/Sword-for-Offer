package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * 数组中数值和下标相等的元素
 */
public class Solution_53_3 {
    public int getNumberSameAsIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) >> 1;
        while (left <= right) {
            if (nums[mid] == mid) {
                return  mid;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            } else {
              left = mid + 1;
            }
            mid = (left + right) >> 1;
        }
        return -1;
    }
}
