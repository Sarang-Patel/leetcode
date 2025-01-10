# Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0 || preorder == null || inorder == null)
        return null;

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        if(preorderStart > preorderEnd || inorderStart > inorderEnd)
        return null;

        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);
        int inorderIndex = -1;
        for(int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder[i] == rootValue) {
                inorderIndex = i;
                break;
            }
        }


        int leftSubArraySize = inorderIndex - inorderStart;

        root.left = helper(preorder, preorderStart + 1, preorderStart + leftSubArraySize, inorder, inorderStart, inorderIndex - 1);
        root.right = helper(preorder, preorderStart + leftSubArraySize + 1, preorderEnd, inorder, inorderIndex + 1, inorderEnd);


        return root;



    }
}