# Count Good Nodes in Binary Tree
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
    public int goodNodes(TreeNode root) {
        if(root == null)
        return 0;

        return s(root, root.val);
    }

    public int s(TreeNode root, int max) {
        if(root == null)
        return 0;


        if(root.val >= max) {
            return 1 + s(root.left, root.val) + s(root.right, root.val);
        }else{
            return s(root.left, max) + s(root.right, max);
        }
    }

    
}