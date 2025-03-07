# Serialize and Deserialize Binary Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialiseTree(root, sb);

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public void serialiseTree(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        serialiseTree(root.left, sb);
        serialiseTree(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",", -1);
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(str));

        return build(queue);
    }

    public TreeNode build(ArrayDeque<String> q) {
        String token = q.poll();
        if(token.equals("#")) {
            return null; 
        }

        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = build(q);
        node.right = build(q);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));