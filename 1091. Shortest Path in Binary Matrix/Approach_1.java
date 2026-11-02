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