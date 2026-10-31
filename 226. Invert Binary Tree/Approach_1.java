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
    public TreeNode invertTree(TreeNode root) {
        ChangeTree(root);
        return root;
    }
    static void ChangeTree(TreeNode tree){
        if(tree == null) return;
        TreeNode left = tree.left;
        TreeNode right = tree.right;
        tree.left = right;
        tree.right = left;
        ChangeTree(tree.left);
        ChangeTree(tree.right);
    }
}