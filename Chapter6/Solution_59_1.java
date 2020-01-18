package SwordForOffer.Chapter6;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wcz_j
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
 *
 * 队头总是当前最大值
 * 后续备选的存在队尾
 * 1.插入队尾时，比当前值小的弹出(小于当前值不可能为最大值)
 * 2.上一步也将与第一个值(之前最大值)比较的操作包含在内，
 *   若比队头也大，则当前队列可清空，当前值为新最大值
 * 3.双端队列中存索引值，方便检查某一位是否属于当前窗口
 *
 * 该题主要学习下书中的代码，比我自己写得更简便、更清晰
 */
public class Solution_59_1 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < size; ++i) {
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.pollLast();
            }
            queue.add(i);
        }
        for (int i = size; i < num.length; ++i) {
            list.add(num[queue.peekFirst()]);
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.pollLast();
            }
            /**队头不在滑动窗口内的弹出*/
            if (!queue.isEmpty() && i - queue.peekFirst() >= size) {
                queue.pollFirst();
            }
            queue.add(i);
        }
        list.add(num[queue.peekFirst()]);
        return list;
    }
}
