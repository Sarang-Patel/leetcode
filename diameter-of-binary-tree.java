# Diameter of Binary Tree
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
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        d(root);
        return dia;
    }

    public int d(TreeNode root) {
        if(root == null)
        return 0;

        int l = d(root.left);
        int r = d(root.right);

        dia = Math.max(l + r, dia);

        return Math.max(l,r) + 1;
    }
}