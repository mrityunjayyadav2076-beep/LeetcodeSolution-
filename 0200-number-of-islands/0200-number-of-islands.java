class Solution {

    private char[][] grid;
    private int rows;
    private int cols;
    public int numIslands(char[][] grid) {

        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
      
        int islandCount = 0;
      
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == '1') {
                    dfs(row, col);
                    islandCount++;
                }
            }
        }
      
        return islandCount;
    }

    private void dfs(int row, int col) {
        grid[row][col] = '0';
      
        int[] directions = {-1, 0, 1, 0, -1};
      
        for (int i = 0; i < 4; i++) {
            int newRow = row + directions[i];
            int newCol = col + directions[i + 1];
          
            if (newRow >= 0 && newRow < rows && 
                newCol >= 0 && newCol < cols && 
                grid[newRow][newCol] == '1') {
                dfs(newRow, newCol);
            }
        }
    }
}
