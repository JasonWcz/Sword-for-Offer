package SwordForOffer.Chapter2;

public class Solution_14 {
    public int cutRope(int target) {
        if(target < 2) {
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        /**尽可能多剪出3*/
        int t3 = target / 3;
        /**如果最后剪出1,则回收一段3,可以组成2*2*/
        if(target - t3 * 3 == 1) {
            --t3;
        }
        int t2 = (target - t3 * 3) / 2;
        return (int)(Math.pow(3, t3) * Math.pow(2, t2));
    }
}
