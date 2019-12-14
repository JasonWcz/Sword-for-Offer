package SwordForOffer.Chapter3;

/**
 * @author wcz_j
 * 该题在题集中的要求比之书中略有不同
 * 增加了对算法稳定性的要求(即要求奇偶数各自的相对位置不变)
 * 而书中的方法虽然效率高但是不稳定
 * 并且书中这题实际上在讨论扩展性的问题,与题集目的有些不同
 *
 */
public class Solution_21 {

    /**从左往右找第一个偶数,再从该数后面开始找奇数
     * 1.后面找到了奇数,这个区间所有偶数平移一位,该奇数放到区间第一个
     * 2.没找到奇数,则表示该区间全都是偶数,调整实际上已经完成
     *
     * @param array
     */
    public void reOrderArray(int [] array) {
        if(array == null) {
            return;
        }
        int begin = 0, end, length = array.length;
        while(begin < length) {
            /**碰到偶数*/
            if((array[begin] & 1) == 0) {
                end = begin + 1;
                /**找到后面第一个奇数*/
                while(end < length && (array[end] & 1) == 0) {
                    ++end;
                }
                /**没有遍历完（即后面有奇数）
                 * 那么将begin和end中所有偶数后移
                 * 该奇数放到begin位置*/
                if(end < length) {
                    int odd = array[end];
                    for(; end > begin; --end) {
                        array[end] = array[end - 1];
                    }
                    array[begin] = odd;
                }
                /**遍历到了最后（即后面全为偶数，分组已完成）*/
                else {
                    return;
                }
            }
            ++begin;
        }
        return;
    }
}
