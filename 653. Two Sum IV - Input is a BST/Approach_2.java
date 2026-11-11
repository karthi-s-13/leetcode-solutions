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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> seen = new HashSet<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root != null) stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(seen.contains(k - node.val)) return true;
            seen.add(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return false;
    }
}