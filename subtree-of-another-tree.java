# Subtree of Another Tree
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
    public boolean isSubtree(TreeNode root, TreeNode subroot) {

        if(root == null) return false;
        if(s(root, subroot)) return true;

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public boolean s(TreeNode root, TreeNode subroot) {
        if(root == null && subroot == null)
        return true;
        if(root == null || subroot == null)
        return false;

        if(root.val != subroot.val) return false;

        boolean l = s(root.left, subroot.left);
        boolean r = s(root.right, subroot.right);

        return l && r;
    }
}