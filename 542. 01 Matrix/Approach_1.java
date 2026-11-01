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