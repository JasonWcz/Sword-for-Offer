package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * 求1+2+3+...+n
 *
 * 使递归在n<0时终止
 *
 * 此题对于c/c++还有其他方法
 */
public class Solution_64 {
    public int Sum_Solution(int n) {
        int res = n;
        boolean bool = (n > 0) && ((res += Sum_Solution(n-1)) > 0);
        return res;
    }
}
