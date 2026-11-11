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
class BSTIterator {
    private final Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode current = stack.pop();
        pushLeft(current.right);
        return current.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */