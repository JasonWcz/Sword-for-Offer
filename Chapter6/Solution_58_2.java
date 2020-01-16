package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * n=2,则"abcd"翻转成"cdab"
 * 1.分两部分"ab" "cd" 各自翻转成"ba" "dc"
 * 2.拼接"badc"
 * 3.整体翻转得"cdab"
 */
public class Solution_58_2 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n == 0) {
            return str;
        }
        String left = str.substring(0,n);
        String right = str.substring(n);
        StringBuilder lb = new StringBuilder(left).reverse();
        StringBuilder rb = new StringBuilder(right).reverse();
        return lb.append(rb).reverse().toString();
    }
}
