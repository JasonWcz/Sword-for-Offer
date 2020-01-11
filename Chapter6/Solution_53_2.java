package SwordForOffer.Chapter6;

/**
 *
 * @author wcz_j
 * 0到n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0到n-1之内。
 * 在范围0到n-1的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class Solution_53_2 {
    public int getMissingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) >> 1;
        while (left <= right) {
            if (nums[mid] != mid) {
                if (mid > 0 && nums[mid - 1] != mid - 1) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else {
                left = mid + 1;
            }
            mid = (left + right) >> 1;
        }
        /**这是下标与对应位置值都相等的情况，那么就少了n-1*/
        if (left == nums.length) {
            return left;
        }
        return -1;
    }
}
