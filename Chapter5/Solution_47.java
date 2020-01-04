package SwordForOffer.Chapter5;

public class Solution_47 {
    /**
     * 本题牛客没有，新传送门: https://www.acwing.com/problem/content/56/
     * dp[i][j]代表(i,j)位置最大值
     * 状态转移方程:
     *      dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + value[i][j]
     * 由于dp[i][j]只用到了dp[i-1][j]和dp[i][j-1]，即左、上两个格子
     * 因此可以优化dp数组为一维数组
     * 当更新到dp[j]时，0~j-1都已更新至第i行，j~length为i-1行
     * 状态转移方程可更改为:
     *      dp[j] = max(dp[j], dp[j-1]) + value[i][j];
     * 最后注意边界情况（i,j各自有==0时）
     * @param grid
     * @return
     */
    public int getMaxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid == null || row == 0 || col == 0){
            return 0;
        }
        int [] dp = new int[col];
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                int up = 0;
                int left = 0;
                if(i > 0) {
                    up = dp[j];
                }
                if(j > 0) {
                    left = dp[j-1];
                }
                dp[j] = Math.max(up, left) + grid[i][j];
            }
        }
        return dp[col-1];
    }
}
