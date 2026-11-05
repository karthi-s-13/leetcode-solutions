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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode current = queue.poll();
                list.add(current.val);
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            stack.push(list);
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}