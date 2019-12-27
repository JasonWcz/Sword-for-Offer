package SwordForOffer.Chapter4;

public class Solution_37 {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 前序遍历构造序列化
     * @param root
     * @return 序列化后的字符串
     */
    public String Serialize(TreeNode root) {
        if(root == null) {
            return "#!";
        }
        String str = root.val + "!";
        str += Serialize(root.left);
        str += Serialize(root.right);
        return str;
    }

    /**
     * 一个全局变量
     * 用于记录反序列化中当前字符的索引值
     */
    int index = 0;

    /**
     * 针对前序遍历构造的序列化字符串的反序列化
     * 1.分割出当前节点的val值
     * 2.对当前节点左子树进行反序列化
     * 3.对当前节点右子树进行反序列化
     * 注意：进入下一次递归前（或者返回上层递归时）
     *      index指在'!'上
     *      因此在进入下一层时++index
     *      使其指向下个节点val值的首位字符(无论是'#'或者数字)
     * @param str
     * @return 根节点
     */
    public TreeNode Deserialize(String str) {
        if(str.charAt(index) == '#') {
            ++index;
            return null;
        }
        int value = 0;
        for(; index < str.length(); ++index) {
            if(str.charAt(index) != '!') {
                value = value * 10 + (str.charAt(index) - '0');
            }
            else {
                break;
            }
        }
        TreeNode node = new TreeNode(value);
        ++index;
        node.left = Deserialize(str);
        ++index;
        node.right = Deserialize(str);
        return node;
    }
}
