class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int orginalColor = image[sr][sc];

        dfs(image, sr, sc, color, orginalColor);
        return image;
    }
    static void dfs(int[][] image, int r, int c, int color, int orginalColor){
        int row = image.length;
        int col = image[0].length;

        if(r < 0 || c < 0 || r >= row || c >= col) return;

        if(image[r][c] != orginalColor) return;

        image[r][c] = color;
        dfs(image, r - 1, c, color, orginalColor);
        dfs(image, r + 1, c, color, orginalColor);
        dfs(image, r, c - 1, color, orginalColor);
        dfs(image, r, c + 1, color, orginalColor);
    }
}