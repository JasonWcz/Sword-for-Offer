package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * 判断该二叉树是否是平衡二叉树
 */
public class Solution_55_2 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    /**全局变量，当遍历中一旦有非平衡则置false*/
    boolean isBalance = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return false;
        }
        IsBalance(root);
        return isBalance;
    }

    /**
     * 后序遍历扫描二叉树
     * 每次先判断左右子树，由于是后序，左右子树深度已得出
     * 因此不会重复遍历
     * @param root
     * @return
     */
    public int IsBalance(TreeNode root) {
        if (root == null || !isBalance) {
            return 0;
        }
        int left = IsBalance(root.left);
        int right = IsBalance(root.right);
        if (left - right <= 1 || left - right >= -1) {
            return (left > right ? left : right) + 1;
        }
        isBalance = false;
        return 0;
    }
}
