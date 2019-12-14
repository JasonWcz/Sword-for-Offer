package SwordForOffer.Chapter3;


public class Solution_20 {
    private int index = 0;
    public  boolean isNumeric(char[] str) {
        if(str == null) {
            return false;
        }
        int length = str.length;
        boolean isNum = scanInteger(str, length);
        if(index <length && str[index] == '.') {
            ++index;
            isNum = scanUnsignedInteger(str, length) || isNum;
        }
        if(index <length && (str[index] == 'e' || str[index] == 'E')) {
            ++index;
            /**e的前面不是数字或者后面没有数字，皆不是数值*/
            isNum = isNum && scanInteger(str, length);
        }
        return isNum && index == length;
    }
    private boolean scanInteger(char[] str, int length) {
        if(index < length && (str[index] == '+' || str[index] == '-')) {
            ++index;
        }
        return scanUnsignedInteger(str, length);
    }
    private boolean scanUnsignedInteger(char[] str, int length) {
        int begin = index;
        while(index < length && str[index] >= '0' && str[index] <= '9') {
            ++index;
        }
        return index > begin;
    }
}
