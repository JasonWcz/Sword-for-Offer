package SwordForOffer.Chapter4;

import java.util.ArrayList;
import java.util.Stack;

public class Solution_32_2 {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 之字形打印二叉树
     * 1.当前为奇数行（current=0）
     *   该行节点的子节点，先将左子入栈，再右子入栈
     * 2.当前为偶数行（current=1）
     *   与上述相反
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack[] stacks = new Stack[2];
        stacks[0] = new Stack<TreeNode>();
        stacks[1] = new Stack<TreeNode>();
        int current = 0;
        int next = 1;
        stacks[current].push(pRoot);
        while(!stacks[0].isEmpty() || !stacks[1].isEmpty()) {
            TreeNode tmp = (TreeNode) stacks[current].pop();
            list.add(tmp.val);
            if(current == 0) {
                if(tmp.left != null){
                    stacks[next].push(tmp.left);
                }
                if(tmp.right != null){
                    stacks[next].push(tmp.right);
                }
            }
            else {
                if(tmp.right != null){
                stacks[next].push(tmp.right);
                }
                if(tmp.left != null){
                    stacks[next].push(tmp.left);
                }
            }
            if(stacks[current].isEmpty()) {
                current = 1 - current;
                next = 1 - next;
                result.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return result;
    }

}
