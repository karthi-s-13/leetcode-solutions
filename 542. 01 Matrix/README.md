# 542. 01 Matrix

### Difficulty: Medium

## Description
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.

 
Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]


Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]


 
Constraints:


	m == mat.length
	n == mat[i].length
	1 <= m, n <= 104
	1 <= m * n <= 104
	mat[i][j] is either 0 or 1.
	There is at least one 0 in mat.


 
Note: This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/

## Submission Details
- **Status**: Accepted
- **Runtime**: 15
- **Memory**: 48868000
- **Language**: java

## Code
```java
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] distance = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    distance[i][j] = 0;
                }
                else{
                    distance[i][j] = -1;
                }
            }
        }
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for(int[] dir : directions){
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if(newRow < 0 || newCol < 0 || newRow >= row || newCol >= col) continue;

                if(distance[newRow][newCol] == -1){
                    distance[newRow][newCol] = distance[r][c] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
                
            }
        }
        return distance;
    }
}
```
