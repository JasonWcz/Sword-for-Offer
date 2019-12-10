package SwordForOffer.Chapter2;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution_07 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        try {
            if (pre == null || pre.length <= 0) return null;
            int len = pre.length;
            return this.Construct(pre, in, 0, len - 1, 0, len - 1);
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TreeNode Construct(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) throws Exception {
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        root.left = root.right = null;
        if (preStart == preEnd) {
            if (inStart == inEnd && pre[preStart] == in[inStart]) return root; //叶子
            else throw new Exception("Invalid Input");
        }
        int rootPos = inStart;
        while (rootPos <= inEnd && in[rootPos] != rootVal) ++rootPos; //找到root在中序里的位置
        if (rootPos == inEnd && in[rootPos] != rootVal) throw new Exception("Invalid Input");
        int leftLen = rootPos - inStart;
        int leftPreEnd = preStart + leftLen;
        if (leftLen > 0) {
            root.left = Construct(pre, in, preStart + 1, leftPreEnd, inStart, rootPos - 1);
        }
        if (leftLen < preEnd - preStart) {
            root.right = Construct(pre, in, leftPreEnd + 1, preEnd, rootPos + 1, inEnd);
        }
        return root;
    }

}
