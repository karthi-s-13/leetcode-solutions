# 226. Invert Binary Tree

### Difficulty: Easy

## Description
Given the root of a binary tree, invert the tree, and return its root.

 
Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]


Example 2:


Input: root = [2,1,3]
Output: [2,3,1]


Example 3:


Input: root = []
Output: []


 
Constraints:


	The number of nodes in the tree is in the range [0, 100].
	-100 <= Node.val <= 100

## Submission Details
- **Status**: Accepted
- **Runtime**: 0 ms
- **Memory**: 42212000
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
    public TreeNode invertTree(TreeNode root) {
        ChangeTree(root);
        return root;
    }
    static void ChangeTree(TreeNode tree){
        if(tree == null) return;
        TreeNode left = tree.left;
        TreeNode right = tree.right;
        tree.left = right;
        tree.right = left;
        ChangeTree(tree.left);
        ChangeTree(tree.right);
    }
}
```
