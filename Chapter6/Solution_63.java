package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖一次该股票可能获得的利润是多少？
 * 例如一只股票在某些时间节点的价格为[9, 11, 8, 5, 7, 12, 16, 14]。
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11。
 *
 * 由于股票按时间节点来，因此不能排序算最大最小差值
 * 简单的dp
 * dp[i]表示到时间节点i为止，能获得的最大收益
 * 状态转移方程:
 *      dp[i] = max(nums[i] - min, dp[i-1])
 *      min表示前面时间中的最低价格
 * 答案为dp[n]
 */
public class Solution_63 {
    public int maxDiff(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        int [] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = Math.max(nums[i] - min, dp[i - 1]);
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return dp[nums.length - 1];
    }
}
