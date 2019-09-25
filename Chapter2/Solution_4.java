package SwordForOffer.Chapter2;

/*
**存在空数组异常
*/
public class Solution_4 {
    public boolean Find(int target, int [][] array) {
        int row, col, len = array.length;
        try {
            row = 0;
            col = len - 1;
            while (row < len && col >= 0) {
                if (array[row][col] > target) col--;
                else if (array[row][col] < target) row++;
                else return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
