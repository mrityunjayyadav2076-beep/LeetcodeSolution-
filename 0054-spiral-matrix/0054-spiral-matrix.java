class Solution {
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
      
        int[] dir = {0, 1, 0, -1, 0};
      
        int currentRow = 0;
        int currentCol = 0;
        int dirIndex = 0; 
      
        List<Integer> result = new ArrayList<>();
      
        boolean[][] visited = new boolean[rows][cols];
      
        int totalCells = rows * cols;
        for (int count = 0; count < totalCells; count++) 
        {
            
            result.add(matrix[currentRow][currentCol]);
          
            visited[currentRow][currentCol] = true;
          
            int nextRow = currentRow + dir[dirIndex];
            int nextCol = currentCol + dir[dirIndex + 1];
          
            if (nextRow < 0 || nextRow >= rows || 
                nextCol < 0 || nextCol >= cols || 
                visited[nextRow][nextCol]) 
                {
                dirIndex = (dirIndex + 1) % 4;
            }
          
            currentRow += dir[dirIndex];
            currentCol += dir[dirIndex + 1];
        }
      
        return result;
    }
}
