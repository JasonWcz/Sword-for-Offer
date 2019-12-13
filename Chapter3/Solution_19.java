package SwordForOffer.Chapter3;

public class Solution_19 {
    public static boolean match(char[] str, char[] pattern) {
        if(str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, str.length, pattern, 0, pattern.length);
    }
    public static boolean matchCore(char[]  str, int idxS, int lenS, char[] pattern, int idxP, int lenP) {
        if(idxS == lenS && idxP == lenP) {
            return true;
        }
        if(idxS != lenS && idxP == lenP) {
            return false;
        }
        if(idxP + 1 != lenP && pattern[idxP + 1] == '*') {
            System.out.println(111111);
            /**先检查index是否越界，否则当str为空的时候会抛异常*/
            if(idxS != lenS && (pattern[idxP] == str[idxS] || pattern[idxP] == '.')) {
                /**如果该位置可以匹配，后面又有'*'，那么有三种情况
                 * 1.匹配一次（即*=1），那么递归下层模式串跳到下一个，字符串也跳到下一个
                 * 2.匹配多次（即*=n），那么递归下层模式串依然在该位置，字符串跳到下一个
                 * 3.匹配0次（即*=0），那么递归下层模式串跳到下一个，字符串依然在原位置*/
                return matchCore(str, idxS + 1, lenS, pattern, idxP + 2, lenP)
                        || matchCore(str, idxS + 1, lenS, pattern, idxP, lenP)
                        || matchCore(str, idxS, lenS, pattern, idxP + 2, lenP);
            }
            else {
                return matchCore(str, idxS, lenS, pattern, idxP + 2, lenP);
            }
        }
        if(idxS != lenS && (pattern[idxP] == str[idxS] || pattern[idxP] == '.')) {
            return matchCore(str, idxS + 1, lenS, pattern, idxP + 1, lenP);
        }
        return false;
    }

}
