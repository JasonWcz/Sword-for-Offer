package SwordForOffer.Chapter6;

import java.util.ArrayList;

/**
 * @author wcz_j
 * 和为S的连续正数序列
 * 所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 1.同样双指针首尾
 * 2.curSum暂存已有序列的和方便后续求和
 * 3.最少两个数字,因此small<(sum+1)/2才合理
 */
public class Solution_57_2 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int small = 1;
        int big = 2;
        int curSum = small + big;
        while (small < (sum + 1) / 2) {
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = small; i <= big; ++i) {
                    list.add(i);
                }
                result.add(list);
                ++big;
                curSum += big;
                continue;
            } else if (curSum < sum) {
                ++big;
                curSum += big;
            } else {
                ++small;
                curSum -= small-1;
            }
        }
        return result;
    }
}
