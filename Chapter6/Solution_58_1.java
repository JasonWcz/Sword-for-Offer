package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * "I am a student."翻转成"student. a am I"
 *
 * 先整体翻转，再逐个翻转
 */
public class Solution_58_1 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = (new StringBuilder(str)).reverse();
        String [] array = (sb.toString()).split(" ");
        /**全是空格直接返回*/
        if(array.length == 0){
            return str;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            if (i != 0) {
                result.append(" ");
            }
            result.append(new StringBuilder(array[i]).reverse());

        }
        return result.toString();
    }
}
