package SwordForOffer.Chapter4;

public class Solution_27 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 将root转成镜像
     * @param root
     */
    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        /**左右子树都是空则不用交换，直接返回*/
        if(root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
