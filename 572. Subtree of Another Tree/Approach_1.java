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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = null;
        queue.offer(root);
        while(!queue.isEmpty()){
            current = queue.poll();
            if(current.val == subRoot.val && SameTree(current, subRoot)) return true;
            
            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }
        return false;
    }
    static boolean SameTree(TreeNode a, TreeNode b){
        if(a == null &&  b == null) return true;
        if(a == null || b == null) return false;
        if(a.val != b.val) return false;
        return SameTree(a.left, b.left) && SameTree(a.right, b.right);
    }
}