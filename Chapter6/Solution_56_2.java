package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * 数组中唯一只出现一次的数字
 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。
 * 请找出那个只出现一次的数字。
 *
 * 1.化成二进制每个数位相加
 * 2.出现一次的数在某位上没有1，则该位最后的和一定整除3
 * 3.最后判断，并位运算加回来，得到结果
 */
public class Solution_56_2 {
    public int findNumberAppearingOnce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int [] bit = new int[32];
        for (int i = 0; i < nums.length; ++i) {
            /**用于检查某位是否为1*/
            int bitMask = 1;
            for (int j = 31; j >= 0; --j) {
                /**注意这里判断条件应为"!=0"，因为&运算结果不一定为1*/
                if ((bitMask & nums[i]) != 0) {
                    ++bit[j];
                }
                bitMask <<= 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            result <<= 1;
            /**出现一次的数在该位上有1，取模结果为1*/
            result += bit[i] % 3;
        }
        return result;
    }
}
