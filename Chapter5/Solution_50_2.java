package SwordForOffer.Chapter5;

public class Solution_50_2 {
    private int index;
    public Solution_50_2() {
        this.index = 0;
        for(int i = 0; i < 256; ++i) {
            hash[i] = -1;
        }
    }

    /**
     * hash数组里存对应字符在字符串中的位置
     * 初始化为-1，表示没出现过
     * -2表示出现了不止一次
     * >=0即为出现一次的位置
     */
    private int [] hash = new int[256];

    public void Insert(char ch) {
        if (hash[ch] == -1) {
            hash[ch] = index;
        } else if (hash[ch] >= 0) {
            hash[ch] = -2;
        }
        ++index;
    }

    /**
     * 由于字符流每进来一个字符都要检查
     * 因此每次要选出位置最靠前的
     * @return
     */
    public char FirstAppearingOnce() {
        char result = '#';
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0; i < 256; ++i) {
            if (hash[i] >= 0 && minIndex > hash[i]) {
                result = (char)i;
                minIndex = hash[i];
            }
        }
        return result;
    }
}
