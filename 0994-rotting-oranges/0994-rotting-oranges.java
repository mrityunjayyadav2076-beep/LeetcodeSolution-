class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
      
        Deque<int[]> queue = new ArrayDeque<>();
      
        int freshCount = 0;
      
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    freshCount++;
                } else if (grid[row][col] == 2) {
                    queue.offer(new int[] {row, col});
                }
            }
        }
      
        final int[] directions = {-1, 0, 1, 0, -1};
      
        for (int minutes = 1; !queue.isEmpty() && freshCount > 0; minutes++) {
            int levelSize = queue.size();
          
            for (int i = 0; i < levelSize; i++) {
                int[] currentPosition = queue.poll();
                int currentRow = currentPosition[0];
                int currentCol = currentPosition[1];
              
                for (int dir = 0; dir < 4; dir++) {
                    int newRow = currentRow + directions[dir];
                    int newCol = currentCol + directions[dir + 1];
                  
                    if (newRow >= 0 && newRow < rows && 
                        newCol >= 0 && newCol < cols && 
                        grid[newRow][newCol] == 1) {
                      
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[] {newRow, newCol});
                        freshCount--;
                      
                        if (freshCount == 0) {
                            return minutes;
                        }
                    }
                }
            }
        }
      
        return freshCount > 0 ? -1 : 0;
    }
}
