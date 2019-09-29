package SwordForOffer.Chapter2;

public class Solution_10_1 {
    public int Fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int first = 0, second = 1, tmp = 0;
        for(int i = 2; i <= n; i++){
            tmp = first + second;
            first = second;
            second = tmp;
        }
        return tmp;
    }
}
