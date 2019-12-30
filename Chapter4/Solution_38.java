package SwordForOffer.Chapter4;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution_38 {
    /**
     * 用TreeSet是为了排除重复项
     * 并且按字典序排列
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        if(str.isEmpty()) {
            return new ArrayList<String>();
        }
        ArrayList<String> list = new ArrayList<String>();
        TreeSet<String> set = new TreeSet<String>();
        Permutation(str.toCharArray(), 0, set);
        list.addAll(set);
        return list;
    }

    public void Permutation(char[] str, int index, TreeSet<String> set) {
        if(index == str.length) {
            set.add(String.valueOf(str));
        }
        for(int i = index; i < str.length; ++i) {
            char c = str[index];
            str[index] = str[i];
            str[i] = c;
            Permutation(str, index + 1, set);
            c = str[index];
            str[index] = str[i];
            str[i] = c;
        }
    }
}
