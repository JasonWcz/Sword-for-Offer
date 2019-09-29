package SwordForOffer.Chapter2;

public class Solution_10_2 {
    public int JumpFloor(int target){
        if(target == 0) return 1;
        if(target == 1) return 1;
        int first = 1, second = 1, tmp = 0;
        for(int i = 2; i <= target; i++){
            tmp = first + second;
            first = second;
            second = tmp;
        }
        return tmp;
    }
}
