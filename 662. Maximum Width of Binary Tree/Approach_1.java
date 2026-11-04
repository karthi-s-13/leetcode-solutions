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
    class Pair{
        TreeNode node;
        long index;
        Pair(TreeNode node, long index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int best = 0;
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            long first = queue.peekFirst().index;
            long last = queue.peekLast().index;
            best = Math.max(best,(int) (last - first + 1));
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair current = queue.poll();
                TreeNode node = current.node;
                long k = current.index - first;
                if(node.left != null) queue.offer(new Pair(node.left, 2 * k));
                if(node.right != null) queue.offer(new Pair(node.right, 2 * k + 1));
            }
        }
        return best;
    }
}