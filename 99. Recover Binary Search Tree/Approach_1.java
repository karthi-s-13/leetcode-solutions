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
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        first = second = prev = null;
        walk(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }
    public void walk(TreeNode current){
        if(current == null) return;
        walk(current.left);
        if(prev != null && prev.val > current.val){
            if(first == null) first = prev;
            second = current;
        }
        prev = current;
        walk(current.right);
    }
}