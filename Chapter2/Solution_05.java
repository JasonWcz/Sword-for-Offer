package SwordForOffer.Chapter2;

public class Solution_05 {
    public String replaceSpace(StringBuffer str) {
        if(str == null || str.length() <= 0) return "";
        int len = str.length(), blank = 0;
        for(int i = 0; i < len; i++){
            if(str.charAt(i) == ' ') ++blank;
        }
        str.setLength(len + blank * 2);
        int p1, p2;
        p1 = len - 1; p2 = len + blank * 2 - 1;
        while(p2 >= 0){
            if(str.charAt(p1) != ' '){
                str.setCharAt(p2, str.charAt(p1));
                --p2;
            }
            else{
                str.setCharAt(p2, '0');
                str.setCharAt(p2 - 1, '2');
                str.setCharAt(p2 - 2, '%');
                p2 -= 3;
            }
            --p1;
        }
        return new String(str);
    }
}
