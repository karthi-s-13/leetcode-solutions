class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        int minute = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i,j});
                else if (grid[i][j] == 1) fresh++;
            }
        }
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for(int[] dir : direction){
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if (newRow < 0 || newCol < 0 ||
                        newRow >= row || newCol >= col) {
                        continue;
                    }

                    if(grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        fresh--;
                    }
                }
            }
            minute++;
        }
        return fresh == 0 ? minute : -1;
    }
}