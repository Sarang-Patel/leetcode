# Binary Tree Maximum Path Sum
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int GlobalMax;

    public int maxPathSum(TreeNode root) {
        GlobalMax = Integer.MIN_VALUE;
        help(root);
        return GlobalMax;
    }

    public int help( TreeNode root ) {
        if(root == null) return 0;

        int l = Math.max(0, help(root.left));
        int r = Math.max(0, help(root.right)); 
        int total = l + r + root.val;
        GlobalMax = Math.max(GlobalMax, total);

        return l > r ? l + root.val : r + root.val;
    }
}