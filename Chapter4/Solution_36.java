package SwordForOffer.Chapter4;


public class Solution_36 {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        TreeNode head = ConvertRecursionly(pRootOfTree, null);
        while(head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    /**
     * 递归处理
     * @param pNode
     * @param lastNode
     */
    public static TreeNode ConvertRecursionly(TreeNode pNode, TreeNode lastNode) {
        if(pNode == null) {
            return null;
        }
        TreeNode currentNode = pNode;
        if(currentNode.left != null) {
            lastNode = ConvertRecursionly(currentNode.left, lastNode);
        }
        /**连接前序节点*/
        currentNode.left = lastNode;
        /**前序节点不为空(即不是头节点)则前序的后续为当前节点*/
        if(lastNode != null) {
            lastNode.right = currentNode;
        }
        /**链表最后节点转换成当前节点*/
        lastNode = currentNode;
        /**处理右子树*/
        if(currentNode.right != null) {
            lastNode = ConvertRecursionly(currentNode.right, lastNode);
        }
        return lastNode;
    }
}
