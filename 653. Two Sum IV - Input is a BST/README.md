# 653. Two Sum IV - Input is a BST

### Difficulty: Easy

## Description
Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

 
Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true


Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false


 
Constraints:


	The number of nodes in the tree is in the range [1, 104].
	-104 <= Node.val <= 104
	root is guaranteed to be a valid binary search tree.
	-105 <= k <= 105

## Submission Details
- **Status**: Accepted
- **Runtime**: 4
- **Memory**: 45796000
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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> seen = new HashSet<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root != null) stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(seen.contains(k - node.val)) return true;
            seen.add(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return false;
    }
}
```
