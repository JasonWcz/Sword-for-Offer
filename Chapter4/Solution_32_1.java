package SwordForOffer.Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_32_1 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 正常按层打印二叉树
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            if(tmp.left != null) {
                queue.add(tmp.left);
            }
            if(tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return list;
    }

    /**
     * 分行打印二叉树
     * @param root
     */
    public void PrintLayer(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        /**设置两个变量
         * 1.nextLevel:记录下一行有几个节点
         * 2.toBePrinted:记录当前行有几个还需要打印*/
        int nextLevel = 0;
        int toBePrinted = 1;
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.print(tmp.val + " ");
            --toBePrinted;
            if(tmp.left != null) {
                queue.add(tmp.left);
                ++nextLevel;
            }
            if(tmp.right != null) {
                queue.add(tmp.right);
                ++nextLevel;
            }
            if(toBePrinted == 0) {
                toBePrinted = nextLevel;
                nextLevel = 0;
                System.out.println();
            }
        }
    }
}
