package SwordForOffer.Chapter5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wcz_j
 * 本题求逆序对数量两种方法都可
 * 之前比赛的时候感觉归并代码麻烦，没树状数组的简练，
 * 而且时间效率也差不多，也就没有写过归并的
 * 这次写下归并的，并且复习一波树状数组
 */
public class Solution_51 {
    /**#########################
     * #####1.归并排序解法########
     */

    /**
     * 左右两边数组分别排好序
     * 两头从尾部开始归并，l,r指针分别表示左右两边最后一个数
     * 1.l > r，则l比右边所有数大，因此逆序对数量为右边元素个数，并把l放入辅助数组，l指针前移
     * 2.l < r，当前无逆序对，并把r放入辅助数组，r指针前移
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int [] copy = array.clone();
        return InversePairsSolve(array, copy, 0, array.length - 1);

    }

    /**
     * 注意在进下一层递归时，array和copy参数位置改变
     * 因为在当前层需要对左右排好序的array数组进行归并
     * 因此要用下一层递归来对array进行排序，copy只起到辅助的作用
     * （如该方法不好记，可不更改参数位置，但需要在返回前array复制下copy）
     * @param array 原数组
     * @param copy 辅助数组
     * @param start
     * @param end
     * @return
     */
    public int InversePairsSolve(int [] array, int [] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        int subLen = (end - start) >> 1;

        int left = InversePairsSolve(copy, array, start, start + subLen) % 1000000007;
        int right = InversePairsSolve(copy, array,start + subLen + 1, end) % 1000000007;

        int i = start + subLen;

        int j = end;

        int copyIndex = end;
        int count = 0;

        while (i >= start && j >= start + subLen + 1) {
            if (array[i] > array[j]) {
                copy[copyIndex--] = array[i--];
                count +=  j - start - subLen;
                count %= 1000000007;
            } else {
                copy[copyIndex--] = array[j--];
            }
        }
        for (; i >= start; --i){
            copy[copyIndex--] = array[i];
        }
        for (; j >= start + subLen + 1; --j){
            copy[copyIndex--] = array[j];
        }
        return (left + right + count) % 1000000007;
    }

    /**#########################
     * #####2.树状数组解法########
     */

    /**树状数组容量*/
    private static int CAPACITY = 300000;

    /**array长度*/
    private int LEN;

    /**树状数组*/
    private int [] sum = new int[CAPACITY];

    /**
     * 单点更新
     * @param x
     */
    public void Add(int x) {
        while (x <= LEN) {
            ++sum[x];
            x += x & -x;
        }
    }

    /**
     * 区间和
     * @param x
     * @return
     */
    public int Sum(int x) {
        int result = 0;
        while (x > 0) {
            result += sum[x];
            x -= x & -x;
        }
        return result % 1000000007;
    }

    /**
     * 离散化(牛客的oj不离散化会TLE)
     * 对辅助数组copy排序
     * 再用map记录值与顺序的映射
     * @param array
     * @return
     */
    public int InversePairsTreeSolution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        LEN = array.length;
        int [] copy = array.clone();
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < LEN; ++i) {
            map.put(copy[i], i+1);
        }
        int count = 0;
        for (int i = LEN - 1; i >= 0; --i) {
            count += Sum(map.get(array[i]));
            count %= 1000000007;
            Add(map.get(array[i]));
        }
        return count;
    }
}
