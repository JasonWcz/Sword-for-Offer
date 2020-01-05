package SwordForOffer.Chapter5;

public class Solution_49 {
    /**
     * 记录已知的丑数，后续丑数必然是已知某个丑数*2（3、5）
     * 为了排好序，每步将取*2，*3，*5中最小的一个
     * 并且持续更新m2,m3,m5保证每个乘积刚好大于当前最大的，不用每次从头计算
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int [] uglyNumber = new int[index];
        uglyNumber[0] = 1;
        int nextIndex = 1;
        int m2 = 0;
        int m3 = 0;
        int m5 = 0;
        while (nextIndex < index) {
            uglyNumber[nextIndex] = Math.min(uglyNumber[m2] * 2, Math.min(uglyNumber[m3] * 3,uglyNumber[m5] * 5));
            while (uglyNumber[m2] * 2 <= uglyNumber[nextIndex]) {
                ++m2;
            }
            while (uglyNumber[m3] * 3 <= uglyNumber[nextIndex]) {
                ++m3;
            }
            while (uglyNumber[m5] * 5 <= uglyNumber[nextIndex]) {
                ++m5;
            }
            ++nextIndex;
        }
        return uglyNumber[index-1];
    }
}
