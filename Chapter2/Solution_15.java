package SwordForOffer.Chapter2;

/**
 * @author wcz_j
 */
public class Solution_15 {
    /**
     * 1. n-1可以将二进制中右边第一个1后面的0全部置1
     * 2. 再与原数做与运算，则不改变上述位置左边，将右边全部置1
     * 如上两个步骤反复则可循环m次找到所有1（m则为1的个数）
     * @param n
     * @return 二进制中1的个数
     */
    static public int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            n = (n-1) & n;
            ++count;
        }
        return count;
    }

}
