package SwordForOffer.Chapter5;

import SwordForOffer.Chapter2.Solution_13;

public class Solution_44 {
    private int digitAtIndex(int index) {
        if(index < 0) {
            return -1;
        }
        /**表示几位数*/
        int digits = 1;
        while (true) {
            int number = countOfInteger(digits);
            if(index < number * digits) {
                return digitAtIndex(index, digits);
            }
            index -= number * digits;
            ++digits;
        }
    }

    /**
     * 计算x位数占了多少位
     * @param digits
     * @return x位数总共占的位数
     */
    private int countOfInteger(int digits) {
        if(digits == 1) {
            return 10;
        }
        return (int) (9 * Math.pow(10, digits-1));
    }

    /**
     * 找到该数
     * @param index
     * @param digits
     * @return
     */
    private int digitAtIndex(int index, int digits) {
        int number = firstNumber(digits) + index / digits;
        int loopTime = digits - index % digits;
        for(int i = 1; i < loopTime; ++i) {
            number /= 10;
        }
        return number % 10;
    }

    /**
     * 获得x位数的第一个值
     * @param digits
     * @return
     */
    private int firstNumber(int digits) {
        if(digits == 1) {
            return 0;
        }
        return (int) Math.pow(10, digits-1);
    }
}
