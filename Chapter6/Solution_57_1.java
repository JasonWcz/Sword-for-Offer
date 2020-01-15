package SwordForOffer.Chapter6;

import java.util.ArrayList;

/**
 * @author wcz_j
 * 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 利用递增的特性，双指针指向首尾
 */
public class Solution_57_1 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array == null || array.length == 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                list.add(array[left]);
                list.add(array[right]);
                break;
            } else if (array[left] + array[right] < sum) {
                ++left;
            } else {
                --right;
            }
        }
        return list;
    }
}
