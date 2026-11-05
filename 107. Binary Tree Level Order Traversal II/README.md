# 107. Binary Tree Level Order Traversal II

### Difficulty: Medium

## Description
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

 
Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]


Example 2:


Input: root = [1]
Output: [[1]]


Example 3:


Input: root = []
Output: []


 
Constraints:


	The number of nodes in the tree is in the range [0, 2000].
	-1000 <= Node.val <= 1000

## Submission Details
- **Status**: Accepted
- **Runtime**: 1
- **Memory**: 43820000
- **Language**: java

## Code
```java
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
```
