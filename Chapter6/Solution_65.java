package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * 不用加减乘除做加法
 *
 * 三步走:
 * 1.二进制不进位相加（等价于异或运算）得到A
 * 2.二进制只看进位（等价于与运算再左移一位）得到B
 * 3.二进制相加A、B(即回到第一步)
 *   直到最后没有进位，则A即为结果
 */
public class Solution_65 {
    public int Add(int num1,int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while(num2 != 0);
        return num1;
    }
}
