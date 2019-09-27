package SwordForOffer.Chapter2;


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution_8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return null;
        TreeLinkNode nNode = null;
        if(pNode.right != null){
            TreeLinkNode tmp = pNode.right;
            while(tmp.left != null){
                tmp = tmp.left;
            }
            nNode = tmp;
        }
//      第二种(该节点为其父节点的左子节点)和第三种(既无右子树又非第二种)在判断上可以合并
        else if(pNode.next != null){
            TreeLinkNode current = pNode;
            TreeLinkNode parent = pNode.next;
//          假设是第二种情况，则循环第一次判断直接跳出
            while(parent != null && parent.right == current){
                current = parent;
                parent = parent.next;
            }
            nNode = parent;
        }
        return nNode;
    }
}
