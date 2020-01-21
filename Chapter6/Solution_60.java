package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * 骰子的点数
 * 将一个骰子投掷n次，获得的总点数为s，s的可能范围为n~6n。
 * 请求出投掷n次，掷出n~6n点分别有多少种掷法。
 *
 * 这题书里写的很不清楚
 * 下面这种写法个人觉得比较不错
 * dp[i][j]表示:i个骰子的时候，和为j一共有多少种组合
 * 状态转移方程:
 *     dp[i][j] += dp[i - 1][j - k]
 *     表示假设确定当前新骰子点数为k，
 *     那么和为j时，组合数只要加上前面i-1个骰子和为j-k的次数即可
 * 最后答案为dp[n][n:n*6]
 *
 * 本题还可以对空间进行优化，可以只用两个长度为n*6+1的数组来交替赋值使用
 */
public class Solution_60 {
    static public int[] numberOfDice(int n) {
        if (n < 1) {
            return null;
        }
        int [][] dp = new int[n+1][n * 6 + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j < n * 6 + 1; ++j) {
                for(int k = 1; k <= Math.min(j, 6); ++k) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        int flag = 0;
        int [] res = new int[n * 6 - n + 1];
        for (int i = n; i < n * 6 + 1; ++i) {
            res[flag++] = dp[n][i];
        }
        return res;
    }

}
