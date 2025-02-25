# Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        return t(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean t(TreeNode root, long  min, long  max) {
        if(root == null)
        return true;

        if(root.val <= min || root.val >= max)
        return false;

        return t(root.left, min, root.val) && t(root.right, root.val, max);
    }
}