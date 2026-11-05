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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        int index = 0;
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int sum = 0;
            int size = queue.size();
            index++;
            for(int i=0;i<size;i++){
                TreeNode current = queue.poll();
                sum += current.val;
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            if(maxSum < sum ){
                maxSum = sum;
                level = index;
            }
        }
        return level;
    }
}