package SwordForOffer.Chapter2;

public class Solution_11 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;
        int left = 0, right = array.length - 1;
        int mid = left;
        while(array[left] >= array[right]){
            if(right - left == 1){
                mid = right;
                break;
            }
            mid = (right + left) / 2;
            if(array[right] == array[left] && array[right] == array[mid])
                return min(array, left, right);
            if(array[mid] >= array[left]) left = mid;
            if(array[mid] <= array[right]) right = mid;
        }
        return array[mid];
    }
    public int min(int [] array, int left, int right){
        int result = array[left];
        for(int i = left; i <= right; ++i){
            if(array[i] < result) result = array[i];
        }
        return result;
    }
}
