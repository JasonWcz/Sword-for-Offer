package SwordForOffer.Chapter6;

import java.util.Arrays;

/**
 *
 * @author wcz_j
 * 扑克牌中的顺子
 * 判断抽到的牌是否为顺子
 *
 * 最后注意大小王大于等于4张牌时必为顺子
 */
public class Solution_61 {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int gaps = 0;
        int zeros = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] == 0) {
                ++zeros;
            }
            if (i != 0 && numbers[i - 1] != 0) {
                if (numbers[i] == numbers[i - 1]) {
                   return false;
                } else {
                    gaps += numbers[i] - numbers[i - 1] - 1;
                }
            }
        }
        return (gaps == zeros) || zeros >= 4 ? true : false;
    }
}
