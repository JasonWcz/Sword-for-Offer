package SwordForOffer.Chapter5;

public class Solution_43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0) {
            return 0;
        }
        String str = String.valueOf(n);
        return NumberOf1(str);
    }
    public int NumberOf1(String num) {
        if(num == null || num.isEmpty()) {
            return 0;
        }
        int first = num.charAt(0) - '0';
        int length = num.length();
        if(length == 1 && first == 0) {
            return 0;
        }
        if(length == 1 && first > 0) {
            return 1;
        }
        /**最高位*/
        int numFirstDigit = 0;
        if(first > 1) {
            numFirstDigit = (int) Math.pow(10, length - 1);
        }
        else if(first == 1) {
            numFirstDigit = Integer.valueOf(num.substring(1)) + 1;
        }
        /**除最高位后面部分
         * 如1346~21345（1346~11345，11346~21345）
         * 右边界相当于补了左边界最高位为0的情况*/
        int numOtherDigit = (int) (first * (length - 1) * Math.pow(10, length-2));
        /**1~次高位开始*/
        int numRecursive = NumberOf1(num.substring(1));
        return numFirstDigit + numOtherDigit + numRecursive;
    }
}
