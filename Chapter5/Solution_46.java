package SwordForOffer.Chapter5;

public class Solution_46 {
    /**
     * 本题牛客没有新传送门: https://www.acwing.com/problem/content/description/55/
     * 由于正常自上而下递归会有很多重复子问题，反过来运行可避免
     * 继而采用dp
     * dp[i]表示从i开始可以有几种情况
     * 状态转移方程:
     *      dp[i] = dp[i+1] + g(i,i+1) * dp[i+2]
     *      g(i,i+1):当i和i+1合并数字∈[10-25],则g=1;否则g=0.
     * 最后注意起始状态，以及i>=length-2的状态即可
     * @param s
     * @return
     */
    public int getTranslationCount(String s) {
        int count;
        int [] dp = new int[s.length()];
        for(int i = s.length() - 1; i >= 0; --i) {
            count = 0;
            if (i < s.length() - 1) {
                count = dp[i+1];
            }
            /**起始状态*/
            else {
                count = 1;
            }
            if (i < s.length() - 1) {
                int digit1 = s.charAt(i) - '0';
                int digit2 = s.charAt(i+1) - '0';
                int number = digit1 * 10 + digit2;
                if (number >= 10 && number <= 25) {
                    if (i < s.length() - 2) {
                        count += dp[i+2];
                    }
                    /**i>=length-2，勿忘自身可以组成一个*/
                    else {
                        count += 1;
                    }
                }
            }
            dp[i] = count;
        }
        return dp[0];
    }
}
