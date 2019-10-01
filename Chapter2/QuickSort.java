package SwordForOffer.Chapter2;

import com.sun.xml.internal.bind.v2.runtime.SwaRefAdapter;

import java.util.Random;

public class QuickSort {
    public void QuickSortMethod(int [] array,int length, int start, int end) throws Exception {
        if(start == end)
            return;
        int index = Partition(array, length, start, end);
        if(index > start)
            QuickSortMethod(array, length, start, index - 1);
        if(index < end)
            QuickSortMethod(array, length, index + 1, end);
    }
    public int Partition(int [] array,int length, int start, int end) throws Exception {
        if(array.length == 0 || start < 0 || end >= length) throw new Exception("Invalid Parameters");
        int index = new Random().nextInt(end - start) + start;
        Swap(array, index, end); //把对照点换到右边界
        int small = start - 1; //左边界下标
        for(index = start; index < end; ++index){
            if(array[index] < array[end]){
                ++small; //统计比对照点小的数量
                if(small != index) //不相等表示中间有大于对照点的数出现
                    Swap(array, small, index);
            }
        }
        ++small;
        Swap(array, small, end);
        return small;
    }
    public void Swap(int [] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public static void main(String[] args) throws Exception {
        int [] array = {28,51,7,8,90,56,29,22,6,1,2,5,48,3,6,485,465,31};
        int [] a = {1,2};
        QuickSort qs = new QuickSort();
        qs.QuickSortMethod(array,18, 0, 17);
        for(int i = 0; i < 18; ++i){
            System.out.println(array[i]);
        }
    }
}
