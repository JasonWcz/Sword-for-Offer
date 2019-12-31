package SwordForOffer.Chapter5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Solution_40 {
    /**
     * Partition解法
     * 时间复杂度O(n)
     * 但会修改原数组
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbersPartitionSolution(int [] input, int k) {
        if(input == null || input.length == 0 || k > input.length || k == 0) {
            return new ArrayList<Integer>();
        }
        int start = 0;
        int end = input.length - 1;
        int index = Partition(input, start, end);
        while(index != k -1) {
            if (index < k - 1) {
                start = index + 1;
            }
            else {
                end = index - 1;
            }
            index = Partition(input, start, end);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i <= index; ++i) {
            list.add(input[i]);
        }
        return list;
    }

    public int Partition(int [] input, int start, int end) {
        if (start == end) {
            return start;
        }
        int index = new Random().nextInt(end - start) + start;
        Swap(input, index, end);
        int small = start -1;
        for(index = start; index < end; ++index) {
            if(input[index] < input[end]) {
                ++small;
                if(small != index) {
                    Swap(input, small, index);
                }
            }
        }
        ++small;
        Swap(input, small, end);
        return small;
    }
    public void Swap(int [] input, int x, int y) {
        int tmp = input[x];
        input[x] = input[y];
        input[y] = tmp;
    }

    /**
     * 最大堆解法
     * 用一个k大小的堆来维护最小的k个数
     * 适合海量数据的情况，并且不改变原数组
     * 时间复杂度O(nlogk)
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbersHeapSolution(int [] input, int k) {
        if(input == null || input.length == 0 || k > input.length || k == 0) {
            return new ArrayList<Integer>();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i = 0; i < k; ++i) {
            pq.add(input[i]);
        }
        for(int i = k; i < input.length; ++i) {
            if(pq.peek() > input[i]) {
                pq.poll();
                pq.add(input[i]);
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!pq.isEmpty()) {
            list.add(pq.poll());
        }
        return list;
    }
}
