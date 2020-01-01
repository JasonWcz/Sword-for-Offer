package SwordForOffer.Chapter5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_41 {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    /**
     * 1.由于总数据量为奇数时，从最小堆中取值
     *   因此加入新数前，数据量为偶数则将新数插入最小堆；反之则入最大堆
     * 2.要维护最小堆中所有数永远大于最大堆中所有数：
     *   以插入最小堆为例，如果新数小于最大堆的堆顶，
     *   则将其先插入最大堆，再将堆顶转到最小堆；
     *   反之同理。
     * @param num
     */
    public void Insert(Integer num) {
        if(((maxHeap.size() + minHeap.size()) & 1) == 0) {
            if(maxHeap.size() > 0 && num.compareTo(maxHeap.peek()) == -1) {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
            else {
                minHeap.offer(num);
            }
        }
        else {
            if(minHeap.size() > 0 && num.compareTo(minHeap.peek()) == 1) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }
            else {
                maxHeap.offer(num);
            }
        }
    }

    /**
     * 数据量为奇数时从最小堆(即右半边)中取堆顶
     *        偶数时从最大堆(即左半边)和最小堆中分别取堆顶取均值
     * @return
     */
    public Double GetMedian() {
        int size = minHeap.size() + maxHeap.size();
        if(size == 0) {
            try {
                throw new Exception("invalid");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if((size & 1) == 1) {
            return Double.valueOf(minHeap.peek());
        }
        else {
            return Double.valueOf(minHeap.peek()+maxHeap.peek()) / 2;
        }
    }
}
