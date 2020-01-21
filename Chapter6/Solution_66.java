package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * 构建乘积数组
 *
 * 构建B[i]不需要A[i]
 * 则可按矩阵(如下)对角线将运算分为
 *      C[i] = A[0]*...A[i-1]
 *      D[i] = A[i+1]*...A[n]
 * 那么B[i] = C[i] * D[i]
 * C D分别可自上到下、自下向上运算
 * 因此两次循环可得结果
 *
 * B0:   1   A1    A2
 * B1:  A0    1    A2
 * B2:  A0   A1     1
 */
public class Solution_66 {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int [] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; ++i) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int carry = 1;
        for (int i = A.length - 2; i >= 0; --i) {
            B[i] *= carry * A[i + 1];
            carry *= A[i + 1];
        }
        return B;
    }
}
