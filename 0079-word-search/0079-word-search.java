class Solution 
{
    private int rows;
    private int cols;
    private String targetWord;
    private char[][] grid;

    public boolean exist(char[][] board, String word) 
    {
        rows = board.length;
        cols = board[0].length;
        this.targetWord = word;
        this.grid = board;
      
        for (int row = 0; row < rows; row++) 
        {
            for (int col = 0; col < cols; col++) 
            {
                if (dfs(row, col, 0)) 
                {
                    return true;
                }
            }
        }
      
        return false;
    }
    private boolean dfs(int row, int col, int charIndex) 
    {

        if (charIndex == targetWord.length() - 1) 
        {
            return grid[row][col] == targetWord.charAt(charIndex);
        }
      
        if (grid[row][col] != targetWord.charAt(charIndex)) 
        {
            return false;
        }

        char originalChar = grid[row][col];
        grid[row][col] = '0';
  
        int[] directions = {-1, 0, 1, 0, -1};
   
        for (int dir = 0; dir < 4; dir++) {
            int nextRow = row + directions[dir];
            int nextCol = col + directions[dir + 1];
 
            if (nextRow >= 0 && nextRow < rows && 
                nextCol >= 0 && nextCol < cols && 
                grid[nextRow][nextCol] != '0' && 
                dfs(nextRow, nextCol, charIndex + 1)) 
                {
                return true;
            }
        }
      
        grid[row][col] = originalChar;
    
        return false;
    }
}
