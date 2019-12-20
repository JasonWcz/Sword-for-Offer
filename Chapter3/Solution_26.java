package SwordForOffer.Chapter3;

public class Solution_26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 在root1中寻找与root2根节点相同的节点
     * 找到后用IsSubtree来判断是否为子结构
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null) {
            if(root1.val == root2.val) {
                result = IsSubtree(root1, root2);
            }
            if(!result) {
                result = HasSubtree(root1.left, root2);
            }
            if(!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    /**
     * 判断root2是否为root1的子结构
     * @param root1
     * @param root2
     * @return
     */
    public static boolean IsSubtree(TreeNode root1, TreeNode root2) {
       if(root2 == null) {
           return true;
       }
       if(root1 == null) {
           return false;
       }
       if(root1.val != root2.val) {
           return false;
       }
       return IsSubtree(root1.left, root2.left)
               && IsSubtree(root1.right, root2.right);
    }

}
