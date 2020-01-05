package SwordForOffer.Chapter5;

public class Solution_48 {
    /**
     * 传送门: https://www.acwing.com/problem/content/57/
     * 一道dp: dp[i]表示以i为结尾的最长不重复字符串
     * 状态转移方程:
     *      dp[i] = x * (dp[i-1]+1) + y * (i - preIndex)
     *      其中preIndex表示该位置相同字符上次出现的索引，(i-preIndex)为两者位置差d
     *      当d <= dp[i-1]时，则上个相同字符在当前统计的字符串中，那么x=0,y=1;
     *      当d > dp[i-1]时，则上个相同字符在当前统计的字符串外，那么x=1,y=0;
     *      最后一种当preIndex = -1即该字符未出现过，x=1,y=0。
     * 优化:
     *      直接用变量curLen表示统计到当前位置的结果（即用它代表dp[i]）
     *      因为dp[i]的值只需要dp[i-1]和preIndex，后者用一个数组记录。
     * @param s
     * @return
     */
    public int longestSubstringWithoutDuplication(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int [] alphabet = new int[26];
        for(int i = 0; i < 26; ++i) {
            alphabet[i] = -1;
        }
        int maxLen = 0;
        int curLen = 0;
        for(int i = 0; i < s.length(); ++i) {
            int preIndex = alphabet[s.charAt(i) - 'a'];
            if (preIndex < 0 || i - preIndex > curLen) {
                ++curLen;
            }
            else {
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
                curLen = i - preIndex;
            }
            alphabet[s.charAt(i) - 'a'] = i;
        }
        if (curLen > maxLen) {
            maxLen = curLen;
        }
        return maxLen;
    }
}
