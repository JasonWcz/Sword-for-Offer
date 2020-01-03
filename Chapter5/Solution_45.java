package SwordForOffer.Chapter5;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_45 {
    /**
     * 该题输入为int数组但是最后组成的数字可能超过int范围
     * 用字符串方便拼接
     * 自定义比较器，两个字符串拼接后字典序小的排前面
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) {
            return "";
        }
        String[] sb = new String[numbers.length];
        for(int i = 0; i < numbers.length; ++i) {
            sb[i] = numbers[i]+"";
        }
        /**自定义比较器*/
        Arrays.sort(sb, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String result = "";
        for(int i = 0; i < numbers.length; ++i) {
            result += sb[i];
        }
        return result;
    }
}
