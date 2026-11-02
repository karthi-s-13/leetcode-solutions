# 1091. Shortest Path in Binary Matrix

### Difficulty: Medium

## Description
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:


	All the visited cells of the path are 0.
	All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).


The length of a clear path is the number of visited cells of this path.

 
Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2


Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4


Example 3:


Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1


 
Constraints:


	n == grid.length
	n == grid[i].length
	1 <= n <= 100
	grid[i][j] is 0 or 1

## Submission Details
- **Status**: Accepted
- **Runtime**: 14
- **Memory**: 47252000
- **Language**: java

## Code
```java
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        while(!queue.isEmpty()){
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int length = current[2];

            if(row == n-1 && col == n-1 ) return length;
            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length ) continue;

                if(grid[newRow][newCol] == 0){
                    grid[newRow][newCol] = 1;
                    queue.offer(new int[]{newRow, newCol, length + 1});
                }
            }
            
        }
        return -1;
    }
}
```
