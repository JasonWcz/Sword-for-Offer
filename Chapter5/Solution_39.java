package SwordForOffer.Chapter5;

import java.util.Random;

public class Solution_39 {

    /**
     * Partition解决方法
     * 使用了Partition()
     * @param array
     * @return
     */
    public int MoreThanHalfNumPartitionSolution(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int middle = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        int index = Partition(array, array.length, start, end);
        while(index != middle) {
            if(index < middle) {
                start = index + 1;
            }
            else {
                end = index - 1;
            }
            index = Partition(array, array.length, start, end);
        }
        int result = array[middle];
        if(!CheckMoreThanHalf(array, result)) {
            return 0;
        }
        return result;
    }

    public int Partition(int[] array, int length, int start, int end) {
        /**这里注意有个相等的情况可能发生
         * 在算法本事中不影响，
         * 但是Random().nextInt(bound)中参数必须为正数*/
        if(start == end) {
            return start;
        }
        System.out.println("start: " + start +" end: "+end);
        int index = new Random().nextInt(end - start) + start;
        Swap(array, index, end);
        int small = start - 1;
        for(index = start; index < end; ++index) {
            if(array[index] < array[end]) {
                ++small;
                if(small != index) {
                    Swap(array, small, index);
                }
            }
        }
        ++small;
        Swap(array, small, end);
        return small;
    }
    public void Swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    /**
     * 根据题目特点的解法
     * 保存一个结果变量和一个计数变量
     * 遍历数组，当有相同数字时，计数+1，否则-1
     * 当计数为0时换下一个数字为结果
     * 由于答案出现的次数大于一半，因此最后留下的一定是所需的答案
     * @param array
     * @return
     */
    public int MoreThanHalfNumSolution(int [] array) {
        if(array == null ||array.length == 0) {
            return 0;
        }
        int result = array[0];
        int count = 1;
        for(int i = 1; i < array.length; ++i) {
            if(array[i] == result) {
                ++count;
            }
            else {
                --count;
            }
            if(count == 0) {
                result = array[i];
                count = 1;
            }
        }
        if(!CheckMoreThanHalf(array, result)) {
            return 0;
        }
        return result;
    }

    /**
     * 用于检查最后的答案是否超过半数
     * @param array
     * @param number
     * @return
     */
    public boolean CheckMoreThanHalf(int[] array, int number) {
        int count = 0;
        for(int i = 0; i < array.length; ++i) {
            if(array[i] == number) {
                ++count;
            }
        }
        if(count * 2 > array.length) {
            return true;
        }
        return false;
    }
}
