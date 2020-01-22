package SwordForOffer.Chapter6;

import java.util.ArrayList;

/**
 * @author wcz_j
 * 树中两个结点的最低公共祖先
 *
 * 主要考察思维发散的能力
 * 1.先考虑是否为二叉树
 *      1.1是二叉树再考虑是否为二叉搜索树(是则根据AVL树特性可解)
 *      1.2不是二叉搜索树解法如下
 * 2.不是二叉树再考虑有无指向父节点的指针
 *      1.1有则找到两个节点，再转化成两个链表找最后公共节点(思路跟下面代码解法相似)
 *      1.2没有则解法如下
 */
public class SolutionLCA {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 找二叉树中两个节点的最低公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        ArrayList<TreeNode> pathP = new ArrayList<TreeNode>();
        getPath(root, p, pathP);
        ArrayList<TreeNode> pathQ = new ArrayList<TreeNode>();
        getPath(root, q, pathQ);
        return getCommonNode(pathP, pathQ);
    }

    /**
     * 搜索到某个节点的路径
     * @param root
     * @param node
     * @param path
     * @return
     */
    public boolean getPath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            path.add(node);
            return true;
        }
        path.add(root);
       if (getPath(root.left, node, path)) {
           return true;
       }
        if (getPath(root.right, node, path)) {
            return true;
        }
        path.remove(root);
        return false;
    }

    /**
     * 查找两条路径的最后一个公共节点
     * @param pathP
     * @param pathQ
     * @return
     */
    public TreeNode getCommonNode(ArrayList<TreeNode> pathP, ArrayList<TreeNode> pathQ) {
        int i = 1;
        TreeNode result = pathP.get(0);
        while (i < pathP.size() && i < pathQ.size()) {
            if (pathP.get(i) == pathQ.get(i)) {
                result = pathP.get(i++);
            } else {
                break;
            }
        }
        return result;
    }
}
