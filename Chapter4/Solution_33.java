package SwordForOffer.Chapter4;

public class Solution_33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        return Verify(sequence, 0, sequence.length);
    }

    /**
     * 对书中代码做了些许改动
     * 书中记录每段的长度来对范围进行确定，
     * 我自己感觉直接确定左右边界的索引值可能更直观。
     * (其中每段区间左右边界采用左闭右开)
     * @param sequence
     * @param begin 当前子树序列的起始点
     * @param end end-1为当前序列的终结点（即根）
     * @return
     */
    public boolean Verify(int [] sequence, int begin, int end) {
        int root = sequence[end - 1];
        /**找到比root大的，理论上应该开始右子树序列*/
        int i = begin;
        for(; i < end - 1; ++i) {
            if(sequence[i] > root){
                break;
            }
        }
        /**从上述的i中开始找右子树序列，当发现比root小时，则必不可能为二叉搜索树*/
        int j = i;
        for(; j < end - 1; ++j) {
            if(sequence[j] < root) {
                return false;
            }
        }
        /**若i>begin则表示有左子树*/
        boolean left = true;
        if(i > begin) {
            left = Verify(sequence, begin, i);
        }
        /**i<end-1则表示有右子树*/
        boolean right = true;
        if(i < end - 1) {
            right = Verify(sequence, i, end - 1);
        }
        return (left && right);
    }
}
