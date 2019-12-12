package SwordForOffer.Chapter3;


/**
 * @author wcz_j
 *
 * 对n个位置进行递归全排列
 */
public class Solution_17 {
    public static void PrintToMaxOfNDigits(int n){
        if(n < 0) {
            return;
        }
        char[] number = new char[n];
        for(int i = 0; i < 10; ++i){
            number[0] = (char)(i + '0');
            PrintToMaxOfDigitsRecursively(number, n, 0);
        }
    }

    /**
     * 此方法第一次到达递归终点时，全都为0不应输出，这在输出方法中做了处理
     * @param number
     * @param length
     * @param index
     */
    public static void PrintToMaxOfDigitsRecursively(char[] number, int length, int index){
        if(index == length - 1){
            PrintNumber(number);
            return;
        }
        for(int i = 0; i < 10; ++i){
            number[index + 1] = (char)(i + '0');
            PrintToMaxOfDigitsRecursively(number, length, index + 1);
        }
    }

    /**
     * 打印字符串
     * @param number
     */
    public static void PrintNumber(char[] number){
        /**设置一个标志，当遇到第一个不为0的位置时，即可开始打印*/
        boolean flag = true;
        int len = number.length;
        for(int i = 0; i < len; ++i){
            if(flag && number[i] != '0'){
                flag = false;
            }
            if(!flag){
                System.out.print(number[i]);
            }
        }
        /**检查标志如果一直为true则是第一次递归结束，所有位置为0，不需换行*/
        if(!flag){
            System.out.println();
        }
    }
}
