# 515. Find Largest Value in Each Tree Row

### Difficulty: Medium

## Description
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 
Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]


Example 2:


Input: root = [1,2,3]
Output: [1,3]


 
Constraints:


	The number of nodes in the tree will be in the range [0, 104].
	-231 <= Node.val <= 231 - 1

## Submission Details
- **Status**: Accepted
- **Runtime**: 2
- **Memory**: 47136000
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int maxValue = Integer.MIN_VALUE;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode current = queue.poll();
                if(maxValue < current.val) maxValue = current.val;
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            result.add(maxValue);
        }
        return result;
    }
}
```
