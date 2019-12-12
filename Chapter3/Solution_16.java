package SwordForOffer.Chapter3;

/**
 * @author wcz_j
 */
public class Solution_16 {
     public static double Power(double base, int exponent) {
        if(base == 0){
            return 0;
        }
        int absExp = exponent;
        if(exponent < 0){
            absExp *= -1;
        }
        double result = power(base, absExp);
        if(exponent < 0){
            result = 1.0/result;
        }
        return result;
    }

    /**
     * 具体递归计算的方法
     * @param base
     * @param exp
     * @return
     */
    public static double power(double base, int exp) {
        if(exp == 0){
            return 1;
        }
        if(exp == 1){
            return base;
        }
        double result = power(base, exp >> 1);
        result *= result;
        /**如果指数为奇数，则还需乘一次底数*/
        if((exp & 0x1) == 1){
            result *= base;
        }
        return result;
    }
}
