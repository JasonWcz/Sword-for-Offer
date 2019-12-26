package SwordForOffer.Chapter4;

import java.util.ArrayList;


public class Solution_34 {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    static ArrayList<ArrayList<Integer>> result;
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null || target <= 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        result = new ArrayList<ArrayList<Integer>>();
        Find(root, target, 0, new ArrayList<Integer>());
        return result;
    }

    public static void Find(TreeNode root, int target, int sum, ArrayList<Integer> path) {
        sum += root.val;
        path.add(root.val);
        if(target == sum) {
            /**该路径符合*/
            if(root.left == null && root.right == null) {
                result.add((ArrayList<Integer>) path.clone());
            }
        }
        else {
            if(root.left != null) {
                Find(root.left, target, sum, path);
            }
            if(root.right != null) {
                Find(root.right, target, sum, path);
            }
        }
        path.remove(path.size() - 1);
    }

}
