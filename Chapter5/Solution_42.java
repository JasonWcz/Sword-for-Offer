package SwordForOffer.Chapter5;

public class Solution_42 {
    /**
     * 注意全负的情况
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int [] dp = new int[array.length];
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; ++i) {
            if(i == 0 || dp[i - 1] < 0) {
                dp[i] = array[i];
            }
            else {
                dp[i] = dp[i - 1] + array[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
