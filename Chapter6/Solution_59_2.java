package SwordForOffer.Chapter6;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wcz_j
 * 定义一个队列并实现方法max()得到队列最大值
 * 要求add(),poll(),max()时间复杂度都为O(1)
 */
public class Solution_59_2{
    private class Element{
        int value;
        int index;
        Element() {}
        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    /**用来确定data和maximums两个队列中的元素是否为同一个*/
    private static int currentIndex = 0;

    private Deque<Element> data = new LinkedList<Element>();
    private Deque<Element> maximums = new LinkedList<Element>();

    /**
     * 向队列中添加一个元素
     * 添加时，需要对maximums中的值进行检查修改
     * 原理同Solution_59_1的滑动窗口
     * @param value
     */
    public void add(int value) {
        while (!maximums.isEmpty() && value >= maximums.peekLast().value) {
            maximums.pollLast();
        }
        Element element = new Element(value, currentIndex);
        data.add(element);
        maximums.add(element);
        ++currentIndex;
    }

    /**
     * 删除第一个元素
     * @throws Exception
     */
    public void poll() throws Exception {
        if (maximums.isEmpty()) {
            throw new Exception("This queue is already empty.");
        }
        if (maximums.peekFirst().index == data.peekFirst().index) {
            maximums.pollFirst();
        }
        data.pollFirst();
    }

    /**
     * 返回队列最大值
     * @return
     * @throws Exception
     */
    public int max() throws Exception {
        if (maximums.isEmpty()) {
            throw new Exception("This queue is already empty.");
        }
        return maximums.peekFirst().value;
    }
}
