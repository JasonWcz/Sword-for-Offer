package SwordForOffer.Chapter6;

/**
 *
 * @author wcz_j
 * 圆圈中最后剩下的数
 * 约瑟夫环问题
 *
 * 除了模拟，还有下述的数学方法
 * f(n,m)表示n个数中删除第m个数字最后剩下的数字
 *          | 0                   n=1
 * f(n,m) = |
 *          | [f(n-1,m) + m] % n  n>1
 */
public class Solution_62 {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int res = 0;
        for (int i = 2; i <= n; ++i) {
            res = (res + m) % i;
        }
        return res;
    }
}
