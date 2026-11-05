# 1161. Maximum Level Sum of a Binary Tree

### Difficulty: Medium

## Description
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

 
Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.


Example 2:


Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2


 
Constraints:


	The number of nodes in the tree is in the range [1, 104].
	-105 <= Node.val <= 105

## Submission Details
- **Status**: Accepted
- **Runtime**: 11
- **Memory**: 48288000
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
```
