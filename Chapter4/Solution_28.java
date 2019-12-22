package SwordForOffer.Chapter4;


public class Solution_28 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    /**
     * 前序遍历检查是否对称
     * @param root1
     * @param root2
     * @return
     */
    boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        /**上个判断已经判断过两个为空，故如果其中一个为空，必不可能相等*/
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right)
                && isSymmetrical(root1.right, root2.left);
    }
}
