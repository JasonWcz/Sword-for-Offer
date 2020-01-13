package SwordForOffer.Chapter6;

/**
 * @author wcz_j
 * 给定一棵二叉搜索树，请找出其中的第k小的结点
 */
public class Solution_54 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    int k;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        this.k = k;
        return KthNodeCore(pRoot);
    }

    /**
     * 中序遍历找到第k个即可
     * @param root
     * @return
     */
    TreeNode KthNodeCore(TreeNode root) {
        TreeNode target = null;
        if (root.left != null) {
            target = KthNodeCore(root.left);
        }
        if (target == null) {
            if (k == 1) {
                target = root;
            }
            k--;
        }
        if (target == null && root.right != null) {
            target = KthNodeCore(root.right);
        }
        return target;
    }
}
