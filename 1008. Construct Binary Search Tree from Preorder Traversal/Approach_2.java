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
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        i=0;
        return buildTree(preorder, Integer.MAX_VALUE);
    }
    public TreeNode buildTree(int[] pre, int bound){
        if(i == pre.length || pre[i] > bound) return null;
        TreeNode node = new TreeNode(pre[i++]);
        node.left = buildTree(pre, node.val);
        node.right = buildTree(pre, bound);
        return node;
    }
}