# Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int level = q.size();

            for(int i = 0; i < level; i++) {
                TreeNode node = q.poll();

                if(i == level - 1)
                ans.add(node.val);

                if( node.left != null ) q.offer(node.left);
                if( node.right != null ) q.offer(node.right);
            }   
        }

        return ans;
    }
}