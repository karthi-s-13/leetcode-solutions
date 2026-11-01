class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, area(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    public static int area(int[][] grid, int r, int c){
        int row = grid.length;
        int col = grid[0].length;
        if(r < 0 || c < 0 || r >= row || c >= col || grid[r][c] != 1) return 0;
        grid[r][c] = 0;
        return 1+area(grid, r-1, c) + area(grid, r + 1, c) + area(grid, r, c -1) + area(grid, r, c + 1);
    }
}