package SwordForOffer.Chapter2;

public class Solution_13 {
    public int movingCount(int threshold, int rows, int cols) {
        if(rows <= 0 || cols <= 0){
            return 0;
        }
        int[] vis = new int[rows * cols];
        int count = moving(threshold, rows, cols, 0, 0, vis);
        return count;
    }

    public int moving(int threshold, int rows, int cols, int x, int y, int[] vis){
        if(x < 0 || x >= rows || y < 0 || y >= cols){
            return 0;
        }
        int count = 0;
        if(check(threshold, rows, cols, x, y, vis)){
            vis[x * cols + y] = 1;
            count = 1 + moving(threshold, rows, cols, x + 1, y, vis)
                    + moving(threshold, rows, cols, x, y + 1, vis)
                    + moving(threshold, rows, cols, x - 1, y, vis)
                    + moving(threshold, rows, cols, x, y - 1, vis);
        }
        return count;
    }

    public boolean check(int threshold, int rows, int cols, int x, int y, int[] vis){
        if(vis[x * cols + y] == 0 && getSum(x) + getSum(y) <= threshold){
            return true;
        }
        return false;
    }

    public int getSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
