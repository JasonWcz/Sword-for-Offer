package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution_53_1 {
    /**
     * 二分的变形
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int start = FindFirstK(array, k, 0, array.length - 1);
        int end = FindLastK(array, k);
        if (start != -1 && end != -1) {
            return end - start;
        } else {
            return 0;
        }
    }

    /**
     * 二分找到第一个k
     * 递归写法
     * @param array
     * @param k
     * @param left
     * @param right
     * @return
     */
    public int FindFirstK(int [] array, int k, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >> 1;
        if (array[mid] == k) {
            if (mid > 0 && array[mid - 1] == k) {
                right = mid - 1;
            } else {
                return mid;
            }
        } else if (array[mid] > k) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return FindFirstK(array, k, left, right);
    }

    /**
     * 二分找到最后一个K
     * 循环写法
     * @param array
     * @param k
     * @return
     */
    public int FindLastK(int [] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) >> 1;
        while (left <= right) {
            if (array[mid] == k) {
                if (mid < array.length - 1 && array[mid + 1] == k) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) >> 1;
        }
        return -1;
    }
}
