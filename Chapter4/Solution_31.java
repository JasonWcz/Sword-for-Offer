package SwordForOffer.Chapter4;

import sun.security.x509.IssuingDistributionPointExtension;

import java.util.Stack;

public class Solution_31 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null && popA == null) {
            return true;
        }
        int length = pushA.length;
        if(length != popA.length) {
            return false;
        }
        boolean result = false;
        /**先把第一个数字压入，循环里就无需处理空栈的情况*/
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(pushA[0]);
        int index = 1;
        for(int i = 0; i < length; ++i) {
            /**1.这里注意要检查index不超过length
             * 2.检查pop序列该位置与栈顶元素是否相同
             * 2.1 相同则跳出循环，对应下面的if判断
             * 2.2 不同则一直将push序列中元素压入栈中，
             *     若出现全部入栈仍未找到相同，则对应下面else判断*/
            while(index < length && popA[i] != stack.peek()) {
                stack.push(pushA[index]);
                ++index;
            }
            /**该位置没问题，进行下一个元素检查，注意要将栈顶抛出*/
            if(popA[i] == stack.peek()) {
                result = true;
                stack.pop();
            }
            /**该位置未找到匹配，则该序列必不可能，直接break*/
            else {
                result = false;
                break;
            }
        }
        return result;
    }

}
