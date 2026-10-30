class Solution {
    public int findCircleNum(int[][] m) {
        int n = m.length; 
        int count = 0;
        boolean[] seen = new boolean[n];
        for(int i=0;i<n;i++){
            if(!seen[i]){
                dfs(m, i, seen);
                count++;
            }
        }
        return count;
    }
    static void dfs(int[][] m, int i, boolean[] seen){
        seen[i] = true;
        for(int j=0;j<m.length;j++){
            if(m[i][j] == 1 && !seen[j]){
                dfs(m, j, seen);
            }
        }
    }
}