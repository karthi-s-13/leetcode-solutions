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
    public static List<int[]> nodes = new ArrayList<>();
    public static void collect(TreeNode node, int row, int col){
        if(node == null) return;
        nodes.add(new int[]{col, row, node.val});
        collect(node.left, row + 1, col - 1);
        collect(node.right, row + 1, col + 1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        nodes.clear();
        collect(root, 0, 0);
        nodes.sort((a,b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[2], b[2]));
        List<List<Integer>> res = new ArrayList<>();
        Integer prev = null;
        for(int[] t : nodes){
            if(prev == null || t[0] != prev){
                res.add(new ArrayList<>());
                prev = t[0];
            }
            res.get(res.size() - 1).add(t[2]);
        }
        return res;

    }
}