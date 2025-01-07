# Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        while(!q.isEmpty()) {
            int level = q.size();

            List<Integer> l = new ArrayList<>();

            for(int i = 0; i < level; i++) {
                TreeNode num = q.poll();
                if(num.left != null) q.offer(num.left);
                if(num.right != null) q.offer(num.right);
                l.add(num.val);
            }

            ans.add(l);
        }

        return ans;
    }
}