package SwordForOffer.Chapter5;

public class Solution_50_1 {
    /**
     * 哈希: ASCII值做哈希值
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int [] hash = new int[256];
        for(int i = 0; i < str.length(); ++i) {
            ++hash[str.charAt(i)];
        }
        for(int i = 0; i < str.length(); ++i) {
            if (hash[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
